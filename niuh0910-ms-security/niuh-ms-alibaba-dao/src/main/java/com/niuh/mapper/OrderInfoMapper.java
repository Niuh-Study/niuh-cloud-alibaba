package com.niuh.mapper;

import com.niuh.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hejianhui on 2019/11/17.
 */
public interface OrderInfoMapper {

    OrderInfo selectOrderInfoByIdAndUserName(@Param("orderNo") String orderNo, @Param("userName") String userName);

    int insertOrder(OrderInfo orderInfo);
}
