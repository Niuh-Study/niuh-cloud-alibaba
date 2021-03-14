package com.niuh.v1.controller;

import com.niuh.entity.OrderInfo;
import com.niuh.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hejianhui on 2020/2/13.
 */
@RestController
public class FirstSentinelAppController {


    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @RequestMapping("/queryOrderById/{orderNo}")
    public Object queryOrderById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }
        return orderInfo;
    }

}
