package com.alibaba.csp.sentinel.dashboard.rule.nacos.systemrule;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @vlog: 高于生活，源于生活
* @desc: 类的描述:系统规则提供类
* @author: hejianhui
* @createDate: 2019/12/2 19:17
* @version: 1.0
*/
@Component("niuhSysRuleNacosProvider")
public class NiuhSysRuleNacosProvider implements DynamicRuleProvider<List<SystemRuleEntity>> {

    @Autowired
    private ConfigService configService;

    @Override
    public List<SystemRuleEntity> getRules(String appName) throws Exception {
        return NacosConfigUtil.getRuleEntities4Nacos(
                configService,
                appName,
                NacosConfigUtil.SYSTEM_FULE_DATA_ID_POSTFIX,
                SystemRuleEntity.class
        );
    }
}
