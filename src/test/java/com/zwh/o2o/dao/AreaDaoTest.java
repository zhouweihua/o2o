package com.zwh.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.zwh.o2o.BaseTest;
import com.zwh.o2o.entity.Area;


public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testQueryArea() throws Exception {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}
}
