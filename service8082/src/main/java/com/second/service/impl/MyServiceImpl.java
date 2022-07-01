package com.second.service.impl;

import com.alibaba.fastjson.JSON;
import com.second.service.MyService;
import com.study.my.entity.Roles;

import org.springframework.stereotype.Service;

/**
 * @author huangsenwei
 * @Description
 */
@Service
public class MyServiceImpl implements MyService {

    @Override
    public String search(int i) {
        Roles roles = new Roles();
        roles.setRoleId(10);
        roles.setRoleName("999");

        return JSON.toJSONString(roles);
    }
}
