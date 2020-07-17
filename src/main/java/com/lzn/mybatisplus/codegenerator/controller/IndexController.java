package com.lzn.mybatisplus.codegenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("success")
    @ResponseBody
    public String test(){
        return "success";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
