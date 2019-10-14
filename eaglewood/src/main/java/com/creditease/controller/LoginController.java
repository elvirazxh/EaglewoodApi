package com.creditease.controller;/**
 * Created by admin on 2019/8/22.
 */

import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.dao.UserInfoMapper;
import com.creditease.mybatis.pojo.UserInfo;
import com.creditease.mybatis.pojo.UserInfoExample;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @createTime 2019/8/22 16:34
 * @description
 */
@RestController
@CrossOrigin
//@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @PostMapping(value = "/loginFunc")
//    public Map<String,Object>  loginFunc(@RequestBody UserInfo user){
//        user = userInfoMapper.selectByPrimaryKey(1);
//        System.out.println(user.getUsername());
//
//        Map<String,Object> map = new HashMap<>(6) ;
//        if("zhaoxuhua".equals(user.getUsername())&&"123456".equals(user.getPassword())){
//            map.put("flag",true) ;
//            map.put("msg","登录成功") ;
//            return map ;
//        }
//        map.put("flag","false") ;
//        map.put("msg","用户名或密码错误") ;
//        System.out.println("------登录测试------");
//        return map ;
//
//    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, ModelMap map) {
        HttpSession sessoin = request.getSession();
        if (sessoin.getAttribute("username") != null) {
            map.addAttribute("host", "Hello");
            map.addAttribute("user", "User: " + sessoin.getAttribute("username"));
            return "index";
        } else {
            //若未登陆则直接跳转至登陆界面
            return "redirect:/login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loginFunc",method = RequestMethod.POST)
//    @PostMapping(value = "/loginFunc")
    public String  loginFunc(HttpServletRequest request,UserInfo loginUser,@RequestBody Map map){

        String username =(String) map.get("username");
        String password =(String) map.get("password");
        System.out.println("转换为JSON对象：" + username + password);


//        String data = request.getParameter("data");
//        System.out.println("获取提交数据：" + data);
//        JSONObject jsonData = JSONObject.parseObject(data);
//        String username = jsonData.get("username").toString();
//        String password = jsonData.get("password").toString();
//        System.out.println("转换为JSON对象：" + username + password);

        boolean check;
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        if(userInfoList.size()==0){
            throw new RuntimeException("获取登录信息失败!");
        }

        loginUser = userInfoList.get(0);
        if (loginUser != null) {
            if (loginUser.getPassword().equals(password))
                check = true;
            else
                check = false;
        } else {
            System.out.println(username + "用户不存在！");
            return "404";
        }

        if (check) {
            HttpSession sessoin = request.getSession();
            sessoin.setAttribute("username", username);
            sessoin.setAttribute("password", password);
            return "success";
        } else {
            System.out.println("密码不正确！" + loginUser.getPassword() + password);
            return "error";
        }

    }




}
 
    