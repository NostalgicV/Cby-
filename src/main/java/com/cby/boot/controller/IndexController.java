package com.cby.boot.controller;

import com.cby.boot.bean.Person;
import com.cby.boot.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class IndexController {

    final
    PersonService personService;


    public IndexController(PersonService personService) {
        this.personService = personService;
    }
    @ResponseBody
    @GetMapping("/person")
    public Person getById(@RequestParam("id") long id){


        return null;
    }


}
