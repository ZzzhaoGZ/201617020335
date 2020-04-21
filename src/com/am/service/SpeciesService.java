package com.am.service;

import java.util.List;

import com.am.pojo.TSpecies;
import com.am.util.AMResult;
import com.am.util.EasyUITreeNode;
import com.am.util.SpeciesNode;

public interface SpeciesService {
	
	public List<SpeciesNode> getSpeciesNode(Integer parentid);
	
	public AMResult addSpecies(TSpecies record);
	
	public AMResult updateSpecies(TSpecies record);
	
	public AMResult deleteSpecies(Integer speciesId);

}
