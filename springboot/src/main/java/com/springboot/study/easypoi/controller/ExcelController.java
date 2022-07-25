package com.springboot.study.easypoi.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.springboot.common.outputentity.ReturnData;
import com.springboot.common.outputentity.stateenum.OutState;
import com.springboot.study.aspectexception.customizeexception.CommonException;
import com.springboot.study.easypoi.util.ExcelUtil;
import com.springboot.study.easypoi.entity.Student;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsenwei
 * @Description excel使用
 */
@RestController
@RequestMapping("/excelDo")
public class ExcelController {

    @RequestMapping("/importExcel")
    public void importExcel(@RequestParam MultipartFile file) {
        ImportParams params = new ImportParams();
        //从第一行开始解析
        params.setHeadRows(1);
        List<Student> studentList = new ArrayList<>();
        try {
            //解析后每一行转换成Province对象
            studentList = ExcelImportUtil.importExcel(file.getInputStream(), Student.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (studentList.get(0).getFoodImg()!=null){
            System.out.println(" wobushikongde ~~~~");
        }
        System.out.println(studentList);

    }

    @RequestMapping("/hello")
    public String helloWorld() throws CommonException {

        try {
            int i = 1/0 ;
        }catch (Exception e){
            throw new CommonException(OutState.STATE_FAIL);
        }

        return "helloWorld";
    }


    @RequestMapping("/downloadExcel")
    public void getExcel(HttpServletResponse response) throws Exception {
        // 表格名称
        String fileName = "学生信息";
        // 导出的表格title和sheet页名
        ExportParams exportParams = new ExportParams(null, "student");
        // 导出的内容的list
        List<Student> list = getList();
        // 传参是要转换的对象类型，和list
        Workbook workbook = ExcelUtil.exportExcel(exportParams, Student.class, list);
        ExcelUtil.getExportedFile(workbook, fileName, response);
    }

    private List<Student> getList() {

        List<Student> res = new ArrayList<>();
        Student student1 = new Student(1, "天天","");

        Student student2 = new Student(2, "上班","");
        res.add(student1);
        res.add(student2);

        return res;
    }

    @RequestMapping("/getReturnTemplate")
    public  ReturnData<List<Student>> getReturnTemplate(){
        ReturnData<List<Student>> listReturnData = new ReturnData<>();
        List<Student> res = new ArrayList<>();
        Student student1 = new Student(1, "天天","");

        Student student2 = new Student(2, "上班","");
        res.add(student1);
        res.add(student2);

        listReturnData.setData(res);
        listReturnData.setState(OutState.STATE_OK);
        return listReturnData;
    }
}