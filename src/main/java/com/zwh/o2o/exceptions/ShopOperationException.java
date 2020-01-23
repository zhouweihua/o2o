package com.zwh.o2o.exceptions;

public class ShopOperationException extends RuntimeException {
	//TODO 只有 RuntimeException 才能够让事务回滚
    private static final long serialVersionUID = -2174235994752246501L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
