package com.Lwenzahn.controller;


import com.Lwenzahn.controller.dto.GoodInfoDTO;
import com.Lwenzahn.mapper.GoodsMapper;
import com.Lwenzahn.pojo.Goods;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;
    private Gson gson = new Gson();

    //查询货物
    @GetMapping
    public String getGood(){
        List<Goods>goods = goodsMapper.selectList(null);
        return gson.toJson(goods);
    }

    @GetMapping("/queryGoodsTypes")
    public String getGoodType(){
        List<String>types = goodsMapper.findGoodType();
        return gson.toJson(types);
    }

    // Query goods details
    @GetMapping("/queryGoods")
    public String getGoods() {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfo();
        return gson.toJson(goodInfoDTOS);
    }

    // Query goods details by the warehouse id
    @PostMapping("/queryGoodsByWarehouse")
    public String getGoodsInWarehouse(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByWarehousesId(goodInfoDTO.getWarehouseId());
        return gson.toJson(goodInfoDTOS);
    }

    // Query goods details by the good name
    @PostMapping("/queryGoodsByName")
    public String getGoodsByName(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByGoodName(goodInfoDTO.getGoodsName());
        return gson.toJson(goodInfoDTOS);
    }

    // Query goods details by the good name including specific string
    @PostMapping("/queryGoodsByNameInclude")
    public String getGoodsByNameInclude(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByGoodNameInclude("%" + goodInfoDTO.getGoodsName() + "%");
        return gson.toJson(goodInfoDTOS);
    }

    // Query goods details by the good name including specific string
    @PostMapping("/queryGoodsByType")
    public String getGoodsByType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByGoodType(goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByWarehousesAndName")
    public String getGoodsByWarehousesAndName(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.
                findGoodInfoByWarehousesIdAndGoodName(goodInfoDTO.getWarehouseId(), goodInfoDTO.getGoodsName());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByWarehousesAndNameInclude")
    public String getGoodsByWarehousesAndNameInclude(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.
                findGoodInfoByWarehousesIdAndGoodNameInclude(goodInfoDTO.getWarehouseId(),
                        "%" + goodInfoDTO.getGoodsName() + "%");
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByWarehousesAndType")
    public String getGoodsByWarehousesAndType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.
                findGoodInfoByWarehousesIdAndGoodType(goodInfoDTO.getWarehouseId(), goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByNameAndType")
    public String getGoodsByNameAndType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.
                findGoodInfoByGoodNameAndGoodType(goodInfoDTO.getGoodsName(), goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByNameIncludeAndType")
    public String getGoodsByNameIncludeAndType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.
                findGoodInfoByGoodNameIncludeAndGoodType("%" + goodInfoDTO.getGoodsName() + "%", goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByWarehousesNameIncludeAndType")
    public String getGoodsByWarehousesNameIncludeAndType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByWarehousesIdGoodNameIncludeAndGoodType(
                goodInfoDTO.getWarehouseId(), "%" + goodInfoDTO.getGoodsName() + "%", goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }

    @PostMapping("/queryGoodsByWarehousesNameAndType")
    public String getGoodsByWarehousesNameAndType(@RequestBody GoodInfoDTO goodInfoDTO) {
        List<GoodInfoDTO> goodInfoDTOS = goodsMapper.findGoodInfoByWarehousesIdGoodNameAndGoodType(
                goodInfoDTO.getWarehouseId(), goodInfoDTO.getGoodsName(), goodInfoDTO.getGoodsType());
        return gson.toJson(goodInfoDTOS);
    }
}
