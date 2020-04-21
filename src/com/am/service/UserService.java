package com.am.service;

import javax.servlet.http.HttpServletRequest;

import com.am.pojo.LoginVO;
import com.am.pojo.TUser;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

public interface UserService {
	
	/**
	 * 根据用户名和密码登录
	 * @param userName
	 * @param Passwd
	 * @return
	 */
	public AMResult login(LoginVO login,HttpServletRequest request) throws Exception ;
	
	/**
	 * 注册用户
	 * @param tUser
	 */
	public AMResult register(TUser tUser) throws Exception ;
	
	/**
	 * 修改密码
	 * @param passwwd
	 * @return
	 */
	public AMResult updatePd(TUser tUser);
	
	/**
	 * 新增用户
	 * @param tUser
	 * @return
	 */
	public AMResult addUser(TUser tUser);
	
	/**
	 * 修改用户
	 * @param tUser
	 * @return
	 */
	public AMResult updateUser(TUser tUser);
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public AMResult deleteUser(Integer userId);
	
	/**
	 * 查询所有用户
	 * @param tUser
	 * @return
	 */
	public EasyUIResult getUsers(TUser tUser);
	

}
