package org.wqz.learntoread.service;

import java.io.IOException;

import org.wqz.learntoread.domain.CharsToLearn;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface CharsService
{
	void saveAllChars() throws IOException;
	CharsToLearn findById(Integer id);
}