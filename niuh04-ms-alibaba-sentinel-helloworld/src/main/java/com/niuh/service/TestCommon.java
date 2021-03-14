package com.niuh.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * Created by hejianhui on 2020/2/13.
 */
@Service
public class TestCommon {

    @SentinelResource(value = "common")
    public String common() {
        return "common";
    }
}
