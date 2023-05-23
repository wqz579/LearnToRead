select c.c_id id, c.c_name name from characters_table c
left join read_table r 
on r.word_id=c.c_id
where r.user_id = 1 and r.known_status='false';


select c.c_id id, c.c_name name from characters_table c
left join read_table r
on r.word_id=c.c_id
where r.user_id = 1 and r.known_status='true';


select c.c_id id, c.c_name name from characters_table c
where c_id not in
(select word_id from read_table where user_id=2);

insert into characters_table
values(null, '一'),(null,'二'),(null,'三'),(null,'四'),(null,'五'),(null,'六');

