<<<<<<< HEAD
package com.salesmanager.shop.model.customer;

import java.io.Serializable;
import java.util.List;

import com.salesmanager.shop.model.customer.attribute.PersistableCustomerAttribute;



public class PersistableCustomer extends CustomerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PersistableCustomerAttribute> attributes;
	public void setAttributes(List<PersistableCustomerAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<PersistableCustomerAttribute> getAttributes() {
		return attributes;
	}
	

}
=======
package com.salesmanager.shop.model.customer;

import java.io.Serializable;
import java.util.List;

import com.salesmanager.shop.model.customer.attribute.PersistableCustomerAttribute;



public class PersistableCustomer extends CustomerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PersistableCustomerAttribute> attributes;
	public void setAttributes(List<PersistableCustomerAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<PersistableCustomerAttribute> getAttributes() {
		return attributes;
	}
	

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
