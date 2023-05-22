use learn_to_read;

drop table if exists user_table;

# 创建数据表
create table user_table
(
 user_id integer primary key auto_increment,
 user_name varchar(255) not null unique,
 user_password varchar(255) not null,
 user_role enum('manager','user')
);

insert into user_table
values(null,'wqz','579168','manager'),(null,'wwy','579168','user');
