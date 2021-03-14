package com.niuh.controller;

import com.niuh.entity.OrderInfo;
import com.niuh.mapper.OrderInfoMapper;
import com.niuh.vo.OrderQo;
import com.niuh.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hejianhui on 2019/11/17.
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoByIdAndUserName")
    public Result<OrderInfo> selectOrderInfoByIdAndUserName(@RequestBody OrderQo orderQo) {
        log.info("orderNo:{},userName:{}",orderQo.getOrderNo(),orderQo.getUserName());
        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoByIdAndUserName(orderQo.getOrderNo(),orderQo.getUserName());
        if(null == orderInfo) {
            return Result.fail("根据订单ID:"+orderQo.getOrderNo()+"没有查询到订单详情信息");
        }
        return Result.success(orderInfo);
    }

    @RequestMapping("/saveOrder")
    public Result saveOrder(@RequestBody  OrderInfo orderInfo) {
        String orderNo = String.valueOf(System.currentTimeMillis());
        orderInfo.setOrderNo(orderNo);
        log.info("保存订单:{}",orderInfo.toString());
        orderInfoMapper.insertOrder(orderInfo);
        return Result.success(orderNo);
    }


}
