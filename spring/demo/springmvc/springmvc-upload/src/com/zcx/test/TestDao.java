/**
 * @Title: testDao.java
 * @Package com.zcx.test
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.test;

import com.zcx.dao.UpLoadFileDao;
import com.zcx.dao.impl.UpLoadFileDaoImpl;

/**
 * @ClassName: testDao
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
public class TestDao {
	public static void main(String[] args) {
		UpLoadFileDao upLoadFile = new UpLoadFileDaoImpl();
		upLoadFile.uploadFile(1, "1.jpg", "dcsd545dsfa655vdsd5f", "images/jpeg");
	}
}
