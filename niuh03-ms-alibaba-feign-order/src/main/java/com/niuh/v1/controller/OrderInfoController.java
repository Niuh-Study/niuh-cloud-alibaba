package com.niuh.v1.controller;

import com.niuh.entity.OrderInfo;
import com.niuh.entity.PayInfo;
import com.niuh.entity.ProductInfo;
import com.niuh.feignapi.paycenter.PayCenterFeignApi;
import com.niuh.feignapi.productcenter.ProductCenterFeignApi;
import com.niuh.feignapi.sentinel.ProductCenterFeignApiWithSentinel;
import com.niuh.mapper.OrderInfoMapper;
import com.niuh.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hejianhui on 2019/11/17.
 */
@RestController
public class OrderInfoController {

    @Autowired
    private ProductCenterFeignApi productCenterFeignApi;

    @Autowired
    private PayCenterFeignApi payCenterFeignApi;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) throws InterruptedException {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ProductInfo productInfo = productCenterFeignApi.selectProductInfoById(orderNo);

        if(productInfo == null) {
            return "没有对应的商品";
        }

        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }

    @RequestMapping("/testFeignInterceptor")
    public String testFeignInterceptor() {
        return productCenterFeignApi.getToken4Header();
    }

    @RequestMapping("/getPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payCenterFeignApi.selectPayInfoByOrderNo(orderNo);
    }



}
