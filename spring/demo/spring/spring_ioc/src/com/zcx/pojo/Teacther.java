/**
 * @Title: Teacther.java
 * @Package com.zcx.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.pojo;

/**
 * @ClassName: Teacther
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public class Teacther {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Teacther [id=" + id + "]";
	}

	public Teacther() {
	}

	public Teacther(Integer id) {
		super();
		this.id = id;
	}

}
