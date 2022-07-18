package com.springboot.study.easypoi.util;

import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import cn.afterturn.easypoi.exception.excel.ExcelExportException;
import cn.afterturn.easypoi.exception.excel.enums.ExcelExportEnum;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author huangsenwei
 * @Description
 */
@Slf4j
public class MyExcelExportServiceUtil extends ExcelExportService {
    public static final double WIDTH = 25.0D;

    public  void myCreateSheet(Workbook workbook, ExportParams entity, Class<?> pojoClass, Collection<?> dataSet) {

        if (log.isDebugEnabled()) {
            log.debug("Excel export start ,class is {}", pojoClass);
            log.debug("Excel version is {}", entity.getType().equals(ExcelType.HSSF) ? "03" : "07");
        }

        if (workbook != null && entity != null && pojoClass != null && dataSet != null) {
            try {
                List<ExcelExportEntity> excelParams = new ArrayList();
                this.i18nHandler = entity.getI18nHandler();

                Field[] fileds = PoiPublicUtil.getClassFields(pojoClass);
                ExcelTarget etarget = pojoClass.getAnnotation(ExcelTarget.class);
                String targetId = etarget == null ? null : etarget.value();
                this.getAllExcelField(entity.getExclusions(), targetId, fileds, excelParams, pojoClass, (List)null, (ExcelEntity)null);
                excelParams.stream().forEach(x->x.setWidth(WIDTH));
                this.createSheetForMap(workbook, entity, excelParams, dataSet);
            } catch (Exception var9) {
                log.error(var9.getMessage(), var9);
                throw new ExcelExportException(ExcelExportEnum.EXPORT_ERROR, var9);
            }
        } else {
            throw new ExcelExportException(ExcelExportEnum.PARAMETER_ERROR);
        }
    }
}
