package com.cby.boot.controller;

import com.cby.boot.bean.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

    @PostMapping("/saveuser")
    public Person saveuser(Person person){

        return person;
    }
}
