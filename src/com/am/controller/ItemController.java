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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.TItem;
import com.am.service.ItemService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.EasyUIResult;

@Controller
public class ItemController {

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
	private ItemService itemService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIResult getItemList(TItem tItem, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows) {
		// 查询商品列表
		EasyUIResult result = itemService.getItemList(tItem, page, rows);

		return result;

	}

	@RequestMapping("/item/additem")
	@ResponseBody
	public AMResult addItem(TItem tItem) {
		return itemService.addItem(tItem);
	}

	@RequestMapping("/item/updateitem")
	@ResponseBody
	public AMResult updateItem(TItem tItem) {
		return itemService.updateItem(tItem);
	}

	@RequestMapping("/item/deleteitem")
	@ResponseBody
	public AMResult deleteItem(Long id) {
		return itemService.deleteItem(id);
	}

	@RequestMapping("/item/getitemcheckboxdata")
	@ResponseBody
	public List<CheckBoxVO> getItemCheckboxData(Long cid) {

		List<TItem> list = itemService.getItemBycid(cid);
		List<CheckBoxVO> result = new ArrayList<CheckBoxVO>();
		if (list != null && list.size() > 0) {
			for (TItem tItem : list) {
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(tItem.getId()));
				vo.setText(tItem.getTitle());
				result.add(vo);
			}
		}
		return result;
	}

}
