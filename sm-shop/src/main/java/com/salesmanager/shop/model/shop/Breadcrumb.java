<<<<<<< HEAD
package com.salesmanager.shop.model.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.salesmanager.core.model.reference.language.Language;


public class Breadcrumb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BreadcrumbItemType itemType;
	private Language language;
	private String urlRefContent = null;
	private List<BreadcrumbItem> breadCrumbs = new ArrayList<BreadcrumbItem>();
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public List<BreadcrumbItem> getBreadCrumbs() {
		return breadCrumbs;
	}
	public void setBreadCrumbs(List<BreadcrumbItem> breadCrumbs) {
		this.breadCrumbs = breadCrumbs;
	}
	public void setItemType(BreadcrumbItemType itemType) {
		this.itemType = itemType;
	}
	public BreadcrumbItemType getItemType() {
		return itemType;
	}
	public String getUrlRefContent() {
		return urlRefContent;
	}
	public void setUrlRefContent(String urlRefContent) {
		this.urlRefContent = urlRefContent;
	}

}
=======
package com.salesmanager.shop.model.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.salesmanager.core.model.reference.language.Language;


public class Breadcrumb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BreadcrumbItemType itemType;
	private Language language;
	private String urlRefContent = null;
	private List<BreadcrumbItem> breadCrumbs = new ArrayList<BreadcrumbItem>();
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public List<BreadcrumbItem> getBreadCrumbs() {
		return breadCrumbs;
	}
	public void setBreadCrumbs(List<BreadcrumbItem> breadCrumbs) {
		this.breadCrumbs = breadCrumbs;
	}
	public void setItemType(BreadcrumbItemType itemType) {
		this.itemType = itemType;
	}
	public BreadcrumbItemType getItemType() {
		return itemType;
	}
	public String getUrlRefContent() {
		return urlRefContent;
	}
	public void setUrlRefContent(String urlRefContent) {
		this.urlRefContent = urlRefContent;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
