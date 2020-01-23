package com.zwh.o2o.service;

import java.io.InputStream;

import com.zwh.o2o.dto.ShopExecution;
import com.zwh.o2o.entity.Shop;


public interface ShopService {
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
