package org.wqz.learntoread.service.impl;

import java.io.IOException;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.wqz.learntoread.dao.CharsMapper;
import org.wqz.learntoread.domain.CharsToLearn;
import org.wqz.learntoread.service.CharsService;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
@Service("charsService")
public class CharsServiceImpl implements CharsService
{
	@Resource(name="charsMapper")
	private CharsMapper charsMapper;
	
	@Override
	public void saveAllChars() throws IOException {
		ClassPathResource cp=new ClassPathResource("PrimaryWords.txt");
		Scanner sc = new Scanner(cp.getInputStream());
		String s=new String();
		if(sc.hasNextLine())
		{
			s=sc.nextLine();
		}
		String[] sa=s.split(" ");
		int n=sa.length;
		for(int i=0;i<n;i++)
		{
			charsMapper.saveChar(sa[i]);
		}
		sc.close();
	}

	@Override
	public CharsToLearn findById(Integer id) {
		return charsMapper.findById(id);
	}
	
}
