package com.Lwenzahn.service;

import com.Lwenzahn.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;

@Mapper
public interface ManagerService {
    Manager login(Manager manager);
}
