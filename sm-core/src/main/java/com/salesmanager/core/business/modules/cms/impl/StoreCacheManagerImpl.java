<<<<<<< HEAD
package com.salesmanager.core.business.modules.cms.impl;



/**
 * Used for managing images
 * @author casams1
 *
 */
public class StoreCacheManagerImpl extends CacheManagerImpl {
	
	
	private static  StoreCacheManagerImpl cacheManager = null;
	private final static String NAMED_CACHE = "StoreRepository";
	

	

	private StoreCacheManagerImpl() {
		
		super.init(NAMED_CACHE);
		
		
	}

	
	public static StoreCacheManagerImpl getInstance() {
		
		if(cacheManager==null) {
			cacheManager = new StoreCacheManagerImpl();

		}
		
		return cacheManager;
		
		
	}



}

=======
package com.salesmanager.core.business.modules.cms.impl;



/**
 * Used for managing images
 * @author casams1
 *
 */
public class StoreCacheManagerImpl extends CacheManagerImpl {
	
	
	private static  StoreCacheManagerImpl cacheManager = null;
	private final static String NAMED_CACHE = "StoreRepository";
	

	

	private StoreCacheManagerImpl() {
		
		super.init(NAMED_CACHE);
		
		
	}

	
	public static StoreCacheManagerImpl getInstance() {
		
		if(cacheManager==null) {
			cacheManager = new StoreCacheManagerImpl();

		}
		
		return cacheManager;
		
		
	}



}

>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
