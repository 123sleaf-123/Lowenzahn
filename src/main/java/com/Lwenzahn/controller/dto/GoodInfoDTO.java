package com.Lwenzahn.controller.dto;

import lombok.Data;

@Data
public class GoodInfoDTO {
    private String goodsName;
    private String goodsType;
    private String warehouseId;
    private String rowNum;
    private String columnNum;
    private String floorNum;
    private String positionNum;
}
