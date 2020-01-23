package com.zwh.o2o.service;

import java.io.File;

import com.zwh.o2o.dto.ShopExecution;
import com.zwh.o2o.entity.Shop;


public interface ShopService {

	/**
	 * 创建商铺
	 * 
	 * @param Shop
	 *            shop
	 * @return ShopExecution shopExecution
	 * @throws Exception
	 */
	ShopExecution addShop(Shop shop, File shopImg);

}
