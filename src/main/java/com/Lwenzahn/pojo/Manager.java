package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Manager {
    @TableId
    private Integer mid;
    private String pwd;
    private String mgrName;
    private Integer power;
    public Manager(String mgrName, String pwd){
        this.mgrName = mgrName;
        this.pwd = pwd;
    }
}
