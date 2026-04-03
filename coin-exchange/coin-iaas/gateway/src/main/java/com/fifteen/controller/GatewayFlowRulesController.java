package com.fifteen.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GatewayFlowRulesController {

    /**
     * 获取当前系统的限流策略
     * @return
     */
    @RequestMapping("/gateway/flow/rules")
    public Set<GatewayFlowRule> getCurrentGateWayFlowRules() {
        return GatewayRuleManager.getRules();
    }

    /**
     * 获取当前系统的api分组
     * @return
     */
    @RequestMapping("/gateway/api/groups")
    public Set<ApiDefinition> getCurrentApiDefinitions() {
        return GatewayApiDefinitionManager.getApiDefinitions();
    }

}
