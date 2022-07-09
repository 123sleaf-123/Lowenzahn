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
    @Select("SELECT\n" +
            "g.goods_Name,\n" +
            "g.goods_type,\n" +
            "w.warehouse_id,\n" +
            "s.row_num,\n" +
            "s.column_num,\n" +
            "sto.floor_num,\n" +
            "sto.position_num\n" +
            "FROM\n" +
            "goods g,\n" +
            "shelf s,\n" +
            "storage sto,\n" +
            "warehouse w\n" +
            "WHERE\n" +
            "w.warehouse_id = #{id}\n" +
            "AND\n" +
            "g.goods_id = sto.goods_id\n" +
            "AND\n" +
            "sto.shelf_id = s.shelf_id\n" +
            "AND\n" +
            "w.warehouse_id = s.warehouse_id\n" +
            "AND\n" +
            "sto.is_out_storage = 0;")
    List<GoodInfoDTO> findGoodInfo(@Param("id")Integer whid);
}
