package org.wqz.app.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wqz.app.domain.Word;

@Mapper
public interface WordMapper
{
    @Select("select c_name name from characters_table where c_id =#{id}")
    Word findById(Integer id);
    @Insert("insert into characters_table values(null,#{name})")
    Integer saveChar(String name);
}
