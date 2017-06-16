<<<<<<< HEAD
package com.shopizer.search.services.worker;

import com.shopizer.search.services.SearchRequest;
import com.shopizer.search.services.SearchResponse;
import com.shopizer.search.utils.SearchClient;

public interface SearchWorker {
	
	public SearchResponse execute(SearchClient client, SearchRequest request, ExecutionContext context) throws Exception;

}
=======
package com.shopizer.search.services.worker;

import com.shopizer.search.services.SearchRequest;
import com.shopizer.search.services.SearchResponse;
import com.shopizer.search.utils.SearchClient;

public interface SearchWorker {
	
	public SearchResponse execute(SearchClient client, SearchRequest request, ExecutionContext context) throws Exception;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
