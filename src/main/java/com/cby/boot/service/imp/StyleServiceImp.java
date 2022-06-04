package com.cby.boot.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cby.boot.bean.Style;
import com.cby.boot.mapper.StyleMapper;
import com.cby.boot.service.StyleService;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImp extends ServiceImpl<StyleMapper, Style> implements StyleService {
}
