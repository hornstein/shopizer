<<<<<<< HEAD
package com.salesmanager.core.model.search;

import java.util.List;
import java.util.Map;

public class SearchResponse {
	
	private long totalCount = 0;//total number of entries
	private long entryCount = 0;//number of entries asked
	
	private List<SearchEntry> entries;
	private Map<String,List<SearchFacet>> facets;//facet key (example : category) & facet description (example : category code)
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setEntryCount(long entryCount) {
		this.entryCount = entryCount;
	}
	public long getEntryCount() {
		return entryCount;
	}
	public void setEntries(List<SearchEntry> entries) {
		this.entries = entries;
	}
	public List<SearchEntry> getEntries() {
		return entries;
	}
	public void setFacets(Map<String,List<SearchFacet>> facets) {
		this.facets = facets;
	}
	public Map<String,List<SearchFacet>> getFacets() {
		return facets;
	}

}
=======
package com.salesmanager.core.model.search;

import java.util.List;
import java.util.Map;

public class SearchResponse {
	
	private long totalCount = 0;//total number of entries
	private long entryCount = 0;//number of entries asked
	
	private List<SearchEntry> entries;
	private Map<String,List<SearchFacet>> facets;//facet key (example : category) & facet description (example : category code)
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setEntryCount(long entryCount) {
		this.entryCount = entryCount;
	}
	public long getEntryCount() {
		return entryCount;
	}
	public void setEntries(List<SearchEntry> entries) {
		this.entries = entries;
	}
	public List<SearchEntry> getEntries() {
		return entries;
	}
	public void setFacets(Map<String,List<SearchFacet>> facets) {
		this.facets = facets;
	}
	public Map<String,List<SearchFacet>> getFacets() {
		return facets;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
