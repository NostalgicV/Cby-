package com.cby.boot.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class Md {
    private int id;
    private String text;
    @TableField(value = "style")
    private Integer style;
    private String title;
    private String u_name;
    private String images;

    public Md(String u_name) {
        this.u_name = u_name;
    }

    public Md(String text, Integer style, String title, String u_name, String images) {
        this.text = text;
        this.style = style;
        this.title = title;
        this.u_name = u_name;
        this.images = images;
    }

    //    public Md(String text, Integer style, String u_name, String images,String) {
//        this.text = text;
//        this.style = style;
//        this.u_name = u_name;
//        this.images = images;
//    }
}
