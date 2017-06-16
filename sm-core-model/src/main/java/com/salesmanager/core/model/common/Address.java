<<<<<<< HEAD
package com.salesmanager.core.model.common;

import java.io.Serializable;


public class Address implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String postalCode;
	private String stateProvince;
	private String zone;//code
	private String country;//code

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getZone() {
		return zone;
	}



}
=======
package com.salesmanager.core.model.common;

import java.io.Serializable;


public class Address implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String postalCode;
	private String stateProvince;
	private String zone;//code
	private String country;//code

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getZone() {
		return zone;
	}



}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
