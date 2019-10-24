/**
 * @Title: UpLoadFileImpl.java
 * @Package com.zcx.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.service.impl;

import java.util.List;

import com.zcx.dao.UpLoadFileDao;
import com.zcx.dao.impl.UpLoadFileDaoImpl;
import com.zcx.entity.UpLoad;
import com.zcx.service.UpLoadFileService;

/**
 * @ClassName: UpLoadFileImpl
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
public class UpLoadFileServiceImpl implements UpLoadFileService{
	private UpLoadFileDao load = new UpLoadFileDaoImpl();

	/* (非 Javadoc)
	 * <p>Title: uploadFile</p>
	 * <p>Description: </p>
	 * @param id
	 * @param oldName
	 * @param newName
	 * @param ContentType
	 * @see com.zcx.service.UpLoadFile#uploadFile(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void uploadFile(Integer id, String oldName, String newName, String ContentType) {
		// TODO Auto-generated method stub
		load.uploadFile(id, oldName, newName, ContentType);	
	}

	/* (非 Javadoc)
	 * <p>Title: getUpLoadFile</p>
	 * <p>Description: </p>
	 * @param uid
	 * @return
	 * @see com.zcx.service.UpLoadFileService#getUpLoadFile(java.lang.Integer)
	 */
	@Override
	public List<UpLoad> getUpLoadFile(Integer uid) {
		return load.getUpLoadFile(uid);
	}
}
