package com.zwh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zwh.o2o.BaseTest;
import com.zwh.o2o.dto.ShopExecution;
import com.zwh.o2o.entity.Area;
import com.zwh.o2o.entity.PersonInfo;
import com.zwh.o2o.entity.Shop;
import com.zwh.o2o.entity.ShopCategory;
import com.zwh.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("/Users/zhouweihua/Downloads/xxx.jpg");
        InputStream in = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, in, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
	}
}
