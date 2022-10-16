package com.Lwenzahn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.Lwenzahn.pojo.Warehouse;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {
}
