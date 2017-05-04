<<<<<<< HEAD
package com.salesmanager.shop.model.catalog;

import java.util.ArrayList;
import java.util.List;

import com.salesmanager.shop.model.catalog.category.ReadableCategory;


/**
 * Object representing the results of a search query
 * @author Carl Samson
 *
 */
public class SearchProductList extends ProductList {
	

	private static final long serialVersionUID = 1L;
	private List<ReadableCategory> categoryFacets = new ArrayList<ReadableCategory>();
	public List<ReadableCategory> getCategoryFacets() {
		return categoryFacets;
	}
	public void setCategoryFacets(List<ReadableCategory> categoryFacets) {
		this.categoryFacets = categoryFacets;
	}


}
=======
package com.salesmanager.shop.model.catalog;

import java.util.ArrayList;
import java.util.List;

import com.salesmanager.shop.model.catalog.category.ReadableCategory;


/**
 * Object representing the results of a search query
 * @author Carl Samson
 *
 */
public class SearchProductList extends ProductList {
	

	private static final long serialVersionUID = 1L;
	private List<ReadableCategory> categoryFacets = new ArrayList<ReadableCategory>();
	public List<ReadableCategory> getCategoryFacets() {
		return categoryFacets;
	}
	public void setCategoryFacets(List<ReadableCategory> categoryFacets) {
		this.categoryFacets = categoryFacets;
	}


}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
