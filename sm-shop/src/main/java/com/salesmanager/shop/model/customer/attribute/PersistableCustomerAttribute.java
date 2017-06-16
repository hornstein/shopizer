<<<<<<< HEAD
package com.salesmanager.shop.model.customer.attribute;

public class PersistableCustomerAttribute extends CustomerAttributeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerOption customerOption;
	private CustomerOptionValue customerOptionValue;
	public void setCustomerOptionValue(CustomerOptionValue customerOptionValue) {
		this.customerOptionValue = customerOptionValue;
	}
	public CustomerOptionValue getCustomerOptionValue() {
		return customerOptionValue;
	}
	public void setCustomerOption(CustomerOption customerOption) {
		this.customerOption = customerOption;
	}
	public CustomerOption getCustomerOption() {
		return customerOption;
	}


}
=======
package com.salesmanager.shop.model.customer.attribute;

public class PersistableCustomerAttribute extends CustomerAttributeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerOption customerOption;
	private CustomerOptionValue customerOptionValue;
	public void setCustomerOptionValue(CustomerOptionValue customerOptionValue) {
		this.customerOptionValue = customerOptionValue;
	}
	public CustomerOptionValue getCustomerOptionValue() {
		return customerOptionValue;
	}
	public void setCustomerOption(CustomerOption customerOption) {
		this.customerOption = customerOption;
	}
	public CustomerOption getCustomerOption() {
		return customerOption;
	}


}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
