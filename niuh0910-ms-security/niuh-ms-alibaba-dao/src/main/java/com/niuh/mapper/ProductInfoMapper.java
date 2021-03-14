package com.niuh.mapper;

import com.niuh.entity.ProductInfo;

/**
 * Created by hejianhui on 2019/11/17.
 */
public interface ProductInfoMapper {

    ProductInfo selectProductInfoById(String productNo);
}
