/**
 * @Title: User.java
 * @Package com.zcx.unity
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 * @version V1.0
 */
package com.zcx.unity;

/**
 * @ClassName: User
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 *
 */
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User() {
	}
}
