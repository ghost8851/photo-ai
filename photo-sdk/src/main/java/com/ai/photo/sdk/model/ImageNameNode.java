package com.ai.photo.sdk.model;

import java.util.Date;

public class ImageNameNode extends FileNameNode{
	public int imageWidth;		//图片宽度
	public int imageHeight;	//图片高度
	public String make;		//拍摄设备
	public String model;		//拍摄设备型号
	public String date;		//拍摄日期
	public Date dateOriginal;
	public Date dateDigitized;
	public String gpsLatitude;	//GPS纬度
	public String gpsLongitude;		//GPS经度
	public Date gpsTimeStamp;		//GPS时间戳
	public Date gpdDateStamp;		//GPS日期戳
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getDateOriginal() {
		return dateOriginal;
	}
	public void setDateOriginal(Date dateOriginal) {
		this.dateOriginal = dateOriginal;
	}
	public Date getDateDigitized() {
		return dateDigitized;
	}
	public void setDateDigitized(Date dateDigitized) {
		this.dateDigitized = dateDigitized;
	}
	public String getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(String gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}
	public String getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(String gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public Date getGpsTimeStamp() {
		return gpsTimeStamp;
	}
	public void setGpsTimeStamp(Date gpsTimeStamp) {
		this.gpsTimeStamp = gpsTimeStamp;
	}
	public Date getGpdDateStamp() {
		return gpdDateStamp;
	}
	public void setGpdDateStamp(Date gpdDateStamp) {
		this.gpdDateStamp = gpdDateStamp;
	}
}
