package com.niuh.config.role.service;


import com.niuh.config.role.entity.SysPermission;

import java.util.List;

/**
 * Created by hejianhui on 2019/12/20.
 */
public interface ISysPermissionService {

    List<SysPermission> findByUserId(Integer userId);
}
