package org.wqz.learntoread.service;

import java.util.List;

import org.wqz.learntoread.domain.CharsToLearn;
import org.wqz.learntoread.domain.ReadRecord;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface ReadService
{
	List<CharsToLearn> viewUnknownWordsByUserId(Integer userId);
	List<CharsToLearn> viewKnownWordsByUserId(Integer userId);
	
	List<CharsToLearn> viewUnmarkedWordsByUserId(Integer userId);
	ReadRecord viewReadWordById(Integer userId,Integer wordId);
	
	Integer updateKnownStatus(ReadRecord rr);
	Integer insertReadRecords(ReadRecord rr);
}

