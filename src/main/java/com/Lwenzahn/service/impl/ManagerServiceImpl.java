package com.Lwenzahn.service.impl;

import com.Lwenzahn.mapper.ManagerMapper;
import com.Lwenzahn.pojo.Manager;
import com.Lwenzahn.service.ManagerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<Manager> findManagerByMap(HashMap<String, String> queryMap) {
        return managerMapper.findManagerByMap(queryMap);
    }

    @Override
    public int login(String mgrName, String pwd) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manager_name", mgrName);
        if (managerMapper.selectOne(queryWrapper) == null) return 2;
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manager_name", mgrName);
        queryWrapper.eq("manager_password", pwd);
        Manager manager = managerMapper.selectOne(queryWrapper);
        if (manager != null) return 0;
        else return 1;
    }
}
