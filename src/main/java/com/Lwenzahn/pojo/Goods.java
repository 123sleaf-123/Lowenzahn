package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Goods {
    @TableId
    private String goodsId;
    private String goodsType;
    private String goodsName;
    private Float goodsWeight;
    private Integer rowPosition;
    private Integer columnPosition;
    private Boolean isStorage;
    private String goodsImagePath;
}
