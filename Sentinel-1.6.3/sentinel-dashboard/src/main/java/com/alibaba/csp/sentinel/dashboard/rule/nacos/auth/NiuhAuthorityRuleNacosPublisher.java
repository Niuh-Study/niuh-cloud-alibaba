/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos.auth;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @vlog: 高于生活，源于生活
* @desc: 类的描述:sentinel 发布规则保存到nacos上
* @author: hejianhui
* @createDate: 2019/12/2 14:48
* @version: 1.0
*/
@Component("niuhAuthorityRuleNacosPublisher")
public class NiuhAuthorityRuleNacosPublisher implements DynamicRulePublisher<List<AuthorityRuleEntity>> {

    @Autowired
    private ConfigService configService;

    @Override
    public void publish(String app, List<AuthorityRuleEntity> rules) throws Exception {
        NacosConfigUtil.setRuleString2Nacos(
            this.configService,
            app,
            NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX,
            rules
        );
    }
}
