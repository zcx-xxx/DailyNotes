/**
 * @Title: MyThrow.java
 * @Package com.zcx.advice
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @ClassName: MyThrow
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
public class MyThrow implements ThrowsAdvice{
	 
    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("执行异常通过-schema-base 方式");
    }
}