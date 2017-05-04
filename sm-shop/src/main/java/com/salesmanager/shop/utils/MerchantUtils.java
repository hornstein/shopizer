<<<<<<< HEAD
package com.salesmanager.shop.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.salesmanager.core.model.merchant.MerchantStore;

public class MerchantUtils {
	
	public String getFooterMessage(MerchantStore store, String prefix, String suffix) {
		
		StringBuilder footerMessage = new StringBuilder();
		
		if(!StringUtils.isBlank(prefix)) {
			footerMessage.append(prefix).append(" ");
		}
		
		Date sinceDate = null;
		String inBusinessSince = store.getDateBusinessSince();
		
		
		return null;
	}

}
=======
package com.salesmanager.shop.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.salesmanager.core.model.merchant.MerchantStore;

public class MerchantUtils {
	
	public String getFooterMessage(MerchantStore store, String prefix, String suffix) {
		
		StringBuilder footerMessage = new StringBuilder();
		
		if(!StringUtils.isBlank(prefix)) {
			footerMessage.append(prefix).append(" ");
		}
		
		Date sinceDate = null;
		String inBusinessSince = store.getDateBusinessSince();
		
		
		return null;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
