/**
 * @Title: UpLoad.java
 * @Package com.zcx.entity
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.entity;

import java.sql.Timestamp;

/**
 * @ClassName: UpLoad
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
public class UpLoad {
	private Integer upid;
	private Integer uid;
	private String oldName;
	private String newName;
	private String contentType;
	private Timestamp uploadTime;
	public Integer getUpid() {
		return upid;
	}
	public void setUpid(Integer upid) {
		this.upid = upid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Override
	public String toString() {
		return "UpLoad [upid=" + upid + ", uid=" + uid + ", oldName=" + oldName + ", newName=" + newName
				+ ", contentType=" + contentType + ", uploadTime=" + uploadTime + "]";
	}
	public UpLoad(Integer upid, Integer uid, String oldName, String newName, String contentType, Timestamp uploadTime) {
		super();
		this.upid = upid;
		this.uid = uid;
		this.oldName = oldName;
		this.newName = newName;
		this.contentType = contentType;
		this.uploadTime = uploadTime;
	}
	public UpLoad() {
	}
}
