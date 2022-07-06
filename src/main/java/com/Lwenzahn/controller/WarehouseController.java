package com.Lwenzahn.controller;

import com.google.gson.Gson;
import com.Lwenzahn.mapper.WarehouseMapper;
import com.Lwenzahn.pojo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseMapper warehouseMapper;
    private Gson gson = new Gson();

    //查询仓库
    @GetMapping
    public String getWarehouses() {
        List<Warehouse> warehouses = warehouseMapper.selectList(null);
        return gson.toJson(warehouses);
    }

    //增加仓库
    @PostMapping("/adding")
    public void addWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.insert(warehouse);
    }

    //删除仓库
    @PostMapping("/deleting")
    public void deleteWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.deleteById(warehouse);
    }

    //更新仓库
    @PostMapping("/updating")
    public void updateWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.updateById(warehouse);
    }
}
