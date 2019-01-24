package com.ai.photo.core.everything;

import java.io.File;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;

import com.sun.jna.WString;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class EverythingUtil {
	
//	public static class FileTimeByReference extends FILETIME implements Structure.ByReference { }
	
	public static void search(String keywords) throws Exception{

		long start = System.currentTimeMillis();
		Everything.instanceDll.Everything_SetSearchW(new WString(keywords));
		
		Everything.instanceDll.Everything_SetMatchPath(true);
		Everything.instanceDll.Everything_QueryW(true);
		Everything.instanceDll.Everything_SetRequestFlags(Everything.EVERYTHING_REQUEST_FILE_NAME | Everything.EVERYTHING_REQUEST_SIZE);

		Buffer p = CharBuffer.allocate(500);
		
		for (int i = 0; i < Everything.instanceDll.Everything_GetNumResults(); i++) {
			
			int a = Everything.instanceDll.Everything_GetResultFullPathNameW(i, p, 500);
			char[] buf = (char[]) p.array();
			char[] curBuf = Arrays.copyOfRange(buf, 0, a);
			String name = Everything.instanceDll.Everything_GetResultFileNameW(i).toString();
			System.out.println(name);
			String path = Everything.instanceDll.Everything_GetResultPathW(i).toString();
			String fullPath = new String(curBuf).trim();
			System.out.println(path);
			BasicFileAttributes fileAttr =Files.getFileAttributeView(Paths.get(fullPath), BasicFileAttributeView.class,LinkOption.NOFOLLOW_LINKS).readAttributes();
			System.out.println(fileAttr.creationTime() + " " + fileAttr.lastModifiedTime() + " " + fileAttr.lastAccessTime() + " " + fileAttr.size());
//			System.out.println("是否是普通的文件：" +fileAttr.isRegularFile());
//			//Buffer aa = Everything.instanceDll.Everything_GetResultExtensionW(i);
			boolean isFile = Everything.instanceDll.Everything_IsFileResult(i);
			if(isFile && fileAttr.size()>0){
				try{
					System.out.println("***************************");
					Metadata metadata = ImageMetadataReader.readMetadata(new File(fullPath));
		            Iterator<Directory> it = metadata.getDirectories().iterator();
		            while (it.hasNext()) {
		                Directory exif = it.next();
		                Iterator<Tag> tags = exif.getTags().iterator();
		                while (tags.hasNext()) {
		                    Tag tag = (Tag) tags.next();
		                    System.out.println(tag);
		                }
		            }
		            System.out.println("***************************");
				}catch(ImageProcessingException e){
					System.out.println("文件格式不支持!" + name);
				}
			}
			System.out.println("==========" + new String(curBuf).trim());
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("========搜索条件：" + Everything.instanceDll.Everything_GetSearchW());
		System.out.println("========匹配记录数：" + Everything.instanceDll.Everything_GetNumResults());
		System.out.println("========匹配文件记录数：" + Everything.instanceDll.Everything_GetNumFileResults());
		System.out.println("========匹配文件夹记录数：" + Everything.instanceDll.Everything_GetNumFolderResults());
		System.out.println("========耗时：" + end + "ms");
	}
	
	public static void main(String[] args) throws Exception{
		EverythingUtil.search("E: 刘鹏鹏 201711");
	}
}
