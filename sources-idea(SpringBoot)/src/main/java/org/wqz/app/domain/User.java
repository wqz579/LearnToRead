package org.wqz.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Data
public class User
{

    private Integer id;
    @Length(min = 3, max = 10, message="用户的长度必须在3～10之间")
    private String name;
    @Length(min = 6, max = 12, message="密码长度必须在6～12之间")
    private String password;
    //权限，manger, user
    private String role;

    public User(){}
    public User(String name, String password, String role)
    {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
