package com.Lwenzahn.controller;


import com.Lwenzahn.mapper.GoodMapper;
import com.Lwenzahn.pojo.Good;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodMapper goodMapper;
    private Gson gson = new Gson();

    //查询货物
    @GetMapping
    public String getGood(){
        List<Good>goods = goodMapper.selectList(null);
        return gson.toJson(goods);
    }
}
