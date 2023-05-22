package org.wqz.learntoread.dao;

import org.wqz.learntoread.domain.CharsToLearn;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface CharsMapper
{
	CharsToLearn findById(Integer id);
	Integer saveChar(String name);
}
