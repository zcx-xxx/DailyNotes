/**
 * @Title: Competition.java
 * @Package com.edrop.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.pojo;

/**
 * 答题类
 * @ClassName: Competition
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class Competition {
	private Integer id;
	private String question;
	private Integer typeId;
	private Type type;
	
	public Competition(Integer id, String question, Integer typeId, Type type) {
		super();
		this.id = id;
		this.question = question;
		this.typeId = typeId;
		this.type = type;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Competition [id=" + id + ", question=" + question + ", typeId=" + typeId + ", type=" + type + "]";
	}
}
