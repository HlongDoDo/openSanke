package com.study.start.service.Impl;

import com.alibaba.fastjson.JSON;
import com.study.my.entity.Brand;
import com.study.my.entity.Roles;
import com.study.my.mapper.BrandMapper;
import com.study.my.mapper.RolesMapper;
import com.study.my.vo.phone.ModelInfo;
import com.study.my.vo.phone.OutDataInfo;
import com.study.my.vo.phone.PhoneInfoVo;
import com.study.start.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangsenwei
 * @Description
 */
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    RolesMapper mapper;

    @Autowired
    BrandMapper brandMapper;
    @Override
    public String search(int i) {
        Roles roles = mapper.selectByPrimaryKey(i);
        return JSON.toJSONString(roles);
    }

    @Override
    public String searchPhoneInfo() {
        List<PhoneInfoVo> phoneInfoVos = brandMapper.selectPhoneAllInfo();
        System.out.println(phoneInfoVos.size());
        for (PhoneInfoVo phoneInfoVo : phoneInfoVos) {
            System.out.println(phoneInfoVo.getBrand());
            String keyWordString =  phoneInfoVo.getKeyWordName() + "、" + phoneInfoVo.getBrand();
            List<String> keyWordList = Arrays.asList(keyWordString.split("、"));

            phoneInfoVo.setKeyword(keyWordList);
            phoneInfoVo.setKeyWordName(null);

            List<String> collect = phoneInfoVo.getModelList().stream().map(ModelInfo::getModelName).collect(Collectors.toList());
            phoneInfoVo.setModel(collect);
            phoneInfoVo.setModelList(null);
        }
        OutDataInfo outDataInfo = new OutDataInfo();
        outDataInfo.setData(phoneInfoVos);
        return JSON.toJSONString(outDataInfo);
    }
}
