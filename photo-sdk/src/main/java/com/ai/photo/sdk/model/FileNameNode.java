package com.ai.photo.sdk.model;

import java.util.Date;
import com.ai.photo.common.util.NumberUtil;
import com.ai.photo.common.util.DateUtil;

public class FileNameNode {
	public String name;
	public FileTypeEnum type;
	public Date modifyDate;
	public double size;
	public double KB;
	public double MB;
	public double GB;
	public String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public FileTypeEnum getType() {
		return type;
	}

	public void setType(FileTypeEnum type) {
		this.type = type;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public double getKB() {
		return KB;
	}

	private void setKB(double KB) {
		this.KB = NumberUtil.fmtDouble(KB);
		
	}

	public double getMB() {
		return MB;
	}

	private void setMB(double MB) {
		this.MB = NumberUtil.fmtDouble(MB);
	}

	public double getGB() {
		return GB;
	}

	private void setGB(double GB) {
		this.GB = NumberUtil.fmtDouble(GB);
	}

	public void setSize(double size) {
		this.size = size;
		this.setKB(size/1024);
		this.setMB(size/1024/1024);
		this.setGB(size/1024/1024/1024);
		NumberUtil.fmtDouble(this.size);
	}

	public String toString() {
		String result = "";
		result = "文件名：" + name + " | 类型：" + type
				+ " | 修改日期：" + DateUtil.DATE_FORMAT.format(modifyDate)
				+ " | 文件大小 : " + this.getMB() + " MB"
				+ "\r\n路径：" + path + "<br/>";
		return result;
	}

}
