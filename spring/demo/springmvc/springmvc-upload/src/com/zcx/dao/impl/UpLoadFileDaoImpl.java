/**
 * @Title: UpLoadFileImpl.java
 * @Package com.zcx.dao.impl
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zcx.dao.UpLoadFileDao;
import com.zcx.entity.UpLoad;
import com.zcx.util.DBUtil;

/**
 * @ClassName: UpLoadFileImpl
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
public class UpLoadFileDaoImpl implements UpLoadFileDao{

	/* (非 Javadoc)
	 * <p>Title: uploadFile</p>
	 * <p>Description: </p>
	 * @param id
	 * @param oldName
	 * @param newName
	 * @param ContentType
	 * @see com.zcx.dao.UpLoadFile#uploadFile(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void uploadFile(Integer id, String oldName, String newName, String ContentType) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String sql = "insert into upload values(?, ?, ?, ?, ?, ?)";
		int n = DBUtil.executeUpdate(sql, null, id, oldName, newName, ContentType, timestamp);
	}

	/* (非 Javadoc)
	 * <p>Title: getUpLoadFile</p>
	 * <p>Description: </p>
	 * @param uid
	 * @return
	 * @see com.zcx.dao.UpLoadFileDao#getUpLoadFile(java.lang.Integer)
	 */
	@Override
	public List<UpLoad> getUpLoadFile(Integer uid) {
		List<UpLoad> listFile = new ArrayList<UpLoad>();
		String sql = "select * from upload where uid = ?";
		
		listFile = DBUtil.executeQuery(sql, UpLoad.class, uid);
		return listFile;
	}
}
