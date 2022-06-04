package com.cby.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cby.boot.bean.Md;
import com.cby.boot.bean.Style;
import com.cby.boot.bean.User;
import com.cby.boot.mapper.StyleMapper;
import com.cby.boot.service.MdSaveService;
import com.cby.boot.service.StyleService;
import com.cby.boot.utils.MultipartFileToFileUtils;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.util.List;

@Controller
//@RequestMapping("/editor")
public class editorController {
    @Autowired
    MdSaveService mdSaveService;
    @Autowired
    StyleService styleService;
    @Autowired
    StyleMapper styleMapper;
    @GetMapping("editor.html")
    public String editor(Model model){
        List<Style> list = styleService.list();
        model.addAttribute("style",list);
        return "editor";
    }
    @PostMapping("/saveMd")
    @ResponseBody
    public void md_save( HttpSession session , String md, int id,String title){
        User user=(User)session.getAttribute("LoginUser");
        String username = user.getUsername();
        Md md1 = new Md( md,id,title,username,null);
        mdSaveService.save(md1);

    }

    @PostMapping("/save")
    @ResponseBody
    public String images_up(MultipartFile images,Model model) throws Exception {
        File file = MultipartFileToFileUtils.multipartFileToFile(images);

        BasicCOSCredentials basicCOSCredentials = new BasicCOSCredentials("","");
        ClientConfig clientConfig = new ClientConfig(new Region(""));
//        密钥注入
        COSClient cosClient = new COSClient(basicCOSCredentials,clientConfig);

        String bucketName="";
        String key="Md/"+file.getName();
//        文件注入,存储位置注入
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,key,file);
        cosClient.putObject(putObjectRequest);
//        关闭传输
        cosClient.shutdown();
//        获取图片地址
        URL objectUrl = cosClient.getObjectUrl(bucketName, key);
        String s = objectUrl.toString();

        return s;
    }
    @PostMapping("/style")
    @ResponseBody
    @ApiOperation("返回文章类型")
    public int style(String newStyle,Model model){
        Style style = new Style(newStyle);
        boolean save = styleService.save(style);
        QueryWrapper<Style> styleList = new QueryWrapper<Style>();
        styleList.eq("name",newStyle);
        List<Style> styles = styleMapper.selectList(styleList);
        int id = styles.get(0).getId();
//        System.out.println(id);

        return id;

    }






}
