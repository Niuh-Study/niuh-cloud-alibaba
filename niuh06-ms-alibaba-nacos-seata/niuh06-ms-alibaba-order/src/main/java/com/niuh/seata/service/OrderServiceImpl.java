package com.niuh.seata.service;

import com.niuh.seata.api.RemoteAccountService;
import com.niuh.seata.api.RemoteStorageService;
import com.niuh.seata.domin.Order;
import com.niuh.seata.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author hejianhui
 * @since 2019-11-25
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RemoteStorageService remoteStorageService;

    @Autowired
    private RemoteAccountService remoteAccountService;

    @Autowired
    private OrderMapper orderMapper;

    @GlobalTransactional(name = "prex-create-order",rollbackFor = Exception.class)
    //@Transactional
    @Override
    public void createOrder(Order order) {
        log.info("当前 XID: {}", RootContext.getXID());
        log.info("下单开始,用户:{},商品:{},数量:{},金额:{}", order.getUserId(), order.getProductId(), order.getCount(), order.getPayMoney());
        //创建订单
        order.setStatus(0);
        orderMapper.saveOrder(order);
        log.info("保存订单{}", order);

        //远程调用库存服务扣减库存
        log.info("扣减库存开始");

        remoteStorageService.reduceCount(order.getProductId(), order.getCount());

        log.info("扣减库存结束");

        //远程调用账户服务扣减余额
        /*log.info("扣减余额开始");
        remoteAccountService.reduceBalance(order.getUserId(), order.getPayMoney());
        log.info("扣减余额结束");*/

        // System.out.println(1 / 0);
        //修改订单状态为已完成
        log.info("修改订单状态开始");
        orderMapper.updateOrderStatusById(order.getId(), 1);
        log.info("修改订单状态结束");

        log.info("下单结束");
    }
}
