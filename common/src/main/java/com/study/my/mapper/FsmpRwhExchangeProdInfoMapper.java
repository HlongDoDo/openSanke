package com.study.my.mapper;

import com.study.my.entity.FsmpRwhExchangeProdInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsmpRwhExchangeProdInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FsmpRwhExchangeProdInfo record);

    int insertSelective(FsmpRwhExchangeProdInfo record);

    FsmpRwhExchangeProdInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FsmpRwhExchangeProdInfo record);

    int updateByPrimaryKeyWithBLOBs(FsmpRwhExchangeProdInfo record);

    int updateByPrimaryKey(FsmpRwhExchangeProdInfo record);
}