package com.study.my.mapper;

import com.study.my.entity.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer roleId);
    List<Roles> selectAllRecord();

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}