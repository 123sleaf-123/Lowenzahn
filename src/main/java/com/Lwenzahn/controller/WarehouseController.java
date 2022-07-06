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

    @GetMapping("/warehouses")
    public String getWarehouses() {
        List<Warehouse> warehouses = warehouseMapper.selectList(null);
        return gson.toJson(warehouses);
    }

    @PostMapping("/warehouses/addWh")
    public void addWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.insert(warehouse);
    }

    @PostMapping("/warehouses/deleteWh")
    public void deleteWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.deleteById(warehouse);
    }

    @PostMapping("/warehouses/updateWh")
    public void updateWarehouse(@RequestBody Warehouse warehouse) {
        warehouseMapper.updateById(warehouse);
    }
}
