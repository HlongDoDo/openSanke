package com.study.my.mapper;

import com.study.my.entity.RolePerm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermMapper {
    int insert(RolePerm record);

    int insertSelective(RolePerm record);
}