package com.niuh.v1.controller;

import com.niuh.entity.ProductInfo;
import com.niuh.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hejianhui on 2019/11/17.
 */
@RestController
@RequestMapping("/product")
public class ProductInfoController {


    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public Object selectProductInfoById(@PathVariable("productNo") String productNo) {

        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return productInfo;
    }

    @RequestMapping("/gateWay4Header")
    public Object gateWay4Header(@RequestHeader("X-Request-Company") String company) {

        return "gateWay拿到请求头"+company;
    }

    @RequestMapping("/gateWay4RequestParam")
    public Object gateWay4RequestParam(@RequestParam(value = "company",defaultValue = "hehe") String company) {

        return "gateWay拿到请求参数"+company;
    }

    @RequestMapping("/testLimit")
    public String testLimit()  {

        return "testLimit";
    }


}
