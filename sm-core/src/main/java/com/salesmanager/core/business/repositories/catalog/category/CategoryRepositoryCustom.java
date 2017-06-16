<<<<<<< HEAD
package com.salesmanager.core.business.repositories.catalog.category;

import java.util.List;

import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.merchant.MerchantStore;

public interface CategoryRepositoryCustom {

	List<Object[]> countProductsByCategories(MerchantStore store,
			List<Long> categoryIds);

	List<Category> listByStoreAndParent(MerchantStore store, Category category);

}
=======
package com.salesmanager.core.business.repositories.catalog.category;

import java.util.List;

import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.merchant.MerchantStore;

public interface CategoryRepositoryCustom {

	List<Object[]> countProductsByCategories(MerchantStore store,
			List<Long> categoryIds);

	List<Category> listByStoreAndParent(MerchantStore store, Category category);

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
