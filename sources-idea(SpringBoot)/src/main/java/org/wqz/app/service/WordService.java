package org.wqz.app.service;

import org.wqz.app.domain.Word;

import java.io.IOException;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public interface WordService
{
	void saveAllChars() throws IOException;
	Word findById(Integer id);
}