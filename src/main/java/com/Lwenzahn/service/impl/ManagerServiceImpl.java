package com.Lwenzahn.service.impl;

import com.Lwenzahn.mapper.ManagerMapper;
import com.Lwenzahn.pojo.Manager;
import com.Lwenzahn.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager login(Manager manager) {
        Manager loginManager = managerMapper.login(manager);
        if (loginManager==null){
            return null;
        }else {
            return loginManager;
        }
    }
}
