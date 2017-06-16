<<<<<<< HEAD
package com.salesmanager.shop.model.catalog.product.attribute;

import java.io.Serializable;
import java.util.List;

public class PersistableProductOptionValue extends ProductOptionValueEntity
		implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductOptionValueDescription> descriptions;

	public void setDescriptions(List<ProductOptionValueDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public List<ProductOptionValueDescription> getDescriptions() {
		return descriptions;
	}

}
=======
package com.salesmanager.shop.model.catalog.product.attribute;

import java.io.Serializable;
import java.util.List;

public class PersistableProductOptionValue extends ProductOptionValueEntity
		implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductOptionValueDescription> descriptions;

	public void setDescriptions(List<ProductOptionValueDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public List<ProductOptionValueDescription> getDescriptions() {
		return descriptions;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
