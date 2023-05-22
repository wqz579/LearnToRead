package org.wqz.learntoread.service;

import org.wqz.learntoread.domain.User;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface UserService
{
	Integer addUser(User user);
	void deleteUser(Integer id);
	void updateRole(String role);
	boolean userLogin(String name, String password);
	User findUserByName(String name);
	Integer findIdByName(String name);
}