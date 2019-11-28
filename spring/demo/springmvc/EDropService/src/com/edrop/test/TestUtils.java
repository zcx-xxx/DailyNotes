/**
 * @Title: TestUtils.java
 * @Package com.edrop.test
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.test;

import org.junit.Test;

import com.edrop.utils.IndentifyGarbageUtil;

/**
 * @ClassName: TestUtils
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class TestUtils {
	@Test
	public void testIndentifyGarbage() {
		IndentifyGarbageUtil util = new IndentifyGarbageUtil();
		util.indentifyGarbage();
	}
}
