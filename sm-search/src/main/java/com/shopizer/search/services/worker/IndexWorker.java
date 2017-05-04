<<<<<<< HEAD
package com.shopizer.search.services.worker;

import com.shopizer.search.utils.SearchClient;

public interface IndexWorker {
	
	public void init(SearchClient client);
	public void execute(SearchClient client, String json, String collection, String object, String id, ExecutionContext context) throws Exception;

}
=======
package com.shopizer.search.services.worker;

import com.shopizer.search.utils.SearchClient;

public interface IndexWorker {
	
	public void init(SearchClient client);
	public void execute(SearchClient client, String json, String collection, String object, String id, ExecutionContext context) throws Exception;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
