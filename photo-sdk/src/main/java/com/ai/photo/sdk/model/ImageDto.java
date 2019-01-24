package com.ai.photo.sdk.model;

public class ImageDto implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8907996455274847430L;
	
	private String id;
	private String name;
	private String path;
	private String size;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
