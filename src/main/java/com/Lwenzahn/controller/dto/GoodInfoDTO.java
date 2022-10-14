package com.Lwenzahn.controller.dto;

import lombok.Data;

@Data
public class GoodInfoDTO {
    private String goodsName;
    private String goodsType;
    private Integer warehouseId;
    private String shelfId;
    private Integer positionCode;
    private Integer rowPosition;
    private Integer columnPosition;
}
