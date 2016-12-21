package com.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by gaoji on 2016/11/05.
 */
@SpringBootApplication(scanBasePackages="com.james")
public class AppMain {

//    @RequestMapping("/index")
//    public String index(Model model) {
//        return "index";
//    }
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}
