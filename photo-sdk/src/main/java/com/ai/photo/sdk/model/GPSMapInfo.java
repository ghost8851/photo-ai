package com.ai.photo.sdk.model;

import java.util.List;

public class GPSMapInfo {
	private List<GPSMapAddrInfo> addrList;
	private double[] queryLocation;

	public List<GPSMapAddrInfo> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<GPSMapAddrInfo> addrList) {
		this.addrList = addrList;
	}

	public double[] getQueryLocation() {
		return queryLocation;
	}

	public void setQueryLocation(double[] queryLocation) {
		this.queryLocation = queryLocation;
	}

}
