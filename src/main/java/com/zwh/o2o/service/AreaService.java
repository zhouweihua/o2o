package com.zwh.o2o.service;

import java.util.List;
import com.zwh.o2o.entity.Area;

public interface AreaService {
	/**
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	List<Area> getAreaList();

}
