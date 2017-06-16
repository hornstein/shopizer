<<<<<<< HEAD
package com.salesmanager.shop.model.catalog.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersistableCategory extends CategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CategoryDescription> descriptions;//always persist description
	private List<PersistableCategory> children = new ArrayList<PersistableCategory>();
	
	public List<CategoryDescription> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<CategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}
	public List<PersistableCategory> getChildren() {
		return children;
	}
	public void setChildren(List<PersistableCategory> children) {
		this.children = children;
	}

}
=======
package com.salesmanager.shop.model.catalog.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersistableCategory extends CategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CategoryDescription> descriptions;//always persist description
	private List<PersistableCategory> children = new ArrayList<PersistableCategory>();
	
	public List<CategoryDescription> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<CategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}
	public List<PersistableCategory> getChildren() {
		return children;
	}
	public void setChildren(List<PersistableCategory> children) {
		this.children = children;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
