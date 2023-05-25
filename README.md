# LearnToRead
Eclipse-WebApplication

Help children to learn and review Characters more effectively

Background: My child was learning to read recently, and I could not find an appropriate software/application to learn the volume of Characters the children may know. So, I developed this simple webapplication. 

Function: This application will import a total of 2478 regular Characters in primary school stage, and it has user account registration, user login, Characters to learn, user center(the known/unknown Characters parts) pages. It can clearly show what Characters the child do not know and help him/her to review the ones effectively.

背景：家里孩子最近在识字，除了日常读书本，还想让其多认识一些字以及记录不认识的字以便之后反复复习，网上没有找到好用的，可以记录她已经认识的，以及之前不认识的字的应用。所以利用已学的SSM的技能，开发这一个简单的网页应用。项目导入2478个小学阶段常用字。

项目设计：

业务逻辑及功能模块：
1.网页应用：jsp视图页面
2.用户注册：用户名、密码校验
3.用户登录：用户名、密码、验证码校验
4.导入基础汉字：MySQL数据库
5.凭权限进入识字页面。
6.个人中心：读取已经认识的字，查看不认识的字，进行复习
7.退出登录

数据库和数据表设计：
1.字表：
characters_table
	c_id（主键），c_name

2.用户表（含管理权限）
user_table	
	user_id(主键）, user_name（唯一）, user_password, user_role

3.识字记录表
read_table
  user_id, word_id, known_status, new_word_record_time
  主键（user_id, word_id）

SSM结构设计：
控制器层：
业务层：
Dao层：
Domain层：
数据库：

待完善及改进方向：
1. 按照时间记忆曲线来提醒复习时间；
2. 增加读音，意思，图片等
3. 管理者权限
4. 设置一些更有趣味的测验
5. 目前只给用户名和密码的校验提供国际化，可以给所有视图页面提供国际化。