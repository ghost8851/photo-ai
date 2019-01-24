package com.ai.photo.core.thread;

import com.ai.photo.core.thread.ReadFileThread;

public class ReadFileThreadTest {
	public static void main(String[] args){
		String path = "E:\\相片\\手机照片备份2017-03-31\\刘鹏鹏\\结婚照\\婚纱照";
		ReadFileThread readThread = ReadFileThread.getInstance(path);
		readThread.run();
	}
}
