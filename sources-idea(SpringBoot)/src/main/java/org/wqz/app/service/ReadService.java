package org.wqz.app.service;

import java.util.List;

import org.wqz.app.domain.Word;
import org.wqz.app.domain.ReadRecord;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface ReadService
{
	List<Word> viewUnknownWordsByUserId(Integer userId);
	List<Word> viewKnownWordsByUserId(Integer userId);
	
	List<Word> viewUnmarkedWordsByUserId(Integer userId);
	ReadRecord viewReadWordById(Integer userId,Integer wordId);
	
	Integer updateKnownStatus(ReadRecord rr);
	Integer insertReadRecords(ReadRecord rr);
}

