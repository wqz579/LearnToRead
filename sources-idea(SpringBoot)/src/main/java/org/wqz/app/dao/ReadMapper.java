package org.wqz.app.dao;

import org.apache.ibatis.annotations.*;
import org.wqz.app.domain.ReadRecord;
import org.wqz.app.domain.Word;

import java.util.List;

@Mapper
public interface ReadMapper
{
    @Select("select c.c_id id, c.c_name name from characters_table c " +
            "left join read_table r " +
            "on r.word_id=c.c_id " +
            "where r.user_id = #{userId} and r.known_status=false " +
            "order by r.new_word_record_time")
    List<Word> viewUnknownWordsByUserId(Integer userId);

    @Select("select c.c_id id, c.c_name name from characters_table c " +
            "left join read_table r " +
            "on r.word_id=c.c_id " +
            "where r.user_id = #{userId} and r.known_status=true " +
            "order by r.new_word_record_time")
    List<Word> viewKnownWordsByUserId(Integer userId);

    @Select("select c.c_id id, c.c_name name from characters_table c " +
            "where c_id not in " +
            "(select word_id from read_table where user_id=#{userId})")
    List<Word> viewUnmarkedWordsByUserId(Integer userId);

    @Select("select user_id userId, word_id wordId, known_status known " +
            "from read_table " +
            "where user_id = #{userId} and word_id=#{wordId}")
    ReadRecord viewReadWordById(@Param("userId") Integer userId, @Param("wordId") Integer wordId);

    @Update("update read_table set known_status=#{known}, " +
            "new_word_record_time=#{recordTime} " +
            "where user_id=#{userId} and word_id=#{wordId}")
    Integer updateKnownStatus(ReadRecord rr);

    @Insert("insert into read_table " +
            "values (#{userId},#{wordId},#{known},#{recordTime})")
    Integer insertReadRecords(ReadRecord rr);
}
