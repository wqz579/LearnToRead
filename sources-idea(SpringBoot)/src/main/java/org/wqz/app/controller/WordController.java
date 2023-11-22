package org.wqz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.wqz.app.service.WordService;

import java.io.IOException;

/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */


@Controller
public class WordController
{
	
	private WordService wordService;

	public WordController(WordService wordService)
	{
		this.wordService = wordService;
	}

	//importChars视图
	@GetMapping("/importChars")
	public String importPage()
	{
		//如果在生字数据表中可以找到生字，说明生字数据表已经导入数据
		if(wordService.findById(1)!=null)
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
		wordService.saveAllChars();
		return "redirect:read";
	}
		
}
