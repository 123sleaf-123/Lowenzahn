package com.Lwenzahn.mapper;

import com.Lwenzahn.controller.dto.GoodInfoDTO;
import com.Lwenzahn.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
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
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfo();

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
    List<GoodInfoDTO> findGoodInfoByWarehousesId(@Param("id") Integer warehouseId);

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
            "g.goods_name = #{name} and " +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByGoodName(@Param("name") String goodName);

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
            "g.goods_name like #{name} and " +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByGoodNameInclude(@Param("name") String str);

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
            "g.goods_type = #{type} and " +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByGoodType(@Param("type") String goodType);

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
            "w.warehouse_id = #{id} and \n" +
            "g.goods_name = #{name} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByWarehousesIdAndGoodName(@Param("id") Integer warehouseId, @Param("name") String goodName);

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
            "w.warehouse_id = #{id} and \n" +
            "g.goods_name like #{name} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByWarehousesIdAndGoodNameInclude(@Param("id") Integer warehouseId, @Param("name") String str);

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
            "w.warehouse_id = #{id} and \n" +
            "g.goods_type = #{type} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByWarehousesIdAndGoodType(@Param("id") Integer warehouseId, @Param("type") String goodType);

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
            "g.goods_name = #{name} and \n" +
            "g.goods_type = #{type} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByGoodNameAndGoodType(@Param("name") String goodName, @Param("type") String goodType);

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
            "g.goods_name like #{name} and \n" +
            "g.goods_type = #{type} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByGoodNameIncludeAndGoodType(@Param("name") String str, @Param("type") String goodType);

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
            "w.warehouse_id = #{id} and \n" +
            "g.goods_name = #{name} and \n" +
            "g.goods_type = #{type} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByWarehousesIdGoodNameAndGoodType(@Param("id") Integer warehouseId,
                                                                    @Param("name") String goodName,
                                                                    @Param("type") String goodType);

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
            "w.warehouse_id = #{id} and \n" +
            "g.goods_name like #{name} and \n" +
            "g.goods_type = #{type} and \n" +
            "g.is_storage = true and \n" +
            "s2.goods_id = g.goods_id and \n" +
            "s2.shelf_id = s.shelf_id and \n" +
            "s.warehouse_id = w.warehouse_id;")
    List<GoodInfoDTO> findGoodInfoByWarehousesIdGoodNameIncludeAndGoodType(@Param("id") Integer warehouseId,
                                                                           @Param("name") String goodName,
                                                                           @Param("type") String goodType);

    @Select("select distinct goods_type from goods;")
    List<String> findGoodType();
}
