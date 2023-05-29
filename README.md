# 项目简介
使用Eclipse工具创建，利用MyBatis、SpringMVC框架来实现的儿童识字的动态网页应用。<br>
（附有2478个常用字文档，数据库和数据表创建的SQL语句）

# 背景
家里孩子最近在识字，除了日常读书本，还想让其多认识一些字以及记录不认识的字以便之后反复复习，网上没有找到好用的，可以记录她已经认识的，以及之前不认识的字的应用。所以开发了这个简单的网页应用。项目导入2478个小学阶段常用字。


# 功能模块
1.用户注册：用户名、密码输入校验<br>
2.用户登录：用户名、密码、验证码输入校验<br>
3.导入基础汉字：MySQL数据库<br>
4.凭权限进入识字页面<br>
5.个人中心：读取已经认识的字，查看不认识的字，进行复习<br>
6.退出登录<br>

# 数据库和数据表设计
1.数据库: learn_to_read<br>
2.字表: characters_table; 含有字段：c_id（主键），c_name<br>
3.用户表（含管理权限): user_table; 含有字段：user_id(主键）, user_name（唯一）, user_password, user_role<br>
4.识字记录表: read_table; 含有字段：user_id, word_id, known_status, new_word_record_time; 主键（user_id, word_id）<br>

# SSM结构设计：
表现层（jsp）---->控制器层--->业务层---->Dao层---->Domain层

# 界面效果
1.注册页面
![image](https://github.com/wqz579/LearnToRead/assets/128567260/f15ece30-67b6-4a6a-9721-85e76ff1521b)

![image](https://github.com/wqz579/LearnToRead/assets/128567260/e08def89-c61a-412c-bdcf-1dbd0a6bbf6e)
=========================================================================================<br>
2.登录页面
![image](https://github.com/wqz579/LearnToRead/assets/128567260/08e8d5d5-b0bb-4f14-aa9c-69e78694a516)

![image](https://github.com/wqz579/LearnToRead/assets/128567260/049bc4ea-f127-4351-a27c-99493c3d3bed)

![image](https://github.com/wqz579/LearnToRead/assets/128567260/40930db3-7aac-4ee5-929d-b445ce1a8088)
=========================================================================================<br>
3.识字页面（拼音可以隐藏/显示）
![image](https://github.com/wqz579/LearnToRead/assets/128567260/0d40da62-44ac-4051-afd0-6e8d9606dbf3)
=========================================================================================<br>
4.认识界面（拼音可以隐藏/显示）
![image](https://github.com/wqz579/LearnToRead/assets/128567260/0652f39c-c891-4f50-acb7-002dbf279ced)

![image](https://github.com/wqz579/LearnToRead/assets/128567260/ae1fe9a0-389a-4253-9496-cfc71c9c15be)
=========================================================================================<br>
5.不认识界面（拼音可以隐藏/显示）
![image](https://github.com/wqz579/LearnToRead/assets/128567260/46d9655a-241e-4965-aa8c-db33342fc0f4)
=========================================================================================<br>
# 后续可以完善及改进方向
1. 按照时间记忆曲线来提醒复习时间<br>
2. 增加读音，意思，图片等<br>
3. 管理者权限<br>
4. 设置一些更有趣味的测验<br>
5. 目前只给用户名和密码的校验提供国际化，可以给所有视图页面提供国际化<br>
6. 增加例句<br>
