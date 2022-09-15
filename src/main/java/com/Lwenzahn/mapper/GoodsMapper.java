package com.Lwenzahn.mapper;

import com.Lwenzahn.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
