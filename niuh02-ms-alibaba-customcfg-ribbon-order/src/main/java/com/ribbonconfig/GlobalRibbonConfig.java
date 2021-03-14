package com.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.niuh.myrule.NiuhWeightedRule;
import com.niuh.myrule.TheSameClusterPriorityRule;
import com.niuh.myrule.TheSameClusterPriorityWithVersionRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hejianhui on 2019/11/20.
 */
@Configuration
public class GlobalRibbonConfig {

    @Bean
    public IRule theSameClusterPriorityRule() {
        // return new NiuhWeightedRule();
        // return new TheSameClusterPriorityRule();
        return new TheSameClusterPriorityWithVersionRule();
    }
}
