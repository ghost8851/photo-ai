package com.ai.photo.core.thread;

import java.lang.Runnable;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;
import com.ai.photo.common.log.Logger;
import com.ai.photo.common.util.DateUtil;
import com.ai.photo.core.util.FileProcessUtil;
import com.ai.photo.sdk.model.FileNameNode;

public class ReadFileThread implements Runnable {

	private String path;
	private long timeCost;
	private static ReadFileThread ins = null;

	private ReadFileThread(String path) {
		setPath(path);
	}
	
	public long getTimeCost() {
		return timeCost;
	}

	public synchronized  static ReadFileThread getInstance(String path){
		if(ins == null){
			return new ReadFileThread(path);
		}else{
			return ins;
		}
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public synchronized void run() {
		Logger.console("日期: "+DateUtil.getCurTime()+" ",false);
		Logger.console("读取文件路径: "+path);
		long start = System.currentTimeMillis();
		File root = new File(path);
		String[] extArr = null;
		List<File> allFile = (List<File>)FileUtils.listFiles(root, extArr, true);
		List<FileNameNode> nameNodeList = processResult(allFile);
		System.out.println(nameNodeList.toString());
		long end = System.currentTimeMillis();
		timeCost = end - start;
		Logger.console("本次读取耗时: " + timeCost/1000 +" 秒!");
		Logger.console("日期: "+DateUtil.getCurTime()+" 读取文件结束!");
	}
	
	public List<FileNameNode> processResult(List<File> fileList){
		List<FileNameNode> list = new ArrayList<FileNameNode>(0);
		if(fileList != null && fileList.size()>0){
			list = new ArrayList<FileNameNode>(fileList.size());
			for(File file : fileList){
				FileNameNode nameNode = FileProcessUtil.process(file);
				if(nameNode != null){
					list.add(nameNode);
				}
				//FilenameUtils.getExtension(file)
			}
		}
		return list;
	}
}
