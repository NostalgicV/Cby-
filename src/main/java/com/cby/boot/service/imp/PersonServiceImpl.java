package com.cby.boot.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cby.boot.bean.Person;
import com.cby.boot.mapper.PersonMapper;
import com.cby.boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper,Person> implements PersonService {
  

}
