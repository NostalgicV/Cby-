package com.cby.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cby.boot.bean.Md;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MdSaveMapper extends BaseMapper<Md> {

    public String selectText(String title);
}
