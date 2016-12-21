package com.james.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by gaoji on 2016/11/05.
 */
@Controller
public class TestUiCtl {

    @RequestMapping("/uiTest")
    public String  test1(HttpServletRequest request) {
    	request.getSession().setAttribute("name", "gaojian");
    	System.out.println(request.getSession().getAttribute("name"));
        return "index";
    }

//    @RequestMapping("/PageTab")
//    public String test2(String id) {
//        return "PageTab";
//    }
//
//    @RequestMapping("/Page1")
//    public String  test3() {
//        return "Page1";
//    }
//    
//    @RequestMapping("/Page2")
//    public String  test4() {
//        return "Page2";
//    }
//    
//    @RequestMapping("/Page3")
//    public String  test5() {
//        return "Page3";
//    }
}
