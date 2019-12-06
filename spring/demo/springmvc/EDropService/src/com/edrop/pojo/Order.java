/**
 * @Title: Order.java
 * @Package com.edrop.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.pojo;

import java.sql.Timestamp;

/**
 * 用户订单表
 * @ClassName: Order
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class Order {
	private Integer id;
	private String number;
	private Integer userId;
	private int userDeleteState;
	private int employeeDeleteState;
	private int state;
	private Timestamp createTime;
	private Timestamp finishTime;
	private Integer employeeId;
	private User user;
	private Employee employee;
	
	public Order(Integer id, String number, Integer userId, int userDeleteState, int employeeDeleteState, int state,
			Timestamp createTime, Timestamp finishTime, Integer employeeId, User user, Employee employee) {
		super();
		this.id = id;
		this.number = number;
		this.userId = userId;
		this.userDeleteState = userDeleteState;
		this.employeeDeleteState = employeeDeleteState;
		this.state = state;
		this.createTime = createTime;
		this.finishTime = finishTime;
		this.employeeId = employeeId;
		this.user = user;
		this.employee = employee;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getUserDeleteState() {
		return userDeleteState;
	}
	public void setUserDeleteState(int userDeleteState) {
		this.userDeleteState = userDeleteState;
	}
	public int getEmployeeDeleteState() {
		return employeeDeleteState;
	}
	public void setEmployeeDeleteState(int employeeDeleteState) {
		this.employeeDeleteState = employeeDeleteState;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", userId=" + userId + ", userDeleteState=" + userDeleteState
				+ ", employeeDeleteState=" + employeeDeleteState + ", state=" + state + ", createTime=" + createTime
				+ ", finishTime=" + finishTime + ", employeeId=" + employeeId + ", user=" + user + ", employee="
				+ employee + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
