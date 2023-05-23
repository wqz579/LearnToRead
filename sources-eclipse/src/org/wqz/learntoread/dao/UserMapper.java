package org.wqz.learntoread.dao;

import org.wqz.learntoread.domain.User;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface UserMapper
{
	Integer addUser(User user);
	void deleteUserById(Integer id);
	void updateRole(String role);
	User findUserByName(String name);
	Integer findIdByName(String name);
}
