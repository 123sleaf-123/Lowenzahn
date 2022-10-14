package com.Lwenzahn.mapper;

import com.Lwenzahn.controller.dto.GoodInfoDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.Lwenzahn.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    @Select("select \n" +
            "g.goods_name,\n" +
            "g.goods_type,\n" +
            "w.warehouse_id,\n" +
            "s.shelf_id,\n" +
            "s.position_code,\n" +
            "g.row_position,\n" +
            "g.column_position\n" +
            "from \n" +
            "goods g,\n" +
            "shelf s,\n" +
            "warehouse w,\n" +
            "storage s2\n" +
            "where \n" +
            "w.warehouse_id = #{id} and " +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfo(@Param("id")Integer warehouseId);
}
