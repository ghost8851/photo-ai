package com.ai.photo.core.thread;

import com.ai.photo.core.thread.ReadFileThread;

public class ReadFileThreadTest {
	public static void main(String[] args){
		String path = "E:\\��Ƭ\\�ֻ���Ƭ����2017-03-31\\������\\�����\\��ɴ��";
		ReadFileThread readThread = ReadFileThread.getInstance(path);
		readThread.run();
	}
}
