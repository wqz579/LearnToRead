drop database if exists learn_to_read;

create database learn_to_read;

use learn_to_read;

drop table if exists characters_table;

-- 创建数据表
create table characters_table
(
 c_id integer primary key auto_increment,
 c_name varchar(255) unique
);

