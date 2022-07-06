package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Worker {
    @TableId
    private Integer wkrid;
    private String wkrName;
    private String pwd;
}
