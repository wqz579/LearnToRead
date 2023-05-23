package org.wqz.learntoread.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public class User
{
	private Integer id;
	
	@NotBlank(message = "用户名不允许为空")
	@Length(min = 3, max = 10, message="用户的长度必须在3～10之间")
	private String name;
	
	@NotBlank(message = "密码不允许为空")
	@Length(min = 6, max = 12, message="密码长度必须在6～12之间")
	private String password;
	
	//权限：user和manager
	private String role;
	
	public User() {}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role=" + role + "]";
	}
}