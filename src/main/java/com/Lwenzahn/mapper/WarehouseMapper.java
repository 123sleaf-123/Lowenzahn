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
    @Select("SELECT g.good_Name, g.`type`, s.`position`, s2.store_floor\n" +
            "FROM shelf s, warehouse w, store s2, good g \n" +
            "WHERE \n" +
            "w.whid = #{id} and w.whid = s.whid and s.shelfid = s2.shelfid and g.gid = s2.gid")
    List<GoodInfoDTO> findGoodInfo(@Param("id")Integer whid);
}
