package com.am.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TFunctionMapper;
import com.am.mapper.TRoleFunctionMapper;
import com.am.mapper.TRoleMapper;
import com.am.mapper.TUserRoleMapper;
import com.am.pojo.TFunction;
import com.am.pojo.TFunctionExample;
import com.am.pojo.TRole;
import com.am.pojo.TRoleExample;
import com.am.pojo.TRoleFunction;
import com.am.pojo.TRoleFunctionExample;
import com.am.pojo.TUserRole;
import com.am.pojo.TUserRoleExample;
import com.am.service.RoleService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.am.util.TreeNode;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TRoleMapper tRoleMapper;

	@Autowired
	private TRoleFunctionMapper tRoleFunctionMapper;

	@Autowired
	private TUserRoleMapper tUserRoleMapper;

	@Autowired
	private TFunctionMapper tFunctionMapper;

	@Override
	public EasyUIResult getRoles(TRole tRole) {

		TRoleExample example = new TRoleExample();
		if (tRole != null) {
			if (tRole.getRolename() != null && !"".equals(tRole.getRolename())) {
				example.createCriteria().andRolenameLike("%"+tRole.getRolename()+"%");
			}
		}
		List<TRole> list = tRoleMapper.selectByExample(example);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addRole(TRole tRole, String functionIds) {

		int row = tRoleMapper.insert(tRole);
		if (row > 0) {
			return apply(tRole.getRoleid(), functionIds);
		}

		return AMResult.build(201, "添加角色失败");
	}

	private AMResult apply(Integer roleid, String functionIds) {
		// 删除用户的旧权限
		TRoleFunctionExample example = new TRoleFunctionExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		tRoleFunctionMapper.deleteByExample(example);
		// 添加新权限
		Map<Integer, Object> parentIds = new HashMap<Integer, Object>();
		if (functionIds != null && !"".equals(functionIds)) {
			String[] list = functionIds.split(",");
			for (String str : list) {
				Integer functionId = Integer.parseInt(str);
				TFunction tfunction = tFunctionMapper.selectByPrimaryKey(functionId);
				if (null != tfunction) {
					parentIds.put(tfunction.getFunctionparentid(), tfunction);
				}
				TRoleFunction record = new TRoleFunction();
				record.setRoleid(roleid);
				record.setFunctionid(Integer.parseInt(str));
				tRoleFunctionMapper.insert(record);
			}
			// 将父节点的功能也保存下来
			Iterator iterator = parentIds.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Integer parentId = (Integer) entry.getKey();
				TRoleFunction record = new TRoleFunction();
				record.setRoleid(roleid);
				record.setFunctionid(parentId);
				tRoleFunctionMapper.insert(record);
			}
		}
		return AMResult.build(200, "权限修改成功");
	}

	@Override
	public AMResult updateRole(TRole tRole, String functionIds) {
		int row = tRoleMapper.updateByPrimaryKeySelective(tRole);
		if (row > 0) {
			return apply(tRole.getRoleid(), functionIds);
		}
		return AMResult.build(201, "修改角色失败");
	}

	@Override
	public AMResult deleteRole(Integer roleid) {

		TUserRoleExample example = new TUserRoleExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		List<TUserRole> list = tUserRoleMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "当前角色已有用户使用，无法删除");
		}
		tUserRoleMapper.deleteByExample(example);

		TRoleFunctionExample roleexample = new TRoleFunctionExample();
		roleexample.createCriteria().andRoleidEqualTo(roleid);
		tRoleFunctionMapper.deleteByExample(roleexample);

		tRoleMapper.deleteByPrimaryKey(roleid);

		return AMResult.build(200, "删除角色成功");
	}

	@Override
	public List<TreeNode> getFunctionTreeData() {
		List<TreeNode> result = new ArrayList<TreeNode>();
		result = getTreeData(0);
		return result;
	}

	private List<TreeNode> getTreeData(Integer functionParentId) {

		List<TreeNode> result = new ArrayList<TreeNode>();
		TFunctionExample example = new TFunctionExample();
		example.createCriteria().andFunctionparentidEqualTo(functionParentId);
		List<TFunction> functionList = tFunctionMapper.selectByExample(example);
		if (functionList != null && functionList.size() > 0) {
			for (TFunction tFunction : functionList) {
				TreeNode node = new TreeNode();
				node.setId(tFunction.getFunctionid());
				node.setText(tFunction.getFunctionname());
				node.setState("open");
				if (tFunction.getFunctionisparent()) {
					node.setChildren(getTreeData(tFunction.getFunctionid()));
				} else {
					node.setChildren(null);
				}
				result.add(node);
			}
		} else {
			return null;
		}
		return result;
	}

	@Override
	public AMResult getFunctionIdsByUserId(Integer roleid) {
		TRoleFunctionExample example = new TRoleFunctionExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		List<TRoleFunction> list = tRoleFunctionMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			//int[] functionids = new int[list.size()];
			int index = 0;
			List<Integer> flist = new ArrayList<>();
			for (TRoleFunction temp : list) {
				TFunction tFunction = tFunctionMapper.selectByPrimaryKey(temp.getFunctionid());
				if (tFunction != null && tFunction.getFunctionparentid() != 0) {
				//	functionids[index] = temp.getFunctionid();
					flist.add(temp.getFunctionid());
					index++;
				}

			}
			return AMResult.build(200, "获取数据成功", flist.toArray());
		}
		return AMResult.build(201, "当前用户未设置权限");
	}

}
