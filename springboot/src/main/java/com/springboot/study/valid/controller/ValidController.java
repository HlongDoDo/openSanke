package com.springboot.study.valid.controller;

import com.springboot.common.outputentity.ReturnData;
import com.springboot.study.valid.entity.StudentValid;
import org.apache.ibatis.annotations.Insert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangsenwei
 * @Description
 */

@RestController
@RequestMapping("/validController")
public class ValidController {

    @RequestMapping("/inInfo")
    public ReturnData inInfo( @RequestBody @Validated StudentValid studentValid, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        System.out.println("studentValid = " + studentValid);

        return ReturnData.success();
    }
}
