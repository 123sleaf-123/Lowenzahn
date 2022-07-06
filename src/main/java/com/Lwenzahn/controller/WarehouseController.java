package com.Lwenzahn.controller;

import com.google.gson.Gson;
import com.Lwenzahn.mapper.WarehouseMapper;
import com.Lwenzahn.pojo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class WarehouseController {
    @Autowired
    private WarehouseMapper warehouseMapper;
    private Gson gson = new Gson();

    //查询仓库
    @GetMapping("/warehouses")
    public String getWarehouses() {
        List<Warehouse> warehouses = warehouseMapper.selectList(null);
        return gson.toJson(warehouses);
    }

    //增加仓库
    @PostMapping("/warehouses/adding")
    public void addWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.insert(warehouse);
    }

    //删除仓库
    @PostMapping("/warehouses/deleting")
    public void deleteWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.deleteById(warehouse);
    }

    //更新仓库
    @PostMapping("/warehouses/updating")
    public void updateWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.updateById(warehouse);
    }
}
