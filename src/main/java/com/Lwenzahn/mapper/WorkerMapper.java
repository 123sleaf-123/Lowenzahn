package com.Lwenzahn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Lwenzahn.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {
}
