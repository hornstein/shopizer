<<<<<<< HEAD
package com.shopizer.search.services;

import java.util.Map;


public class GetResponse {
	
	
	//private org.elasticsearch.action.get.GetResponse response;
	
	//public GetResponse(org.elasticsearch.action.get.GetResponse r) {
	//	response = r;
	//}
	
	public GetResponse(Map<String, Object> source) {
		this.objectMap = source;
	}
	
	private Map<String, Object> objectMap;
	private String objectJson;
	
	//private JestResult result;
	
	//public String getResponseAsString() {
	//	return response.toString();//TODO
	//}
	
	//public Map<String,Object> getFields()
	//{
	//	return response.getSource();
	//}
	
	//public List<Object> getField(String key) {
		//TODO
		//return null;
	//}
	
	//public Map<String,Object> getFields()
	//{
		//TODO
		//return null;
	//}
	
	
	//public List<Object> getField(String key) {
	//	GetField f = response.getFields().get(key);
	//	if(f!=null) {
	//		return f.getValues();
	//	}
	//	return null;
	//}

	public Map<String, Object> getFieldMap() {
		return objectMap;
	}


	public String getObjectJson() {
		return objectJson;
	}

	public void setObjectJson(String objectJson) {
		this.objectJson = objectJson;
	}

}
=======
package com.shopizer.search.services;

import java.util.Map;


public class GetResponse {
	
	
	//private org.elasticsearch.action.get.GetResponse response;
	
	//public GetResponse(org.elasticsearch.action.get.GetResponse r) {
	//	response = r;
	//}
	
	public GetResponse(Map<String, Object> source) {
		this.objectMap = source;
	}
	
	private Map<String, Object> objectMap;
	private String objectJson;
	
	//private JestResult result;
	
	//public String getResponseAsString() {
	//	return response.toString();//TODO
	//}
	
	//public Map<String,Object> getFields()
	//{
	//	return response.getSource();
	//}
	
	//public List<Object> getField(String key) {
		//TODO
		//return null;
	//}
	
	//public Map<String,Object> getFields()
	//{
		//TODO
		//return null;
	//}
	
	
	//public List<Object> getField(String key) {
	//	GetField f = response.getFields().get(key);
	//	if(f!=null) {
	//		return f.getValues();
	//	}
	//	return null;
	//}

	public Map<String, Object> getFieldMap() {
		return objectMap;
	}


	public String getObjectJson() {
		return objectJson;
	}

	public void setObjectJson(String objectJson) {
		this.objectJson = objectJson;
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
