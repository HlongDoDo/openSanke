package com.study.pdf.service.controller;

import com.study.pdf.service.TryService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author huangsenwei
 * @Description
 */
@RequestMapping("/ppooiii")
@RestController
public class TryController {

    @Resource
    TryService tryService;

    @RequestMapping("/ppooiii")
    public void yy() throws IOException {
       new ClassPathResource("/schema.sql").getFile();
        tryService.doS();
    }
}
