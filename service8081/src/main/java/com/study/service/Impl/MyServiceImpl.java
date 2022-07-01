package com.study.service.Impl;

import com.alibaba.fastjson.JSON;
import com.study.my.entity.Roles;
import com.study.my.mapper.RolesMapper;
import com.study.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangsenwei
 * @Description
 */
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    RolesMapper mapper;

    @Override
    public String search(int i) {
        Roles roles = mapper.selectByPrimaryKey(i);
        return JSON.toJSONString(roles);
    }
}
