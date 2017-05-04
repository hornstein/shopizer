<<<<<<< HEAD
package com.salesmanager.shop.model.order;

import java.io.Serializable;

import com.salesmanager.shop.model.catalog.product.ReadableProduct;

public class OrderProductEntity extends OrderProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderedQuantity;
	private ReadableProduct product;


	
	
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public ReadableProduct getProduct() {
		return product;
	}
	public void setProduct(ReadableProduct product) {
		this.product = product;
	}




}
=======
package com.salesmanager.shop.model.order;

import java.io.Serializable;

import com.salesmanager.shop.model.catalog.product.ReadableProduct;

public class OrderProductEntity extends OrderProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderedQuantity;
	private ReadableProduct product;


	
	
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public ReadableProduct getProduct() {
		return product;
	}
	public void setProduct(ReadableProduct product) {
		this.product = product;
	}




}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
