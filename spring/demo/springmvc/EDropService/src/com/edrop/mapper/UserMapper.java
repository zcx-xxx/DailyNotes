/**
 * @Title: UserMapper.java
 * @Package com.zcx.mapper
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.mapper;

import org.apache.ibatis.annotations.Select;

import com.edrop.pojo.DDUser;

/**
 * @ClassName: UserMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
public interface UserMapper {
	//获得用户信息
	//使用注解的方式配置
	@Select("select * from tbl_user where uname=#{param1} and pwd=#{param2}")
	public DDUser getUserInfo(String uname, String pwd);
}
