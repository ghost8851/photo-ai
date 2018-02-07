package com.ai.photo.sdk.model;

public class GPSMapAddrInfo {
	private String type;
	private int status;
	private String name;
	private String id;
	private String admCode;
	private String admName;
	private String addr;
	private double distance;
	private double[] nearestPoint;
	private String province;
	private String city;
	private String county;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmCode() {
		return admCode;
	}

	public void setAdmCode(String admCode) {
		this.admCode = admCode;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double[] getNearestPoint() {
		return nearestPoint;
	}

	public void setNearestPoint(double[] nearestPoint) {
		this.nearestPoint = nearestPoint;
	}
	public void process(){
		if (admName != null) {
			String[] tempArr = admName.split(",");
			if (tempArr.length > 0) this.setProvince(tempArr[0]);
			if (tempArr.length > 1) this.setCity(tempArr[1]);
			if (tempArr.length > 2) this.setCounty(tempArr[2]);
		}
	}
}
