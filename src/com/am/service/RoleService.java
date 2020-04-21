package com.am.service;

import java.util.List;

import com.am.pojo.TRole;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.am.util.TreeNode;

public interface RoleService {

	public EasyUIResult getRoles(TRole tRole);

	public AMResult addRole(TRole tRole, String functionIds);

	public AMResult updateRole(TRole tRole, String functionIds);

	public AMResult deleteRole(Integer roleid);

	public List<TreeNode> getFunctionTreeData();

	public AMResult getFunctionIdsByUserId(Integer roleid);

}
