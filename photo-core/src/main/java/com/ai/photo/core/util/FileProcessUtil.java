package com.ai.photo.core.util;

import com.ai.photo.sdk.model.FileNameNode;
import com.ai.photo.sdk.model.FileTypeEnum;
import com.ai.photo.sdk.model.FileTypeMap;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;

public class FileProcessUtil {
	public  static FileTypeEnum getFileType(File file){
		String ext = FilenameUtils.getExtension(file.getName());
		return FileTypeMap.getFileType(ext);
	}
	public static FileNameNode process(File file){
		FileNameNode nameNode = null;
		FileTypeEnum fileType = getFileType(file);
		switch(fileType){
		case IMAGE : nameNode = processImage(file); break;
		case VIDEO : nameNode = processVideo(file); break;
		case FILE : nameNode = processFile(file); break;
		case UNKOWN : nameNode = processUnknown(file); break;
		}
		return nameNode;
	}
	
	private static FileNameNode processFile(File file){
		FileNameNode nameNode = new FileNameNode();
		
		nameNode.setModifyDate(new Date(file.lastModified()));
		nameNode.setName(file.getName());
		nameNode.setPath(file.getAbsolutePath());
		nameNode.setType(getFileType(file));
		nameNode.setSize(FileUtils.sizeOf(file));
		
		return nameNode;
	}
	
	private static  FileNameNode processImage(File file){
		FileNameNode nameNode =  processFile(file);
		
		return nameNode;
	}
	
	private static  FileNameNode processVideo(File file){
		FileNameNode nameNode =  processFile(file);
		
		return nameNode;
	}
	
	private static  FileNameNode processUnknown(File file){
		FileNameNode nameNode =  processFile(file);
		
		return nameNode;
	}
}
