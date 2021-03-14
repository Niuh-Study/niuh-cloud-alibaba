package com.niuh.v1.controller;

import com.niuh.entity.PayInfo;
import com.niuh.mapper.PayInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hejianhui on 2019/11/17.
 */
@RestController
@Slf4j
public class PayInfoController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PayInfoMapper payInfoMapper;

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        log.info("我被请求了:{}",port);
        return payInfoMapper.selectPayInfoByOrderNo(orderNo);
    }

    @RequestMapping("/save")
    public String savePayInfo(@RequestBody PayInfo payInfo) {
        log.info("payInfo:{}",payInfo);
        return payInfo.getOrderNo();
    }
}
