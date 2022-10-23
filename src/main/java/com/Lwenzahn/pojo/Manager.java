package com.Lwenzahn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Manager {
    @TableId
    private Integer managerId;
    private String managerPassword;
    private String managerName;
    private Integer managerPower;
    private String managerBirthday;
    private String managerGender;
    private String managerDescription;
    private String managerAvatar;
}
