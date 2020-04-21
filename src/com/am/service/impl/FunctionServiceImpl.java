package com.am.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TFunctionMapper;
import com.am.mapper.TRoleFunctionMapper;
import com.am.mapper.TRoleMapper;
import com.am.mapper.TUserRoleMapper;
import com.am.pojo.MenuVO;
import com.am.pojo.TFunction;
import com.am.pojo.TFunctionExample;
import com.am.pojo.TRole;
import com.am.pojo.TRoleExample;
import com.am.pojo.TRoleFunction;
import com.am.pojo.TRoleFunctionExample;
import com.am.pojo.TUserRole;
import com.am.pojo.TUserRoleExample;
import com.am.service.FunctionService;
import com.am.util.AMResult;
import com.am.util.TreeNode;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	TFunctionMapper tFunctionMapper;
	
	@Autowired
	TRoleMapper tRoleMapper;
	
	@Autowired
	TRoleFunctionMapper tRoleFunctionMapper;

	@Autowired
	private TUserRoleMapper tUserRoleMapper;

	public List<MenuVO> getMenuList(Integer parentId) {
		List<MenuVO> result = new ArrayList<MenuVO>();
		TFunctionExample example = new TFunctionExample();
		example.createCriteria().andFunctionparentidEqualTo(parentId);
		List<TFunction> functionList = tFunctionMapper.selectByExample(example);
		if (functionList != null && functionList.size() > 0) {
			for (TFunction tFunction : functionList) {
				MenuVO menuVO = new MenuVO();
				menuVO.setMenuid(String.valueOf(tFunction.getFunctionid()));
				menuVO.setMenuname(tFunction.getFunctionname());
				menuVO.setIcon("icon-sys");
				menuVO.setUrl(tFunction.getFunctionurl());
				if (tFunction.getFunctionisparent()) {
					menuVO.setMenus(getMenuList(tFunction.getFunctionid()));
				} else {
					menuVO.setMenus(null);
				}
				result.add(menuVO);
			}
		} else {
			return null;
		}

		return result;
	}

	@Override
	public List<MenuVO> getMenus() {
		List<MenuVO> listVO = getMenuList(0);
		return listVO;
	}

	@Override
	public List<MenuVO> getMenusByMenuID(Integer userId) {
		
		
		//根据用户id查询对应的角色
		TUserRoleExample roleexample =new TUserRoleExample();
		roleexample.createCriteria().andUseridEqualTo(userId);
		List<TUserRole> roleList =   tUserRoleMapper.selectByExample(roleexample);
		if(roleList!=null&&roleList.size()>0){
			TRoleFunctionExample example = new TRoleFunctionExample();
			example.createCriteria().andRoleidEqualTo(roleList.get(0).getRoleid());
			List<TRoleFunction> list = tRoleFunctionMapper.selectByExample(example);
			Map<Integer, TRoleFunction> map = convertListToMap(list);
			List<MenuVO> listVO = getMenuList(0, map);
			return listVO;
		}
		return null;
		
	}

	private List<MenuVO> getMenuList(int parentId, Map<Integer, TRoleFunction> map) {

		List<MenuVO> result = new ArrayList<MenuVO>();
		TFunctionExample example = new TFunctionExample();
		example.createCriteria().andFunctionparentidEqualTo(parentId);
		List<TFunction> functionList = tFunctionMapper.selectByExample(example);
		if (functionList != null && functionList.size() > 0) {
			for (TFunction tFunction : functionList) {
				Integer functionId = tFunction.getFunctionid();
				if (map.containsKey(functionId)) {
					MenuVO menuVO = new MenuVO();
					menuVO.setMenuid(String.valueOf(tFunction.getFunctionid()));
					menuVO.setMenuname(tFunction.getFunctionname());
					menuVO.setIcon("icon-sys");
					menuVO.setUrl(tFunction.getFunctionurl());
					if (tFunction.getFunctionisparent()) {
						menuVO.setMenus(getMenuList(tFunction.getFunctionid(),map));
					} else {
						menuVO.setMenus(null);
					}
					result.add(menuVO);
				}
			}
		} else {
			return null;
		}

		return result;

	}

	private Map<Integer, TRoleFunction> convertListToMap(
			List<TRoleFunction> list) {
		Map<Integer, TRoleFunction> map = new HashMap<Integer, TRoleFunction>();
		if (list != null && list.size() > 0) {
			for (TRoleFunction tTRoleFunction : list) {
				map.put(tTRoleFunction.getFunctionid(), tTRoleFunction);
			}
		}
		return map;
	}

	@Override
	public List<TRole> getRoleList() {
		List<TRole> result = new ArrayList<TRole>();
		TRoleExample example =new TRoleExample();
		result = tRoleMapper.selectByExample(example );
		return result;
	}
	private List<TreeNode> getTreeData(Integer functionParentId){

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
	public AMResult getFunctionIdsByUserId(Integer userid) {
		
		
		TUserRoleExample roleexample =new TUserRoleExample();
		roleexample.createCriteria().andUseridEqualTo(userid);
		List<TUserRole> roleList =   tUserRoleMapper.selectByExample(roleexample);
		if(roleList!=null&&roleList.size()>0){
			TUserRole tUserRole = roleList.get(0);
			return AMResult.build(200, "获取数据成功",tUserRole);
		}else{
			return AMResult.build(201, "当前用户未设置角色");
		}
	
		
	}

	@Override
	public AMResult addUserFunction(Integer userid, Integer roleid) {
		
		//根据用户id，查询出值钱的用户角色关系表记录并删除
		
		TUserRoleExample example = new TUserRoleExample();
		example.createCriteria().andUseridEqualTo(userid);
		tUserRoleMapper.deleteByExample(example);
		//插入新的用户角色关系
		TUserRole record = new TUserRole();
		record.setRoleid(roleid);
		record.setUserid(userid);
		tUserRoleMapper.insert(record);
		
		
		return AMResult.build(200, "权限修改成功");
	}

}
