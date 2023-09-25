package com.study.my.mapper;

import com.study.my.entity.FsmpRwhCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsmpRwhCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FsmpRwhCategory record);

    int insertSelective(FsmpRwhCategory record);

    FsmpRwhCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsmpRwhCategory record);

    int updateByPrimaryKey(FsmpRwhCategory record);
}