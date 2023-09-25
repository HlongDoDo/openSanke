package com.study.my.mapper;

import com.study.my.entity.Brand;
import com.study.my.vo.phone.PhoneInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);


    List<PhoneInfoVo> selectPhoneAllInfo();
}