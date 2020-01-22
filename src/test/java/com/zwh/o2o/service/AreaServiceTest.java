package com.zwh.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

import com.zwh.o2o.BaseTest;
import com.zwh.o2o.entity.Area;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;
	@Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("x", areaList.get(0).getAreaName());
    }
}
