package com.zwh.o2o.service;

import java.io.IOException;
import java.util.List;

import com.zwh.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	/**
	 * 
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);

}
