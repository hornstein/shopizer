<<<<<<< HEAD
package com.salesmanager.core.model.search;

import java.util.List;

public class SearchEntry {
	
	private IndexProduct indexProduct;//product as saved in the index
	private List<String> highlights;
	public void setHighlights(List<String> highlights) {
		this.highlights = highlights;
	}
	public List<String> getHighlights() {
		return highlights;
	}
	public void setIndexProduct(IndexProduct indexProduct) {
		this.indexProduct = indexProduct;
	}
	public IndexProduct getIndexProduct() {
		return indexProduct;
	}

}
=======
package com.salesmanager.core.model.search;

import java.util.List;

public class SearchEntry {
	
	private IndexProduct indexProduct;//product as saved in the index
	private List<String> highlights;
	public void setHighlights(List<String> highlights) {
		this.highlights = highlights;
	}
	public List<String> getHighlights() {
		return highlights;
	}
	public void setIndexProduct(IndexProduct indexProduct) {
		this.indexProduct = indexProduct;
	}
	public IndexProduct getIndexProduct() {
		return indexProduct;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
