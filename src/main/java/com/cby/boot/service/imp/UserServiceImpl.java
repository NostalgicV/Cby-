package com.cby.boot.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cby.boot.bean.User;
import com.cby.boot.mapper.UserMapper;
import com.cby.boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
