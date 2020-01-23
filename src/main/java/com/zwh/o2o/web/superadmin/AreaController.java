package com.zwh.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwh.o2o.entity.Area;
import com.zwh.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	
	Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/listareas", method = RequestMethod.GET)
	@ResponseBody // JSON格式
	private Map<String, Object> listAreas() {
		logger.info("------- listAreas start -------");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		try {
			list = areaService.getAreaList();
			modelMap.put("row", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		
		logger.error("------- listAreas test error -------");
		
		long endTime = System.currentTimeMillis();
		logger.debug("listAreas costTime --->", endTime - startTime);
		logger.info("------- listAreas start -------");
		return modelMap;
	}
}
