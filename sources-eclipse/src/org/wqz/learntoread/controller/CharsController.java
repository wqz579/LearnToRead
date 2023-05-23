package org.wqz.learntoread.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.wqz.learntoread.service.CharsService;

/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */


@Controller
public class CharsController
{
	
	@Resource(name="charsService")
	private CharsService charsService;
	
	//importChars视图
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
		
}
