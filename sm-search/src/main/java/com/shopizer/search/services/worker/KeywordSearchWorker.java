<<<<<<< HEAD
package com.shopizer.search.services.worker;

import com.shopizer.search.services.SearchResponse;
import com.shopizer.search.utils.SearchClient;

public interface KeywordSearchWorker {
	
	public SearchResponse execute(SearchClient client,String collection,String json,int size, ExecutionContext context) throws Exception;

}
=======
package com.shopizer.search.services.worker;

import com.shopizer.search.services.SearchResponse;
import com.shopizer.search.utils.SearchClient;

public interface KeywordSearchWorker {
	
	public SearchResponse execute(SearchClient client,String collection,String json,int size, ExecutionContext context) throws Exception;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
