package com.am.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.TRole;
import com.am.service.RoleService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.am.util.TreeNode;

@Controller
public class RoleController {

	/**
	 * 用于处理Date类型参数处理
	 * 
	 * @return
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@Autowired
	private RoleService roleService;

	@RequestMapping("/role/getroles")
	@ResponseBody
	public EasyUIResult getRoles(TRole tRole) {
		return roleService.getRoles(tRole);
	}

	@RequestMapping("/role/addrole")
	@ResponseBody
	public AMResult addRole(TRole tRole, String functionIds) {
		tRole.setRolecreate(new Date());
		return roleService.addRole(tRole, functionIds);
	}

	@RequestMapping("/role/updaterole")
	@ResponseBody
	public AMResult updateRole(TRole tRole, String functionIds) {
		return roleService.updateRole(tRole, functionIds);
	}

	@RequestMapping("/role/deleterole")
	@ResponseBody
	public AMResult deleteRole(Integer roleid) {
		return roleService.deleteRole(roleid);
	}

	@RequestMapping(value = "/role/getFunctionIdsByRoleId")
	@ResponseBody
	public AMResult getFunctionIdsByUserId(Integer roleid) {

		AMResult result = roleService.getFunctionIdsByUserId(roleid);
		return result;

	}

	@RequestMapping(value = "/role/getFunctionTreeData", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TreeNode> getFunctionTreeData() {
		List<TreeNode> result = new ArrayList<TreeNode>();
		result = roleService.getFunctionTreeData();
		return result;
	}

}
