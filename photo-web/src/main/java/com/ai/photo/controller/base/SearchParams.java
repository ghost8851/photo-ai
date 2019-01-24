package com.ai.photo.controller.base;

import java.util.HashMap;
import java.util.Map;

public class SearchParams implements java.io.Serializable{

	private static final long serialVersionUID = -4537848598091997216L;
	private Map<String, Object> searchMap = new HashMap<String, Object>();

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }

    public void addCondition(String key, Object value) {
        this.searchMap.put(key, value);
    }

    public Object removeCondition(String key) {
        return this.searchMap.remove(key);
    }
}