package com.ai.photo.sdk.model;

import java.util.Date;

public class ImageNameNode extends FileNameNode{
	public int imageWidth;		//ͼƬ���
	public int imageHeight;	//ͼƬ�߶�
	public String make;		//�����豸
	public String model;		//�����豸�ͺ�
	public String date;		//��������
	public Date dateOriginal;
	public Date dateDigitized;
	public String gpsLatitude;	//GPSγ��
	public String gpsLongitude;		//GPS����
	public Date gpsTimeStamp;		//GPSʱ���
	public Date gpdDateStamp;		//GPS���ڴ�
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
