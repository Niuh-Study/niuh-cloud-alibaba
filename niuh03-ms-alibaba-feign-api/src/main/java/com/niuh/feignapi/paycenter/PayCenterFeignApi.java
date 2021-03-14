package com.niuh.feignapi.paycenter;

import com.niuh.config.PayCenterFeignConfig;
import com.niuh.entity.PayInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hejianhui on 2020/2/22.
 */
@FeignClient(name = "pay-center",configuration = PayCenterFeignConfig.class)
public interface PayCenterFeignApi {

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo);
}
