package com.niuh.mapper;

import com.niuh.entity.PayInfo;

/**
 * Created by hejianhui on 2019/11/20.
 */
public interface PayInfoMapper {

    PayInfo selectPayInfoByOrderNo(String orderNo);
}
