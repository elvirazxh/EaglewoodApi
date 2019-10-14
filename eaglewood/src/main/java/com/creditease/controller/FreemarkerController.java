//package com.creditease.controller;/**
// * Created by admin on 2019/8/5.
// */
//
//import com.creditease.utils.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @author
// * @createTime 2019/8/5 17:33
// * @description
// */
//
//@Controller
//@RequestMapping("ftl")
//public class FreemarkerController {
//
//    @Autowired
//    private Resource resource;
//
//    @RequestMapping("/index")
//    public String index(ModelMap map){
//        map.addAttribute("resource",resource);
//        return "freemarker/index";
//    }
//
//    @RequestMapping("center")
//    public String center(){
//        return "freemarker/center/center";
//    }
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//