package org.gitmining.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gitmining.service.OrgDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgDataController {
	private OrgDataService orgDataService;

	public OrgDataService getOrgDataService() {
		return orgDataService;
	}
	public void setOrgDataService(OrgDataService orgDataService) {
		this.orgDataService = orgDataService;
	}
	
	@RequestMapping(value="/orgTotalData",method=RequestMethod.GET)
	public Map getOrgLnMap(){
		Map<String, List> result = new HashMap<String, List>();
		List<double[]> repoMemberList = orgDataService.getOrgLnMap();
		result.put("repoMemberList", repoMemberList);
		return result;
	}
}
