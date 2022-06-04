package com.cby.boot.controller;

import com.cby.boot.mapper.MdSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller

public class MdController {
    @Autowired
    MdSaveMapper mdSaveMapper;

    @GetMapping("/md.html")
    public String fromPage(String title,Model model){
        String text = mdSaveMapper.selectText(title);
        System.out.println(text);
        String pattern ="!\\[.*\\]\\(.*\\)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(text);
        String group = matcher.group(0);
        model.addAttribute("mdText",text);
        return "md";
    }

}
