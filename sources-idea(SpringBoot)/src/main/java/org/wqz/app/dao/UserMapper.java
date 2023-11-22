package org.wqz.app.dao;

import org.apache.ibatis.annotations.*;
import org.wqz.app.domain.User;

@Mapper
public interface UserMapper
{
    @Insert("insert into user_table values (null, #{name},#{password},'user')")
    Integer addUser(User user);
    @Delete("delete from user_table where user_id = #{id}")
    void deleteUserById(Integer id);
    @Update("update user_table set user_role=#{role}")
    void updateRole(String role);
    @Select("select user_name name, user_password password, " +
            "user_role role from user_table " +
            "where user_name =#{name}")
    User findUserByName(String name);
    @Select("select user_id id from user_table " +
            "where user_name =#{name}")
    Integer findIdByName(String name);
}
