package org.wqz.learntoread.domain;

import javax.validation.constraints.NotBlank;
/**
 * @author wqz579
 * @version 1.0 snapshot
 * @since May 21, 2023
 */
public class CharsToLearn
{
	private Integer id;
	@NotBlank(message = "字名不允许为空")
	private String name;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CharsToLearn [id=" + id + ", name=" + name + "]";
	}

}