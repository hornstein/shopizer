<<<<<<< HEAD
package com.salesmanager.core.model.shipping;

import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.price.FinalPrice;

public class ShippingProduct {
	
	public ShippingProduct(Product product) {
		this.product = product;

	}
	
	private int quantity = 1;
	private Product product;
	
	private FinalPrice finalPrice;
	
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public FinalPrice getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(FinalPrice finalPrice) {
		this.finalPrice = finalPrice;
	}

}
=======
package com.salesmanager.core.model.shipping;

import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.price.FinalPrice;

public class ShippingProduct {
	
	public ShippingProduct(Product product) {
		this.product = product;

	}
	
	private int quantity = 1;
	private Product product;
	
	private FinalPrice finalPrice;
	
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public FinalPrice getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(FinalPrice finalPrice) {
		this.finalPrice = finalPrice;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
