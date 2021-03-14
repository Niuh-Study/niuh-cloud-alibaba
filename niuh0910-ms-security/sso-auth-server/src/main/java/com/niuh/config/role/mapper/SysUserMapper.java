package com.niuh.config.role.mapper;


import com.niuh.config.role.entity.SysUser;

/**
 * Created by hejianhui on 2019/12/20.
 */
public interface SysUserMapper {

    SysUser findByUserName(String userName);
}
