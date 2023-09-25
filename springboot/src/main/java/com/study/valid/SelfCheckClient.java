package com.study.valid;

import com.study.valid.entity.StudentValid;
import com.study.valid.util.ValidationUtils;

/**
 * @author huangsenwei
 * @Description
 */
public class SelfCheckClient {
    public static void main(String[] args) {
        StudentValid studentValid = new StudentValid();

        studentValid.setAge("10");
        studentValid.setGender("男");
        ValidationUtils.validateEntity(studentValid);
    }
}
