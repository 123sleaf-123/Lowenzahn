package com.Lwenzahn.mapper;

import com.Lwenzahn.pojo.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
}
