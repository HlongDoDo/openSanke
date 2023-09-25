package com.study.my.mapper;

import com.study.my.entity.FsmpRwhIopProdInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsmpRwhIopProdInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FsmpRwhIopProdInfo record);

    int insertSelective(FsmpRwhIopProdInfo record);

    FsmpRwhIopProdInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FsmpRwhIopProdInfo record);

    int updateByPrimaryKey(FsmpRwhIopProdInfo record);
}