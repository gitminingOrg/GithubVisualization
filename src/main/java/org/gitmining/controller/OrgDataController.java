package org.gitmining.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.*;
import org.gitmining.service.OrgDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgDataController {
	private static final Logger logger = LogManager.getLogger(OrgDataController.class.getName());
	private OrgDataService orgDataService;

	public OrgDataService getOrgDataService() {
		return orgDataService;
	}
	public void setOrgDataService(OrgDataService orgDataService) {
		this.orgDataService = orgDataService;
	}
	
	@RequestMapping(value="/orgTotalData",method=RequestMethod.GET)
	public Map getOrgLnMap(){
		logger.debug("wahahahahahaha");
		Map<String, List> result = new HashMap<String, List>();
		List<double[]> repoMemberList = orgDataService.getOrgLnMap();
		result.put("repoMemberList", repoMemberList);
		return result;
	}
}
