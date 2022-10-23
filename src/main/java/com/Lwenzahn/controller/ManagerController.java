package com.Lwenzahn.controller;

import com.Lwenzahn.controller.dto.ManagerDTO;
import com.Lwenzahn.pojo.Manager;
import com.Lwenzahn.mapper.ManagerMapper;
import com.Lwenzahn.service.ManagerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerMapper managerMapper;
    @Resource
    private ManagerService managerService;
    private Gson gson = new Gson();
    private Manager user;

    // 查询管理员
    @GetMapping
    public String getManager(){
        List<Manager> managers = managerMapper.selectList(null);
        return gson.toJson(managers);
    }

    // query specific user
//    @PostMapping("/queryOne")
//    public String queryOneManager(@RequestBody Manager manager) {
//        ma
//        return gson.toJson(managerMapper.selectOne());
//    }

    // 增加管理员
    @PostMapping("/adding")
    public void addManager(@RequestBody Manager manager){
        managerMapper.insert(manager);
    }

    // 删除管理员
    @PostMapping("/deleting")
    public void deleteManager(@RequestBody Manager manager){
        managerMapper.deleteById(manager);
    }

    // 更新管理员
    @PostMapping("/updating")
    public void updateManager(@RequestBody Manager manager){
        managerMapper.updateById(manager);
    }

    // 登录
    @PostMapping("/login")
    public int login(@RequestBody ManagerDTO managerDTO) {
        String mgrName = managerDTO.getManagerName();
        String pwd = managerDTO.getManagerPassword();
        System.out.println(mgrName);
        System.out.println(pwd);
        if (mgrName == null || pwd == null) return -1;
        if (mgrName.isEmpty() || pwd.isEmpty()) return -1;
        if (mgrName.isBlank() || pwd.isBlank()) return -1;
        int status = managerService.login(mgrName, pwd);
        if (status == 0) {
            QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("manager_name", mgrName).eq("manager_password", pwd);
            user = managerMapper.selectOne(queryWrapper);
        }
        return status;
    }

    @PostMapping("/Logout")
    public void logout(@RequestBody Manager manager) {

    }

    // 查询使用者信息
    @GetMapping("/queryUser")
    public String queryUser() {
        return gson.toJson(user);
    }
}
