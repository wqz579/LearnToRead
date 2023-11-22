package org.wqz.app.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.wqz.app.domain.ReadRecord;
import org.wqz.app.domain.Word;
import org.wqz.app.service.ReadService;

import java.util.Date;
import java.util.List;

/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */

@Controller
public class ReadController
{
	
	private final ReadService readService;
	public ReadController(ReadService readService)
	{
		this.readService = readService;
	}

	//此方法用于请求该用户没有读过的字集
	@GetMapping("/read")
	public String getUnmarkedChars(@SessionAttribute ("userId") Integer userId,
								   HttpSession session, Model model)
	{
		List<Word> list=readService.viewUnmarkedWordsByUserId(userId);
		model.addAttribute("words", list.subList(0,5));
		int count=list.size();
		//以下属性用于在视图页面显示
		model.addAttribute("count", count);
		model.addAttribute("flag", "待认识的生字数目: ");
		return "read";
	}
	
	//此方法用于在查看生字过程中，将生字标记为认识
	@PostMapping("/insertKnownChars/{wordId}")
	public String insertKnownChars(@PathVariable Integer wordId, 
			@SessionAttribute ("userId") Integer userId)
	{
		System.out.println("========wordId: "+wordId);
		Date date=new Date();
		ReadRecord rr=new ReadRecord(userId, wordId,true, date);
		readService.insertReadRecords(rr);
		return "redirect:/read";
	}
	
	//此方法用于在查看生字过程中，将生字标记为不认识
	@PostMapping("/insertUnknownChars/{wordId}")
	public String insertUnknownChars(@PathVariable Integer wordId, 
			@SessionAttribute ("userId") Integer userId)
	{
		System.out.println("========wordId: "+wordId);
		Date date = new Date();
		ReadRecord rr=new ReadRecord(userId, wordId,false, date);
		readService.insertReadRecords(rr);
		return "redirect:/read";
	}
	
	//此方法用于获取用户标记为认识的字集
	@GetMapping("/knownWords")
	public String getKnowWords(@SessionAttribute ("userId") Integer userId, 
			Model model)
	{
		List<Word> list =readService.viewKnownWordsByUserId(userId);
		System.out.println("查看认识的汉字"+list);
		model.addAttribute("words", list);
		int count=list.size();
		//以下属性用于在视图页面显示
		model.addAttribute("count", count);
		model.addAttribute("flag", "认识的生字数目: ");
		//以下属性用于在视图页面添加、对认识状态进行修改
		model.addAttribute("status", "不认识");
		return "userForm";
	}
	
	//此方法用于获取用户标记为不认识的字集
	@GetMapping("/unknownWords")
	public String getUnknowWords(@SessionAttribute ("userId") Integer userId, 
			Model model)
	{
		List<Word> list =readService.viewUnknownWordsByUserId(userId);
		System.out.println("查看不认识的汉字"+list);
		model.addAttribute("words", list);
		int count=list.size();
		//以下属性用于在视图页面显示
		model.addAttribute("count", count);
		model.addAttribute("flag", "不认识的生字数目: ");
		//以下属性用于在视图页面添加、对认识状态进行修改
		model.addAttribute("status", "认识");
		return "userForm";
	}
	
	
	//此方法用于更改认识的状态，已认识改为不认识，不认识改为已认识
	@PostMapping("/updateKnownStatus/{wordId}")
	public String updateKnownStatus(@PathVariable Integer wordId, 
			@SessionAttribute ("userId") Integer userId)
	{
		Date date = new Date();
		ReadRecord rr= readService.viewReadWordById(userId,wordId);
		if(rr.isKnown()==false)
			rr.setKnown(true);
		else	
			rr.setKnown(false);
		rr.setRecordTime(date);
		readService.updateKnownStatus(rr);
		//返回修改前的界面
		if(rr.isKnown()==false)
			return "redirect:/knownWords";			
		else
			return "redirect:/unknownWords";
	}
	
	@PostMapping("/updateDate/{id}")
	public String updateDate(@PathVariable("id") Integer wordId,@SessionAttribute ("userId") Integer userId)
	{
		Date date = new Date();
		ReadRecord rr= readService.viewReadWordById(userId,wordId);
		rr.setRecordTime(date);
		readService.updateKnownStatus(rr);
		//返回修改前的界面
		if(rr.isKnown()==true)
			return "redirect:/knownWords";			
		else
			return "redirect:/unknownWords";
	}
}
