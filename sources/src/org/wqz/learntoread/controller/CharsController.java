package org.wqz.learntoread.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wqz.learntoread.domain.CharsToLearn;
import org.wqz.learntoread.service.CharsService;

/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */


@Controller
public class CharsController
{
	//用于设置生字显示的大小
	private final int IMG_WIDTH = 200;
	private final int IMG_HEIGHT =50;
	
	@Resource(name="charsService")
	private CharsService charsService;
	
	@GetMapping("/importChars")
	public String importPage()
	{
		//如果在生字数据表中可以找到生字，说明生字数据表已经导入数据
		if(charsService.findById(1)!=null)
		{
			//直接重定向到识字页面
			return "redirect:read";
		}
		//否则，进入“导入生字”页面进行生字导入
		return "importChars";
	}

	
	//该方法用于往生字数据表中导入生字,导完后返回识字页面
	@PostMapping("/importPrimaryChars")
	public String importNewChars() throws IOException
	{
		charsService.saveAllChars();
		return "redirect:read";
	}
	
	
	//此方法，用于显示生字
	@GetMapping("/printChars/{id}")
	// OutputStream就是代表Servlet API对应的输出流
	public void printChars(OutputStream os, @PathVariable Integer id) 
			throws IOException {
		// 创建一张内存中图片
		BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, 
				BufferedImage.TYPE_INT_ARGB);
		// 获取画笔
		Graphics g = img.getGraphics();
		// 设置画笔的颜色
		g.setColor(Color.black);
		//设置画笔的字体
		g.setFont(new Font("Arial Black", Font.ITALIC, 40));
		// 用于保存字符
		CharsToLearn c = charsService.findById(id);
		//将字符绘制在图片上
		g.drawString(c.getName(), 5, 45);
		// 将图片内容输出到指定IO流
		ImageIO.write(img, "PNG", os);
	}
	
}
