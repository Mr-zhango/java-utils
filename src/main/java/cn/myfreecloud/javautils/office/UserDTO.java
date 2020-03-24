package cn.myfreecloud.javautils.office;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private Gender gender;

    private String name;

    private String nameEn;

    private String nickname;

    private String cellphone;

    private String email;

    private String province;

    private String city;

    private Date createTime;

    private Date updateTime;
}
