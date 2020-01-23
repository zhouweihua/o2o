package com.zwh.o2o.web.shopadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shopadmin")
public class ShopAdminController {

	private Logger logger = LoggerFactory.getLogger(ShopAdminController.class);

	@RequestMapping(value = "/shopoperation", method = { RequestMethod.GET })
	public String shopOperation() {
//		logger.info("shop/shopoperation ----> ");
		return "shop/shopoperation";
	}
}