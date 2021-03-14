package com.niuh.config.role;

import com.niuh.config.role.domin.NiuhUser;
import com.niuh.config.role.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hejianhui on 2020/1/15.
 */

@RestController
public class UserController {


    @Autowired
    private TokenStore tokenService;

    @RequestMapping("/user/getCurrentUser")
    public SysUser user(@RequestParam("access_token") String accessToken) {
        OAuth2Authentication oAuth2Authentication = tokenService.readAuthentication(accessToken);

        NiuhUser tulingUser = (NiuhUser) oAuth2Authentication.getUserAuthentication().getPrincipal();

        SysUser sysUser = new SysUser();
        sysUser.setId(tulingUser.getUserId());
        sysUser.setEmail(tulingUser.getEmail());
        sysUser.setUsername(tulingUser.getUsername());
        sysUser.setNickname(tulingUser.getNickName());
        return sysUser;
    }

}
