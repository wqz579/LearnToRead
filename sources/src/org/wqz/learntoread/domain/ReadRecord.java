package org.wqz.learntoread.domain;

import java.util.Date;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public class ReadRecord
{
	private Integer userId;
	private Integer wordId;
	private boolean knownStatus;
	private Date newWordRecordTime;
	
	public ReadRecord() {}
	
	public ReadRecord(Integer userId, Integer wordId, boolean knownStatus) {
		super();
		this.userId = userId;
		this.wordId = wordId;
		this.knownStatus = knownStatus;
	}

	public ReadRecord(Integer userId, Integer wordId, boolean knownStatus, Date newWordRecordTime) {
		super();
		this.userId = userId;
		this.wordId = wordId;
		this.knownStatus = knownStatus;
		this.newWordRecordTime = newWordRecordTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getWordId() {
		return wordId;
	}
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}
	public boolean getKnownStatus() {
		return knownStatus;
	}
	public void setKnownStatus(boolean knownStatus) {
		this.knownStatus = knownStatus;
	}
	public Date getNewWordRecordTime() {
		return newWordRecordTime;
	}
	public void setNewWordRecordTime(Date newWordRecordTime) {
		this.newWordRecordTime = newWordRecordTime;
	}
}