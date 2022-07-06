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
    public boolean login(String mgrName, String pwd) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        System.out.println(mgrName);
        System.out.println(pwd);
        queryWrapper.eq("mgr_Name", mgrName);
        queryWrapper.eq("pwd", pwd);
        Manager manager = managerMapper.selectOne(queryWrapper);
        return manager != null;
    }
}
