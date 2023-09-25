package com.study.function.supplier;

import com.alibaba.fastjson.JSON;
import com.study.easypoi.entity.Student;


/**
 * @author huangsenwei
 * @Description
 */
public class SupplierClient {
    public static void main(String[] args) {
        SupplierMethod supplierMethod = new SupplierMethod();
        supplierMethod.doSupplierMethod(() -> "supplier study");


        Student student = new Student(10, "kache", "long");
        supplierMethod.doSupplierMethodParam(()->student);
        System.out.println(JSON.toJSONString(student));

    }
}
