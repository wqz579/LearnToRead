package org.wqz.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ReadRecord
{
    private Integer userId;
    private Integer wordId;
    private boolean known;
    private Date recordTime;

    public ReadRecord(){}
    public ReadRecord(Integer userId, Integer wordId, boolean known)
    {
        this.userId = userId;
        this.wordId = wordId;
        this.known = known;
    }

    public ReadRecord(Integer userId, Integer wordId, boolean known, Date recordTime)
    {
        this.userId = userId;
        this.wordId = wordId;
        this.known = known;
        this.recordTime = recordTime;
    }
}
