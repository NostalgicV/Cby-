package com.cby.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "from/form_layouts";
    }
    @PostMapping ("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
log.info("上传的信息: email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);
if(!headerImg.isEmpty()){
    String originalFilename = headerImg.getOriginalFilename();
    headerImg.transferTo(new File("D:\\桌面\\"+originalFilename));
}
        return "editor";
    }
}
