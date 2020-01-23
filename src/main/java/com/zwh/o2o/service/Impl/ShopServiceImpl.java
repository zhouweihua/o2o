package com.zwh.o2o.service.Impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwh.o2o.dao.ShopDao;
import com.zwh.o2o.dto.ShopExecution;
import com.zwh.o2o.entity.Shop;
import com.zwh.o2o.enums.ShopStateEnum;
import com.zwh.o2o.exceptions.ShopOperationException;
import com.zwh.o2o.service.ShopService;
import com.zwh.o2o.util.ImageUtil;
import com.zwh.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	
	@Override
	public ShopExecution addShop(Shop shop, File shopImg) {
		// 空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}

		try {// 给店铺信息赋值初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (shopImg != null) {
					// 存储图片
					try {
						addShopImg(shop, shopImg);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}

		} catch (Exception e) {
			throw new ShopOperationException("addShop error: " + e.getMessage());
		}

		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, File shopImg) {
		// 获取shop图片的相对路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
