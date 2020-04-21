package com.am.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.am.mapper.TUserMapper;
import com.am.pojo.LoginVO;
import com.am.pojo.TUser;
import com.am.pojo.TUserExample;
import com.am.pojo.TUserExample.Criteria;
import com.am.service.UserService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.am.util.StaticKey;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper tUserMapper;

	@Value("${ImageCode.sessionKey}")
	private String sessionKey;

	@Override
	public AMResult login(LoginVO login, HttpServletRequest request) {

		String userloginid = login.getUserloginid();
		String passwd = login.getUserloginpasswd();
		//String imageCode = login.getImagecode();

		/*if (imageCode == null || "".equals(imageCode)) {
			return AMResult.build(203, " 验证码不能为空!!!");
		}*/

		if (userloginid == null || "".equals(userloginid)) {
			return AMResult.build(204, " 用户名不能为空!!!");
		}

		if (passwd == null || "".equals(passwd)) {
			return AMResult.build(204, " 密码不能为空!!!");
		}

		// 获取session的验证码
		String sessionImageCode = (String) request.getSession().getAttribute(
				sessionKey);
		/*if (!imageCode.toLowerCase().equals(sessionImageCode.toLowerCase())) {
			return AMResult.build(203, "验证码错误!!!");
		}*/
		TUserExample example = new TUserExample();
		example.createCriteria().andUserloginidEqualTo(userloginid)
				.andUserloginpasswdEqualTo(passwd);
		List<TUser> list = tUserMapper.selectByExample(example);

		if (list != null && list.size() == 1) {
			request.getSession()
					.setAttribute(StaticKey.LOGIN_USER, list.get(0));
			if (userloginid.equals("admin")) {
				request.getSession().setAttribute(StaticKey.USER_TYPR,
						StaticKey.USER_1);
			} else {
				request.getSession().setAttribute(StaticKey.USER_TYPR,
						StaticKey.USER_2);
			}
			return AMResult.build(200, "登录成功", list.get(0));
		} else {
			return AMResult.build(201, "不存在的用户名或者密码");
		}
	}

	@Override
	public AMResult register(TUser tUser) throws Exception {

		if (tUser != null && !"".equals(tUser.getUserloginid())) {
			TUserExample example = new TUserExample();

			example.createCriteria().andUserloginidEqualTo(
					tUser.getUserloginid());
			List<TUser> list = tUserMapper.selectByExample(example);

			// 如果有重名的，则无法注册
			if (list != null && list.size() > 1) {
				return AMResult.build(201, "注册失败，用户名已存在");
			}
			// 插入到用户表
			int row = tUserMapper.insert(tUser);
			if (row > 0) {
				return AMResult.build(200, "注册成功！！！");
			}
		}

		return AMResult.build(202, "未知错误");
	}

	@Override
	public AMResult updatePd(TUser tUser) {
		int row = tUserMapper.updateByPrimaryKey(tUser);
		if (row > 0) {
			return AMResult.build(200, "密码修改成功！！！");
		}
		return AMResult.build(201, "修改失败！！！");
	}

	@Override
	public AMResult deleteUser(Integer userId) {

		TUser user = tUserMapper.selectByPrimaryKey(userId);
		if (user != null) {
			String userloginid = user.getUserloginid();
			if ("admin".equals(userloginid)) {
				return AMResult.build(201, "管理员不可删除");
			}
			int row = tUserMapper.deleteByPrimaryKey(userId);
			if (row > 0) {
				return AMResult.build(200, "记录删除成功");
			}
		}
		return AMResult.build(202, "删除失败，请先刷新记录");
	}

	@Override
	public EasyUIResult getUsers(TUser tUser) {
		EasyUIResult result = new EasyUIResult();
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		if (tUser != null) {
			if (tUser.getUserloginid() != null) {
				criteria.andUserloginidLike("%" + tUser.getUserloginid() + "%");
			}
		}
		criteria.andUserloginidNotEqualTo("admin");
		List<TUser> list = tUserMapper.selectByExample(example);
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addUser(TUser tUser) {

		if ("admin".equals(tUser.getUserloginid())) {
			return AMResult.build(202, "admin是管理员，请更换名称!!！");
		}

		TUserExample example = new TUserExample();

		example.createCriteria().andUserloginidEqualTo(tUser.getUserloginid());
		List<TUser> list = tUserMapper.selectByExample(example);

		// 如果有重名的，则无法注册
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "用户名已存在!!！");
		}
		int row = tUserMapper.insert(tUser);
		if (row > 0) {
			return AMResult.build(200, "新增用户成功");
		}
		return AMResult.build(201, "新增失败");
	}

	@Override
	public AMResult updateUser(TUser tUser) {
		if ("admin".equals(tUser.getUserloginid())) {
			return AMResult.build(202, "admin是管理员，请更换名称!!！");
		}
		TUserExample example = new TUserExample();

		example.createCriteria().andUserloginidEqualTo(tUser.getUserloginid())
				.andUseridNotEqualTo(tUser.getUserid());
		List<TUser> list = tUserMapper.selectByExample(example);

		// 如果有重名的，则无法注册
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "用户名已存在!!！");
		}
		int row = tUserMapper.insert(tUser);
		if (row > 0) {
			return AMResult.build(200, "修改用户成功");
		}
		return AMResult.build(201, "修改失败");
	}

}
