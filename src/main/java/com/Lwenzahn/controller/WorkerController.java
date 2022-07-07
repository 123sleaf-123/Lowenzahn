package com.Lwenzahn.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Lwenzahn.mapper.WorkerMapper;
import com.Lwenzahn.pojo.Worker;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerMapper workerMapper;
    private Gson gson = new Gson();

    //查询员工
    @GetMapping
    public String getWorkers(){
        List<Worker> workers = workerMapper.selectList(null);
        return gson.toJson(workers);
    }

    //增加worker
    @PostMapping("/adding")
    public void addWorker(@RequestBody Worker worker){
        workerMapper.insert(worker);
    }

    //删减worker
    @PostMapping("/deleting")
    public void deleteWorker(@RequestBody Worker worker){
        workerMapper.deleteById(worker);
    }

    //修改worker
    @PostMapping("/updating")
    public void updateWorker(@RequestBody Worker worker){
        workerMapper.updateById(worker);
    }
}
