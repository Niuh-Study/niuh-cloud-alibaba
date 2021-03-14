package com.niuh.config.role.service;


import com.niuh.config.role.entity.SysUser;

/**
 * Created by hejianhui on 2019/12/20.
 */
public interface ISysUserService {

    SysUser getByUsername(String username);
}
