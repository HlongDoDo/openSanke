package com.study.function.supplier;

import com.study.easypoi.entity.Student;

import java.util.function.Supplier;

/**
 * @author huangsenwei
 * @Description
 */
public class SupplierMethod {

    public String doSupplierMethod(Supplier<String> supplier){
        String inString = supplier.get();
        System.out.println(inString);

        return inString;
    }


    public void doSupplierMethodParam(Supplier<Student> supplier){
        Student student = supplier.get();
        if (student.getName().equals("kache")){
            student.setFoodImg("kachelogo");
        }

    }
}
