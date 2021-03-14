package com.niuh.config.indb;

import com.niuh.config.role.domin.NiuhUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * token增强器,根据自己业务 往token存储业务字段
 * Created by hejianhui on 2020/1/20.
 */

public class NiuhTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        NiuhUser niuhUser = (NiuhUser) authentication.getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();
        final Map<String, Object> retMap = new HashMap<>();

        additionalInfo.put("email",niuhUser.getEmail());
        additionalInfo.put("phone",niuhUser.getPhone());
        additionalInfo.put("userId",niuhUser.getUserId());
        additionalInfo.put("nickName",niuhUser.getNickName());

        retMap.put("additionalInfo",additionalInfo);

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(retMap);

        return accessToken;
    }
}
