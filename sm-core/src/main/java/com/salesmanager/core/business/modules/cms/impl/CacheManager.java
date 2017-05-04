<<<<<<< HEAD
package com.salesmanager.core.business.modules.cms.impl;

import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.tree.TreeCache;

public interface CacheManager {
	
	public EmbeddedCacheManager getManager();
	
	@SuppressWarnings("rawtypes")
	public TreeCache getTreeCache();

}
=======
package com.salesmanager.core.business.modules.cms.impl;

import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.tree.TreeCache;

public interface CacheManager {
	
	public EmbeddedCacheManager getManager();
	
	@SuppressWarnings("rawtypes")
	public TreeCache getTreeCache();

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
