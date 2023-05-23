package org.wqz.learntoread.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wqz.learntoread.dao.ReadMapper;
import org.wqz.learntoread.domain.CharsToLearn;
import org.wqz.learntoread.domain.ReadRecord;
import org.wqz.learntoread.service.ReadService;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
@Service("readService")
public class ReadServiceImpl implements ReadService
{
	// 让Spring容器执行field注入，将容器中 bookMapper组件赋值给该成员变量
	@Resource(name = "readMapper")
	private ReadMapper readMapper;

	@Override
	public List<CharsToLearn> viewUnknownWordsByUserId(Integer userId) {
		return readMapper.viewUnknownWordsByUserId(userId);
	}

	@Override
	public List<CharsToLearn> viewKnownWordsByUserId(Integer userId) {
		return readMapper.viewKnownWordsByUserId(userId);
	}

	@Override
	public List<CharsToLearn> viewUnmarkedWordsByUserId(Integer userId) {
		return readMapper.viewUnmarkedWordsByUserId(userId);
	}

	

	@Override
	public Integer updateKnownStatus(ReadRecord rr) {
		return readMapper.updateKnownStatus(rr);
	}

	@Override
	public ReadRecord viewReadWordById(Integer userId,Integer wordId){
		return readMapper.viewReadWordById(userId,wordId);
	}

	@Override
	public Integer insertReadRecords(ReadRecord rr) {
		return readMapper.insertReadRecords(rr);
	}

}
