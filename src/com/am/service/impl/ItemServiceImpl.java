package com.am.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TItemMapper;
import com.am.pojo.ItemVO;
import com.am.pojo.TItem;
import com.am.pojo.TItemExample;
import com.am.pojo.TItemExample.Criteria;
import com.am.service.ItemService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TItemMapper tItemMapper;

	@Override
	public EasyUIResult getItemList(TItem item,Integer page, Integer rows) {
		Map param = new HashedMap();
		if(item!=null){
			param.put("speciesid", item.getCid());
			param.put("title", item.getTitle());
		}
		// 设置分页
		PageHelper.startPage(page, rows);
		List<ItemVO> list = tItemMapper.selectItemBycondition(param);
		// 取分页信息
		PageInfo<ItemVO> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIResult result = new EasyUIResult(total, list);
		return result;
	}

	@Override
	public AMResult addItem(TItem tItem) {
		int row = tItemMapper.insert(tItem);
		if(row>0){
			return AMResult.build(200, "商品记录新增成功");
		}
		return AMResult.build(201, "商品记录新增失败");
	}

	@Override
	public AMResult updateItem(TItem tItem) {
		tItem.setUpdated(new Date());
		int row = tItemMapper.updateByPrimaryKeySelective(tItem);
		if(row>0){
			return AMResult.build(200, "商品记录修改成功");
		}
		return AMResult.build(201, "商品记录修改失败");
	}

	@Override
	public AMResult deleteItem(long id) {
		
		//int row  = tItemMapper.deleteByPrimaryKey(id);
		TItem tItem = tItemMapper.selectByPrimaryKey(id);
		if(tItem!=null){
			tItem.setStatus((byte) 3);
			int row =tItemMapper.updateByPrimaryKeySelective(tItem);
			if(row>0){
				return AMResult.build(200, "商品记录删除成功");
			}
		}
		return AMResult.build(201, "商品记录删除失败");
	}

	@Override
	public List<TItem> getItemBycid(Long cid) {
		
		TItemExample example = new TItemExample();
		Criteria criteria = example.createCriteria();

		if(cid!=null){
			criteria.andCidEqualTo(cid);
		}
		criteria.andStatusEqualTo((byte)1);
		List<TItem> list =tItemMapper.selectByExample(example );
		return list;
	}

}
