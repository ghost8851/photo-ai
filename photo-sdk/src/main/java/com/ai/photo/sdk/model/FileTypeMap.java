package com.ai.photo.sdk.model;

import java.util.HashMap;
import java.util.Map;

public class FileTypeMap {
	private static Map<FileSuffixEnum,FileTypeEnum> extMap = new HashMap<FileSuffixEnum,FileTypeEnum>();
	private static FileTypeMap instance = null;
	private FileTypeMap(){
			extMap.put(FileSuffixEnum.AVI, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.BMP, FileTypeEnum.IMAGE);
			extMap.put(FileSuffixEnum.FLV, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.GIF, FileTypeEnum.IMAGE);
			extMap.put(FileSuffixEnum.JPEG, FileTypeEnum.IMAGE);
			
			extMap.put(FileSuffixEnum.JPG, FileTypeEnum.IMAGE);
			extMap.put(FileSuffixEnum.MKV, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.MOV, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.MP4, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.PNG, FileTypeEnum.IMAGE);
			
			extMap.put(FileSuffixEnum.RMVB, FileTypeEnum.VIDEO);
			extMap.put(FileSuffixEnum.WMV, FileTypeEnum.IMAGE);
	}
	private static synchronized FileTypeMap getInstance(){
		if(instance == null){
			instance = new FileTypeMap();
		}
		return instance;
	}
	public static FileTypeEnum getFileType(String suffix) {
		getInstance();
		if(suffix != null){
			FileSuffixEnum suffixEnum = FileSuffixEnum.valueOf(suffix.toUpperCase());
			if( suffixEnum == null){
				return FileTypeEnum.UNKOWN;
			}
			FileTypeEnum type = extMap.get(suffixEnum);
			if(type == null){
				type = FileTypeEnum.UNKOWN;
			}
			return type;
		}else{
			return FileTypeEnum.UNKOWN;
		}
	}
	
}

