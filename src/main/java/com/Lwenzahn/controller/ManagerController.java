package com.Lwenzahn.controller;

import com.Lwenzahn.mapper.ManagerMapper;
import com.Lwenzahn.pojo.Manager;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class ManagerController {
    @Autowired
    private ManagerMapper managerMapper;
    private Gson gson = new Gson();

    //查询管理员
    @GetMapping("/manager")
    public String getManager(){
        List<Manager> managers = managerMapper.selectList(null);
        return gson.toJson(managers);
    }

    //增加管理员
    @PostMapping("/manager/adding")
    public void addManager(@RequestBody Manager manager){
        managerMapper.insert(manager);
    }

    //删除管理员
    @PostMapping("/manager/deleting")
    public void deleteManager(@RequestBody Manager manager){
        managerMapper.deleteById(manager);
    }

    //更新管理员
    @PostMapping("/manager/updating")
    public void updateManager(@RequestBody Manager manager){
        managerMapper.updateById(manager);
    }
}
