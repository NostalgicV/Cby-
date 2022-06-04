package com.cby.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cby.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
