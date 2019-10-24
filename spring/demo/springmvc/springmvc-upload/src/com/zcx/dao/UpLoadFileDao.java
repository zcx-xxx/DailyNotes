/**
 * @Title: UpLoadFile.java
 * @Package com.zcx.dao
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.dao;

import java.util.List;

import com.zcx.entity.UpLoad;

/**
 * @ClassName: UpLoadFile
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
public interface UpLoadFileDao {
	
	/**
	 * 文件的上传
	 * @Title: uploadFile
	 * @Description:
	 * @param id
	 * @param oldName
	 * @param newName
	 * @param ContentType
	 * @return void
	 * @throws
	 */
	public void uploadFile(Integer id, String oldName, String newName, String ContentType);
	
	/**
	 * 查询指定用户的上传文件
	 * @Title: getUpLoadFile
	 * @Description:
	 * @param uid
	 * @return
	 * @return List<UpLoad>
	 * @throws
	 */
	public List<UpLoad> getUpLoadFile(Integer uid);
}
