package org.wqz.learntoread.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.wqz.learntoread.domain.CharsToLearn;
import org.wqz.learntoread.domain.ReadRecord;
import org.wqz.learntoread.service.ReadService;

/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */

@Controller
public class ReadController
{
	
	@Resource(name="readService")
	private ReadService readService;
	 		
	//此方法用于请求该用户没有读过的字集
	@GetMapping("/read")
	public String getUnmarkedChars(@SessionAttribute ("userId") Integer userId, 
			HttpSession session, Model model) 
	{
		List<CharsToLearn> list=readService.viewUnmarkedWordsByUserId(userId);
		model.addAttribute("characters", list);
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
		Date date = new Date();
		ReadRecord rr=new ReadRecord(userId, wordId,true, date);
		readService.insertReadRecords(rr);
		return "redirect:/read";
	}
	
	//此方法用于在查看生字过程中，将生字标记为不认识
	@PostMapping("/insertUnknownChars/{wordId}")
	public String insertUnknownChars(@PathVariable Integer wordId, 
			@SessionAttribute ("userId") Integer userId)
	{
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
		List<CharsToLearn> list =readService.viewKnownWordsByUserId(userId);
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
		List<CharsToLearn> list =readService.viewUnknownWordsByUserId(userId);
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
		if(rr.getKnownStatus()==false)	
			rr.setKnownStatus(true);
		else	
			rr.setKnownStatus(false);
		rr.setNewWordRecordTime(date);
		readService.updateKnownStatus(rr);
		//返回修改前的界面
		if(rr.getKnownStatus()==false)	
			return "redirect:/knownWords";			
		else
			return "redirect:/unknownWords";
	}
}
