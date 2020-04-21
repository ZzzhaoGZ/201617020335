package com.am.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.MenuVO;
import com.am.pojo.TRole;
import com.am.pojo.TUser;
import com.am.service.FunctionService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.StaticKey;
import com.am.util.TreeNode;

@Controller
public class FunctionController {
	@Autowired
	private FunctionService functionService;

	@RequestMapping(value = "/function/getmenus", produces = "application/json; charset=utf-8")
	@ResponseBody
	public AMResult getmenus(HttpServletRequest request) {

		try {
			List<MenuVO> list = new ArrayList<MenuVO>();
			// 从session获取登录用户的类型
			String loginType = (String) request.getSession().getAttribute(
					StaticKey.USER_TYPR);
			TUser currentUser = (TUser) request.getSession().getAttribute(
					StaticKey.LOGIN_USER);
			// 超级管理员
//			if (StaticKey.USER_1.equals(loginType)) {
//				list = functionService.getMenus();
//				// 普通用户
//			} else if (StaticKey.USER_2.equals(loginType)) {
				// list =
				// functionService.getMenusByMenuID(currentUser.getUserid());
			//如果用户名是admin  是超级管理员，权限不限制
			if("admin".equals(currentUser.getUserloginid())){
				list = functionService.getMenus();
			}else{
				list = functionService.getMenusByMenuID(currentUser.getUserid());
			}
			
				
			//}

			Map map = new HashMap();
			map.put("menus", list);
			return AMResult.build(200, "菜单查询成功", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return AMResult.build(201, "获取菜单失败");
	}

	@RequestMapping("/function/getRoleData")
	@ResponseBody
	public List<CheckBoxVO> getFunctionTreeData() {
		List<CheckBoxVO> result = new ArrayList<CheckBoxVO>();
		List<TRole> roles =functionService.getRoleList(); 
		if(roles!=null&&roles.size()>0){
			for(TRole tRole : roles){
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(tRole.getRoleid()));
				vo.setText(tRole.getRolename());	
				result.add(vo);
			}
		}
		return result;
	}

	@RequestMapping(value = "/function/getRoleByUserId")
	@ResponseBody
	public AMResult getFunctionIdsByUserId(Integer userid) {

		AMResult result = functionService.getFunctionIdsByUserId(userid);
		return result;

	}
	
	@RequestMapping(value = "/function/adduserrole")
	@ResponseBody
	public AMResult addUserRole(Integer userid,Integer roleid) {

		AMResult result = functionService.addUserFunction(userid,roleid);
		return result;

	}
	
}
