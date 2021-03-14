package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @vlog: 高于生活，源于生活
* @desc: 类的描述:基于Nacos配置中心持久化
* @author: hejianhui
* @createDate: 2019/12/2 14:31
* @version: 1.0
*/
@Component("niuhDegradeRuleNacosProvider")
public class NiuhDegradeRuleNacosProvider implements DynamicRuleProvider<List<DegradeRuleEntity>> {

    @Autowired
    private ConfigService configService;

    @Override
    public List<DegradeRuleEntity> getRules(String appName) throws Exception {
        return NacosConfigUtil.getRuleEntities4Nacos(
                this.configService,
                appName,
                NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX,
                DegradeRuleEntity.class
        );
    }
}
