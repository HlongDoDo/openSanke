package com.study.easypoi.util;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * @author huangsenwei
 * @Description
 */
@Slf4j
public class ExcelUtil {

    /**
     *
     * 方法说明: 指定路径下生成EXCEL文件
     * @return
     */
    public static void getExportedFile(Workbook workbook, String name, HttpServletResponse response) {
        try(BufferedOutputStream fos = new BufferedOutputStream(response.getOutputStream())) {
            String fileName = name + ".xls";
            response.setContentType("application/x-msdownload");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), StandardCharsets.ISO_8859_1 ));
            workbook.write(fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Workbook exportExcel(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet) {
        Workbook workbook = getWorkbook(entity.getType());
         new MyExcelExportServiceUtil().myCreateSheet(workbook, entity, pojoClass, dataSet);
        return workbook;
    }
    private static Workbook getWorkbook(ExcelType type) {
        return (ExcelType.HSSF.equals(type) ? new HSSFWorkbook() : new XSSFWorkbook());
    }


}
