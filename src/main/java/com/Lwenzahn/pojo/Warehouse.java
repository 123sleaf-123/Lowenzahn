package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Warehouse {
    @TableId
    private Integer whid;
    private String whName;
    private Float area;
    private String address;
}
