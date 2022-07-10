package com.Lwenzahn.service;

import com.Lwenzahn.pojo.Manager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public interface ManagerService {
    List<Manager> findManagerByMap(HashMap<String, String> queryMap);

    int login(String mgrName, String pwd);
}
