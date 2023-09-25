package com.study.excel.memberRwhController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.study.my.entity.FsmpRwhAppInfo;
import com.study.my.entity.FsmpRwhCategory;
import com.study.my.entity.FsmpRwhExchangeProdInfo;
import com.study.my.entity.FsmpRwhIopProdInfo;
import com.study.my.mapper.FsmpRwhAppInfoMapper;
import com.study.my.mapper.FsmpRwhCategoryMapper;
import com.study.my.mapper.FsmpRwhExchangeProdInfoMapper;
import com.study.my.mapper.FsmpRwhIopProdInfoMapper;
import com.study.my.outoutentity.ReturnData;
import com.study.my.outoutentity.stateenum.OutState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangsenwei
 * @Description 任我换3.0生成数据的sql
 */
@RestController
@RequestMapping("/memberRwhController")
public class MemberRwhController {

    @Resource
    FsmpRwhCategoryMapper categoryMapper;

    @Resource
    FsmpRwhAppInfoMapper appInfoMapper;

    @Resource
    FsmpRwhExchangeProdInfoMapper exchangeProdInfoMapper;

    @Resource
    FsmpRwhIopProdInfoMapper iopProdInfoMapper;


    @RequestMapping("/insertCategoryFromExcel")
    public ReturnData<Object> insertCategoryFromExcel(@RequestPart("file") MultipartFile file) throws IOException {
        List<FsmpRwhCategory> categoryList = EasyExcel.read(file.getInputStream())
                .head(FsmpRwhCategory.class)
                .sheet()
                .doReadSync();

        for (FsmpRwhCategory fsmpRwhCategory : categoryList) {
            categoryMapper.insertSelective(fsmpRwhCategory);
        }
        return new ReturnData<>(OutState.STATE_OK);
    }


    @RequestMapping("/insertAppInfoFromExcel")
    public ReturnData<Object> insertAppInfoFromExcel(@RequestPart("file") MultipartFile file) throws IOException {
        List<FsmpRwhAppInfo> memberList = EasyExcel.read(file.getInputStream())
                .head(FsmpRwhAppInfo.class)
                .sheet()
                .doReadSync();

        for (FsmpRwhAppInfo fsmpRwhAppInfo : memberList) {
            String url = "https://gdzrs.aplusunion.com/dccp-portal/guangdong/views/on/quanyi/img/logo/" + fsmpRwhAppInfo.getLogoUrl();
            fsmpRwhAppInfo.setLogoUrl(url);
            appInfoMapper.insertSelective(fsmpRwhAppInfo);
        }
        return new ReturnData<>(OutState.STATE_OK);
    }


    @RequestMapping("/insertProdInfoFromExcel")
    public ReturnData<Object> insertProdInfoFromExcel(@RequestPart("file") MultipartFile file) throws IOException {
        List<FsmpRwhExchangeProdInfo> prodInfoList = EasyExcel.read(file.getInputStream())
                .head(FsmpRwhExchangeProdInfo.class)
                .sheet()
                .doReadSync();

        for (FsmpRwhExchangeProdInfo exchangeProdInfo : prodInfoList) {
            exchangeProdInfoMapper.insertSelective(exchangeProdInfo);
        }
        return new ReturnData<>(OutState.STATE_OK);
    }

    @RequestMapping("/insertHotInfoFromExcel")
    public ReturnData<Object> insertHotInfoFromExcel(@RequestPart("file") MultipartFile file) throws IOException {
        List<FsmpRwhIopProdInfo> iopProdInfoList = EasyExcel.read(file.getInputStream())
                .head(FsmpRwhIopProdInfo.class)
                .sheet()
                .doReadSync();
//
//        for (FsmpRwhIopProdInfo iopProdInfo : iopProdInfoList) {
//            iopProdInfoMapper.insertSelective(iopProdInfo);
//        }
        Map<String, List<FsmpRwhIopProdInfo>> groupByCollect = iopProdInfoList.stream().collect(Collectors.groupingBy(FsmpRwhIopProdInfo::getIopName));
        Iterator<Map.Entry<String, List<FsmpRwhIopProdInfo>>> entries = groupByCollect.entrySet().iterator();

        ArrayList<FsmpRwhIopProdInfo> insertList = new ArrayList<>();

        while (entries.hasNext()) {

            Map.Entry<String, List<FsmpRwhIopProdInfo>> entry = entries.next();
            List<FsmpRwhIopProdInfo> value = entry.getValue();
            FsmpRwhIopProdInfo outInsertIopInfo = new FsmpRwhIopProdInfo();
            String prodList="";
            for (FsmpRwhIopProdInfo iopProdInfo : value) {
                prodList = prodList +  iopProdInfo.getProdId().trim() + ",";
                outInsertIopInfo.setIopCode(iopProdInfo.getIopCode().trim());
                outInsertIopInfo.setIopName(iopProdInfo.getIopName().trim());
                outInsertIopInfo.setMatchOrder(iopProdInfo.getMatchOrder());
            }
            prodList = prodList.substring(0,prodList.length()-1);
            outInsertIopInfo.setProdId(prodList);
            outInsertIopInfo.setVersionId("member_version_init");
            outInsertIopInfo.setGmtCreateUser("huangsenwei");
            outInsertIopInfo.setGmtModifiedUser("huangsenwei");
            insertList.add(outInsertIopInfo);
        }


        for (FsmpRwhIopProdInfo iopProdInfo : insertList) {
            iopProdInfoMapper.insertSelective(iopProdInfo);
        }

        return new ReturnData<>(OutState.STATE_OK);
    }

    @RequestMapping("/getResource")
    public ReturnData<Object> getReources() throws IOException {
        System.out.println( ResourceUtils.getFile("classpath:scheme.sql").getPath());
        new ClassPathResource("scheme.sql").getFile();
        return new ReturnData<>(OutState.STATE_OK);
    }
}
