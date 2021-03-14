package com.niuh.controller;

import com.niuh.entity.ProductInfo;
import com.niuh.mapper.ProductInfoMapper;
import com.niuh.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
    public Result<ProductInfo> selectProductInfoById(@PathVariable("productNo") String productNo,
                                                     //,@RequestHeader("username") String userName,
                                                     @AuthenticationPrincipal String userName) {
        System.out.println(userName);
        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return Result.success(productInfo);
    }


}
