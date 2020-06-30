package com.hope.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/webservice/test")
    public void test() {

        System.out.println("==========" + System.currentTimeMillis());
    }

    @GetMapping("/web/test")
    public void test1() {
        System.out.println("==========" + System.currentTimeMillis());
    }
}
