package com.am.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TItemMapper;
import com.am.mapper.TSpeciesMapper;
import com.am.pojo.TItem;
import com.am.pojo.TItemExample;
import com.am.pojo.TSpecies;
import com.am.pojo.TSpeciesExample;
import com.am.service.SpeciesService;
import com.am.util.AMResult;
import com.am.util.SpeciesNode;
@Service
public class SpeciesServiceImpl implements SpeciesService{
	
	@Autowired
	private TSpeciesMapper tSpeciesMapper;
	
	@Autowired
	private TItemMapper tItemMapper;


	@Override
	public List<SpeciesNode> getSpeciesNode(Integer parentid) {
		return getNodeList(parentid);
	}
	
	private List<SpeciesNode> getNodeList(Integer parentid){
		List<SpeciesNode> resultList = new ArrayList<SpeciesNode>();
		TSpeciesExample example = new TSpeciesExample();
		example.createCriteria().andSpeciesparentidEqualTo(parentid);
		List<TSpecies> list = tSpeciesMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			for(TSpecies temp :list){
				SpeciesNode node = new SpeciesNode();
				node.setId(temp.getSpeciesid());
				node.setText(temp.getSpeciesname());
				node.setState(temp.getIsparent()?"closed":"open");
				if(temp.getIsparent()){
					node.setChildren(getNodeList(temp.getSpeciesid()));
				}else{
					//node.setChildren(null);
				}
				resultList.add(node);
			}
		}
		return resultList;
	}

	@Override
	public AMResult addSpecies(TSpecies record) {
		record.setIsparent(false);
		record.setSpeciestime(new Date());
		int row = tSpeciesMapper.insert(record);
		int parentId = record.getSpeciesparentid();
		TSpecies parent =  tSpeciesMapper.selectByPrimaryKey(parentId);
		if(!parent.getIsparent()){
			parent.setIsparent(true);
			tSpeciesMapper.updateByPrimaryKey(parent);
		}
		if(row>0){
			return AMResult.build(200, "添加成功",record);
		}
		return AMResult.build(201, "添加失败",record);
	}

	@Override
	public AMResult updateSpecies(TSpecies record) {
		
		Integer speciesid = record.getSpeciesid();
		TSpecies old = tSpeciesMapper.selectByPrimaryKey(speciesid);
		old.setSpeciesname(record.getSpeciesname());
		int row = tSpeciesMapper.updateByPrimaryKey(old);
		if(row>0){
			return AMResult.build(200, "修改成功",old);
		}
		return AMResult.build(201, "修改失败",old);
	}

	@Override
	public AMResult deleteSpecies(Integer speciesId) {
		
		TSpeciesExample example = new TSpeciesExample();
		example.createCriteria().andSpeciesparentidEqualTo(speciesId);
		List<TSpecies> list = tSpeciesMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return AMResult.build(201, "请先删除子节点");
		}
	
		//判断当前分类下是否有宠物记录
		TItemExample itemexample  =new TItemExample(); 
		itemexample.createCriteria().andCidEqualTo(Long.valueOf(speciesId));
		List<TItem> itemList = tItemMapper.selectByExample(itemexample);
		if(itemList!=null&&itemList.size()>0){
			return AMResult.build(201, "当前分类下有商品记录，无法删除");
		}
		int row = tSpeciesMapper.deleteByPrimaryKey(speciesId);
		if(row>0){
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(202, "删除失败");
	}

}
