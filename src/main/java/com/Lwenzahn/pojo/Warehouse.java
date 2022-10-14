package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Warehouse {
    @TableId
    private Integer warehouseId;
//    private String warehouseName;
    private Float warehouseArea;
    private String warehouseAddress;
    private Integer workerId;
    private Character shelfNum;
    private Integer founder;
}
