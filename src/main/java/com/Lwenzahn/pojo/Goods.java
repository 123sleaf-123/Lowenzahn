package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Goods {
    @TableId
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Float goodsWeight;
    private String goodsImagePath;
}
