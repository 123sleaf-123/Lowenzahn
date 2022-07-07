package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Good {
    @TableId
    private Integer gid;
    private String goodName;
    private String type;
    private Integer shelfid;
    private Integer floor;
    private String start;
    private String end;
}
