use learn_to_read;

drop table if exists read_table;

# 创建数据表
create table read_table
(
 user_id integer references user_table(user_id),
 word_id integer references characters_table(c_id),
 primary key (user_id,word_id),
 known_status boolean,
 new_word_record_time datetime
);

insert into read_table
values(1,1,true,null), (1,2,false,null),
(1,3,false,null),(1,4,true,null),
(1,5,true,null);

insert into read_table
values(2,1,true,null), (2,2,true,null),
(2,3,false,null),(2,4,false,null);
