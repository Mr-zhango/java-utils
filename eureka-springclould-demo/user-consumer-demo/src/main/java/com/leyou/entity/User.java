package com.leyou.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 姓名
    private String phone;

    // 创建时间
    private Date created;

}
