package com.zwh.o2o.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwh.o2o.dao.ShopCategoryDao;
import com.zwh.o2o.entity.ShopCategory;
import com.zwh.o2o.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
		return shopCategoryDao.queryShopCategory(shopCategory);
	}
};
