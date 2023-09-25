package com.study.redirect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author huangsenwei
 * @Description
 */
@RequestMapping("/redirect")
@RestController
public class RedirectController {

    @RequestMapping("/toRedirect")
    public void  doRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://baidu.com");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println("请根据springBean的定义的"+scanner.next()+"知识点，出5题java初级工程师的选择题，附上答案和解析");
        }
    }
}
