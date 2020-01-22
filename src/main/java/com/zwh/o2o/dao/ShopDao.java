package com.zwh.o2o.dao;

import com.zwh.o2o.entity.Shop;

 public interface ShopDao {
    /**
     * 新增店铺
     * @param shopCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    int insertShop(Shop shop);

    
    /**
     * 更新店铺信息
     */
    int updateShop(Shop shop);
 }
