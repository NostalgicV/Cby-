package com.cby.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@TableName("person")
@Data
public class Person {

    private Long id;
    private String name;
    private Integer age;
    private Date birth;
    private Pet pet;

}
