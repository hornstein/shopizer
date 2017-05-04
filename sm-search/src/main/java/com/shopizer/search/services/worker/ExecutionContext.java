<<<<<<< HEAD
package com.shopizer.search.services.worker;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {
	
	private Map internalMap = new HashMap();
	
	public Object getObject(String key) {
		return internalMap.get(key);
	}
	
	public void setObject(String key, Object o) {
		internalMap.put(key, o);
	}
}
=======
package com.shopizer.search.services.worker;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {
	
	private Map internalMap = new HashMap();
	
	public Object getObject(String key) {
		return internalMap.get(key);
	}
	
	public void setObject(String key, Object o) {
		internalMap.put(key, o);
	}
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
