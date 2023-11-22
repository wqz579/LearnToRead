package org.wqz.app.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.wqz.app.dao.WordMapper;
import org.wqz.app.domain.Word;
import org.wqz.app.service.WordService;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
@Service("wordService")
public class WordServiceImpl implements WordService
{
 	private final WordMapper wordMapper;

	public WordServiceImpl(WordMapper wordMapper)
	{
		this.wordMapper = wordMapper;
	}

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
			wordMapper.saveChar(sa[i]);
		}
		sc.close();
	}
	
	

	@Override
	public Word findById(Integer id) {
		return wordMapper.findById(id);
	}
	
}
