package com.cby.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cby.boot.bean.Md;
import com.cby.boot.bean.User;

import com.cby.boot.mapper.MdSaveMapper;
import com.cby.boot.mapper.UserMapper;
import com.cby.boot.service.MdSaveService;
import com.cby.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Controller
public class Controllers {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MdSaveService mdSaveService;
    @Autowired
    MdSaveMapper mdSaveMapperr;

    @GetMapping("/cby")
    public String forsuccess(Model model){
        model.addAttribute("cwy","My name is 楚博远");
        model.addAttribute("link","www.bing.com");
        return "success";
    }

    @GetMapping(value = {"/","/login"})
    public String forlogin(){
    return "login";
    }

    //防止表单重复提交
    @PostMapping("login")
    public String main(User user, HttpSession session,Model model){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("username",user.getUsername());
        userQueryWrapper.eq("password",user.getPassword());
        List<User> users = userMapper.selectList(userQueryWrapper);
        String pattern ="\\]\\(.*\\)";
        ArrayList<String> pathList = new ArrayList<>();
        List<String> titleList = mdSaveService.list().stream().map(Md::getTitle).collect(Collectors.toList());
        List<String>  textList = mdSaveService.list().stream().map(Md::getText).collect(Collectors.toList());
        for (String s:textList){
            Matcher matcher = Pattern.compile(pattern).matcher(s);
            if (matcher.find()){
            String path = matcher.group(0).replaceFirst("]", "").replaceFirst("\\(", "").replace(")", "");
                pathList.add(path);
            }

        }

        boolean empty = users.isEmpty();
        if(empty){
            model.addAttribute("msg","账号或密码错误");
        return "login";
        }
        else {
            session.setAttribute("titleList",titleList);
            session.setAttribute("LoginUser",user);
            session.setAttribute("pathList",pathList);
            return "redirect:/main.html";
        }

    }
    //防止表单重复提交
    @GetMapping("main.html")
    public String mianpage(HttpSession session,Model model){
       User loginUser = (User)session.getAttribute("LoginUser");
       List titleList = (List)session.getAttribute("titleList");
       List pathList = (List) session.getAttribute("pathList");
        model.addAttribute("titleList",titleList);
        model.addAttribute("pathList",pathList);
        if(loginUser !=null){
            return "main";
        }
        else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }

    }
}
