package com.am.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.TSpecies;
import com.am.service.SpeciesService;
import com.am.util.AMResult;
import com.am.util.SpeciesNode;

@Controller
public class SpeciesController {
	@Autowired
	private SpeciesService speciesService;

	@RequestMapping("/species/getSpeciesData")
	@ResponseBody
	public List<SpeciesNode> getSpeciesNode(@RequestParam(value="id",defaultValue="0")Integer parentId) {
		return speciesService.getSpeciesNode(parentId);
	}

	@RequestMapping("/species/addSpecies")
	@ResponseBody
	public AMResult addSpecies(TSpecies record) {
		AMResult result = speciesService.addSpecies(record);
		return result;
	}

	@RequestMapping("/species/updateSpecies")
	@ResponseBody
	public AMResult updateSpecies(TSpecies record) {
		AMResult result = speciesService.updateSpecies(record);
		return result;
	}
	@RequestMapping("/species/deleteSpecies")
	@ResponseBody
	public AMResult deleteSpecies(Integer speciesId) {
		AMResult result = speciesService.deleteSpecies(speciesId);
		return result;
	}

}
