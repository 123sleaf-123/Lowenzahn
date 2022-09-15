package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Warehouse {
    @TableId
    private Integer warehouseId;
    private Integer founder;
    private Integer workerId;
    private String warehouseName;
    private Float warehouseArea;
    private String warehouseAddress;
}
