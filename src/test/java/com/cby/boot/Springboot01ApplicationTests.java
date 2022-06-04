package com.cby.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cby.boot.bean.Person;
import com.cby.boot.bean.User;
import com.cby.boot.mapper.UserMapper;
import com.cby.boot.service.PersonService;
import com.cby.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class Springboot01ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from person");
        log.info("数据:{}",maps);
        log.info("数据类型:{}",dataSource);
    }
    @Test
    void redisTest(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        Object cby = valueOperations.get("abc");
        System.out.println(cby);
    }
    @Test
    void equalsTest() {
//        boolean cby = userService.equals(new User("cby", "12356"));
//        System.out.println(cby);
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
//        objectQueryWrapper.equals(new User("cby","13456"));
        objectQueryWrapper.eq("username","cby");
            objectQueryWrapper.eq("password","23");
//        objectQueryWrapper.like("password","123456");
        List<User> users = userMapper.selectList(objectQueryWrapper);
        boolean empty = users.isEmpty();
        System.out.println(empty);
    }
}
