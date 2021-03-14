package com.niuh.v1.controller;

import com.niuh.entity.OrderInfo;
import com.niuh.entity.PayInfo;
import com.niuh.entity.ProductInfo;
import com.niuh.mapper.OrderInfoMapper;
import com.niuh.vo.OrderAndPayVo;
import com.niuh.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hejianhui on 2019/11/17.
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ResponseEntity<ProductInfo> responseEntity= restTemplate.getForEntity("http://product-center/selectProductInfoById/"+orderInfo.getProductNo(), ProductInfo.class);

        ProductInfo productInfo = responseEntity.getBody();

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

    @RequestMapping("/getOrderAndPayInfoByOrderNo/{orderNo}")
    public Object getOrderAndPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ResponseEntity<PayInfo> responseEntity= restTemplate.getForEntity("http://pay-center/selectPayInfoByOrderNo/"+orderInfo.getProductNo(), PayInfo.class);
        PayInfo payInfo = responseEntity.getBody();
        if(payInfo == null) {
            return "没有对应的支付信息";
        }

        OrderAndPayVo orderAndPayVo = new OrderAndPayVo();
        orderAndPayVo.setOrderNo(orderNo);
        orderAndPayVo.setProductNo(orderInfo.getProductNo());
        orderAndPayVo.setProductCount(orderInfo.getProductCount());
        orderAndPayVo.setPayNo(payInfo.getPayNo());
        orderAndPayVo.setPayTime(payInfo.getPayTime());
        orderAndPayVo.setUserName(orderInfo.getUserName());

        return orderAndPayVo;

    }



}
