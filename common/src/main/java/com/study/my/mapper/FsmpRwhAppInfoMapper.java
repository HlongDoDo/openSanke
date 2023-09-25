package com.study.my.mapper;

import com.study.my.entity.FsmpRwhAppInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsmpRwhAppInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FsmpRwhAppInfo record);

    int insertSelective(FsmpRwhAppInfo record);

    FsmpRwhAppInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsmpRwhAppInfo record);

    int updateByPrimaryKeyWithBLOBs(FsmpRwhAppInfo record);

    int updateByPrimaryKey(FsmpRwhAppInfo record);


}