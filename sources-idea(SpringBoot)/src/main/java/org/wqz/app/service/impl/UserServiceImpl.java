package org.wqz.app.service.impl;

import org.springframework.stereotype.Service;
import org.wqz.app.dao.UserMapper;
import org.wqz.app.domain.User;
import org.wqz.app.service.UserService;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
	// 让Spring容器执行field注入，将容器中 bookMapper组件赋值给该成员变量
	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}

	@Override
	public Integer addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public void updateRole(String role) {
		userMapper.updateRole(role);
	}

	@Override
	public User findUserByName(String name) {
		return userMapper.findUserByName(name);
	}

	@Override
	public boolean userLogin(String name, String password) {
		User u=userMapper.findUserByName(name);
		System.out.println(u);

		boolean res=(u!=null && u.getName().equals(name) && u.getPassword().equals(password));
		System.out.println(res);
		return res;
	}
	
	@Override
	public Integer findIdByName(String name) {
		return userMapper.findIdByName(name);
	}
}
