package com.niuh.mapper;

import com.niuh.entity.OrderInfo;

/**
 * Created by hejianhui on 2019/11/17.
 */
public interface OrderInfoMapper {

    OrderInfo selectOrderInfoById(String orderNo);
}
