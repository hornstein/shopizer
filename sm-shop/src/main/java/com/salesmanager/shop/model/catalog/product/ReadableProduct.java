<<<<<<< HEAD
package com.salesmanager.shop.model.catalog.product;

import java.io.Serializable;
import java.util.List;

import com.salesmanager.shop.model.catalog.ReadableImage;
import com.salesmanager.shop.model.catalog.manufacturer.ReadableManufacturer;
import com.salesmanager.shop.model.catalog.product.attribute.ReadableProductAttribute;


public class ReadableProduct extends ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDescription description;
	private String finalPrice = "0";
	private String originalPrice = null;
	private boolean discounted = false;
	private ReadableImage image;
	private List<ReadableImage> images;
	private ReadableManufacturer manufacturer;
	private List<ReadableProductAttribute> attributes;
	private boolean canBePurchased = false;
	
		
	public ProductDescription getDescription() {
		return description;
	}
	public void setDescription(ProductDescription description) {
		this.description = description;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public boolean isDiscounted() {
		return discounted;
	}
	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public void setImages(List<ReadableImage> images) {
		this.images = images;
	}
	public List<ReadableImage> getImages() {
		return images;
	}
	public void setImage(ReadableImage image) {
		this.image = image;
	}
	public ReadableImage getImage() {
		return image;
	}
	public void setAttributes(List<ReadableProductAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<ReadableProductAttribute> getAttributes() {
		return attributes;
	}
	public void setManufacturer(ReadableManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public ReadableManufacturer getManufacturer() {
		return manufacturer;
	}
	public boolean isCanBePurchased() {
		return canBePurchased;
	}
	public void setCanBePurchased(boolean canBePurchased) {
		this.canBePurchased = canBePurchased;
	}

}
=======
package com.salesmanager.shop.model.catalog.product;

import java.io.Serializable;
import java.util.List;

import com.salesmanager.shop.model.catalog.ReadableImage;
import com.salesmanager.shop.model.catalog.manufacturer.ReadableManufacturer;
import com.salesmanager.shop.model.catalog.product.attribute.ReadableProductAttribute;


public class ReadableProduct extends ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDescription description;
	private String finalPrice = "0";
	private String originalPrice = null;
	private boolean discounted = false;
	private ReadableImage image;
	private List<ReadableImage> images;
	private ReadableManufacturer manufacturer;
	private List<ReadableProductAttribute> attributes;
	private boolean canBePurchased = false;
	
		
	public ProductDescription getDescription() {
		return description;
	}
	public void setDescription(ProductDescription description) {
		this.description = description;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public boolean isDiscounted() {
		return discounted;
	}
	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public void setImages(List<ReadableImage> images) {
		this.images = images;
	}
	public List<ReadableImage> getImages() {
		return images;
	}
	public void setImage(ReadableImage image) {
		this.image = image;
	}
	public ReadableImage getImage() {
		return image;
	}
	public void setAttributes(List<ReadableProductAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<ReadableProductAttribute> getAttributes() {
		return attributes;
	}
	public void setManufacturer(ReadableManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public ReadableManufacturer getManufacturer() {
		return manufacturer;
	}
	public boolean isCanBePurchased() {
		return canBePurchased;
	}
	public void setCanBePurchased(boolean canBePurchased) {
		this.canBePurchased = canBePurchased;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
