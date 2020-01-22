package com.zwh.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/listareas", method = RequestMethod.GET)
	@ResponseBody // JSON格式
	private Map<String, Object> listAreas() {

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
		return modelMap;
		
	}
}
