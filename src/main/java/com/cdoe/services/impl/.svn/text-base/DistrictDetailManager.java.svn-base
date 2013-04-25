package com.cdoe.services.impl;

import java.util.List;

import com.cdoe.biz.IOrganizationUnitMasterDAO;
import com.cdoe.biz.impl.OrganizationUnitMasterDAO;
import com.cdoe.biz.model.OrganizationUnitMaster;
import com.ctc.wstx.util.SimpleCache;


class DistrictDetailManager {
	static SimpleCache districtCache;
	private IOrganizationUnitMasterDAO districtDetailDAO;
	
	
	
	public void setDistrictDetailDAO(IOrganizationUnitMasterDAO districtDetailDAO) {
		this.districtDetailDAO = districtDetailDAO;
	}



	void fillDistrictCache() {
		districtDetailDAO = new OrganizationUnitMasterDAO();
		districtCache = new SimpleCache(100);
		List<OrganizationUnitMaster> districts = districtDetailDAO.getAllOrganizations();
		for (OrganizationUnitMaster district:districts ) {
		   districtCache.add(district.getOrganizationCode(), district.getOrganizationName());
		}
		
	}
	
	
	
	public static void  main(String[] args) {
		DistrictDetailManager  ddmanager = new DistrictDetailManager();
		ddmanager.fillDistrictCache();
		
	}

}
