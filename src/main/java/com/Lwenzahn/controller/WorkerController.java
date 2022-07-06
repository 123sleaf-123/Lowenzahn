package com.Lwenzahn.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Lwenzahn.mapper.WorkerMapper;
import com.Lwenzahn.pojo.Worker;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class WorkerController {
    @Autowired
    private WorkerMapper workerMapper;
    private Gson gson = new Gson();

    //查询接口
    @GetMapping("/worker/query")
    public String getWorkers(){
        List<Worker> workers = workerMapper.selectList(null);
        return gson.toJson(workers);
    }

    //增加worker
    @PostMapping("/worker/adding")
    public void addWorker(@RequestBody Worker worker){
        workerMapper.insert(worker);
    }

    //删减worker
    @PostMapping("/worker/deleting")
    public void deleteWorker(@RequestBody Worker worker){
        workerMapper.deleteById(worker);
    }

    //修改worker
    @PostMapping("worker/updating")
    public void updateWorker(@RequestBody Worker worker){
        workerMapper.updateById(worker);
    }
}
