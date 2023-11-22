package org.wqz.app.service.impl;

import org.springframework.stereotype.Service;
import org.wqz.app.dao.ReadMapper;
import org.wqz.app.domain.ReadRecord;
import org.wqz.app.domain.Word;
import org.wqz.app.service.ReadService;

import java.util.List;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
@Service("readService")
public class ReadServiceImpl implements ReadService
{
	// 让Spring容器执行field注入，将容器中 bookMapper组件赋值给该成员变量
	private final ReadMapper readMapper;

	public ReadServiceImpl(ReadMapper readMapper)
	{
		this.readMapper = readMapper;
	}

	@Override
	public List<Word> viewUnknownWordsByUserId(Integer userId) {
		return readMapper.viewUnknownWordsByUserId(userId);
	}

	@Override
	public List<Word> viewKnownWordsByUserId(Integer userId) {
		return readMapper.viewKnownWordsByUserId(userId);
	}

	@Override
	public List<Word> viewUnmarkedWordsByUserId(Integer userId) {
		return readMapper.viewUnmarkedWordsByUserId(userId);
	}

	

	@Override
	public Integer updateKnownStatus(ReadRecord rr) {
		return readMapper.updateKnownStatus(rr);
	}

	@Override
	public ReadRecord viewReadWordById(Integer userId, Integer wordId){
		return readMapper.viewReadWordById(userId,wordId);
	}

	@Override
	public Integer insertReadRecords(ReadRecord rr) {
		return readMapper.insertReadRecords(rr);
	}

}
