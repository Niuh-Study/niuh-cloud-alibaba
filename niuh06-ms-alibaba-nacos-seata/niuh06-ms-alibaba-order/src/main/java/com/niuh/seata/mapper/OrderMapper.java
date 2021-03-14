package com.niuh.seata.mapper;

import com.niuh.seata.domin.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hejianhui on 2019/12/9.
 */
public interface OrderMapper {

    int saveOrder(Order order);

    int updateOrderStatusById(@Param("orderId") Integer orderId,@Param("status") Integer orderStatus);
}
