package com.Lwenzahn.mapper;

import com.Lwenzahn.pojo.Manager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Mapper
public interface ManagerMapper extends BaseMapper<Manager>{
    List<Manager> findManagerByMap(@Param("map") HashMap<String, String> queryMap);
}
