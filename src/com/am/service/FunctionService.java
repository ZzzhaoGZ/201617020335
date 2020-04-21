package com.am.service;

import java.util.List;

import com.am.pojo.MenuVO;
import com.am.pojo.TRole;
import com.am.util.AMResult;
import com.am.util.TreeNode;

public interface FunctionService {

	public List<MenuVO> getMenus();

	public List<MenuVO> getMenusByMenuID(Integer userId);

	public List<TRole> getRoleList();

	public AMResult getFunctionIdsByUserId(Integer userid);

	public AMResult addUserFunction(Integer userid, Integer roleid);

}
