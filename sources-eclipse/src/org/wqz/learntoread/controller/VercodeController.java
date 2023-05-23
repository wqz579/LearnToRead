package org.wqz.learntoread.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */

@Controller
public class VercodeController {

	//设置验证码的宽度
	private final int IMG_WIDTH = 200;
	//设置验证码的高度
	private final int IMG_HEIGHT = 50;

	// 生成验证码的方法
	@GetMapping("/vercode")
	//OutputStream就是代表Servlet API对应的输出流
	public void show(OutputStream os, HttpSession session) throws IOException {
		// 创建一张内存中图片
		BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		// 获取画笔
		Graphics g = img.getGraphics();
		// 设置画笔的颜色
		g.setColor(Color.red);
		//设置画笔的字体
		g.setFont(new Font("Arial Black", Font.ITALIC, 30));
		Random rnd = new Random();
		// 用于保存随机字符串
		StringBuffer rndStr = new StringBuffer("");
		//生成6个随机字符(包含大写字母、小写字母和数字）
		for (int i = 0; i < 6; i++) {
			//type用于动态控制生成字符的类型
			int type = rnd.nextInt(3);
			char c = '\u0000';
			// 根据type来动态生成小写字母、大写字母、数字
			switch (type) {
			case 0:
				c = (char) (rnd.nextInt(26) + 'a');
				break;
			case 1:
				c = (char) (rnd.nextInt(26) + 'A');
				break;
			case 2:
				c = (char) (rnd.nextInt(10) + '0');
				break;
			}
			rndStr.append(c);
			// 将随机字符绘制在图片上
			g.drawString(c + "", 30 * i + 10, 35);
		}
		// 将生成的随机验证码保存为session的属性，便于在UserController中控制用户登录
		session.setAttribute("vercode", rndStr.toString());
		// 将图片内容输出到指定IO流
		ImageIO.write(img, "PNG", os);
	}
}
