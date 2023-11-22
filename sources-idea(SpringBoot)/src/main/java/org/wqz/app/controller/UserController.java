package org.wqz.app.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.wqz.app.domain.User;
import org.wqz.app.service.UserService;


/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */

@Controller
public class UserController
{

	private final UserService userService;
	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping("/index")
	public String index()
	{
		return "loginForm";
	}

	@GetMapping("/register")
	public String register()
	{
		return "register";
	}

	@GetMapping("/loginForm")
	public String loginForm()
	{
		return "loginForm";
	}

	@GetMapping("/userForm")
	public String userForm()
	{
		return "userForm";
	}

	@PostMapping("/addUser")
	public String addUser(@Validated User user, Errors errors, BindingResult bindingResult, Model model)
	{
		// 输入校验出现了错误
		if (errors.hasErrors())
		{
			model.addAttribute("failure", "用户名或密码不符合要求，无法注册");
			return "register";
		}
		//查看数据库中是否存在同名用户
		User u=userService.findUserByName(user.getName());
		//若数据库中还没有存储该用户名
		if(u==null)
		{
			//则可以注册该用户
			userService.addUser(user);
			model.addAttribute("success", "用户注册成功, 请点击'登录页面'链接跳转到登录页面");		
		}
		else
		{
			//否则，无法完成注册
			model.addAttribute("failure", "用户名已经被占用，无法注册重复的用户名，请更换用户名，重新尝试注册！");
		}
		return "register";
	}
	
	
	@PostMapping("/login")
	// @SessionAttribute("vercode")指定将session范围内的vercode属性值传给被修饰的s参数
	public String login(String name, String password, String vercode,
						@SessionAttribute("vercode") String s,
						HttpSession session, Model model)
	{
		// 要求用户输入的vercode与session中的vercode（由图形验证码添加）要一致
		if (vercode.equals(s))
		{
			if (userService.userLogin(name, password) ==true)
			{
				Integer userId=userService.findIdByName(name);
				//将userId和name存储到session属性,用于ReadController中读取当前登录用户的信息
				session.setAttribute("userId", userId);
				session.setAttribute("currentUserName", name);
				
				return "redirect:importChars";
			}
			else
			{
				//添加没有登录成功的提示信息
				model.addAttribute("tip", "对不起， 用户名或密码不正确,登录失败！");
			}
		}
		else
		{
			//添加没有登录成功的提示信息
			model.addAttribute("tip", "验证码不正确！");
		}
		return "loginForm";
	}
	
	//退出登录请求，返回登录页面
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("userId");
		return "redirect:/loginForm";
	}
}
