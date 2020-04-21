package com.am.service;

import java.util.List;

import com.am.pojo.TItem;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

public interface ItemService {

	public EasyUIResult getItemList(TItem item,Integer page, Integer rows);

	public AMResult addItem(TItem tItem);

	public AMResult updateItem(TItem tItem);

	public AMResult deleteItem(long id);
	
	public List<TItem> getItemBycid(Long cid);
	

}
