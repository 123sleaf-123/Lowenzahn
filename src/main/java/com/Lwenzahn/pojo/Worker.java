package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Worker {
    @TableId
    private Integer workerId;
    private String workerName;
    private String workerPassword;
}
