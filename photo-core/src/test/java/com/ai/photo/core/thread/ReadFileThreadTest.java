package com.ai.photo.core.thread;

import com.ai.photo.core.thread.ReadFileThread;

public class ReadFileThreadTest {
	public static void main(String[] args){
		String path = "E:\\œ‡∆¨\\ ÷ª˙’’∆¨±∏∑›2017-03-31\\¡ı≈Ù≈Ù\\Ω·ªÈ’’\\ªÈ…¥’’";
		ReadFileThread readThread = ReadFileThread.getInstance(path);
		readThread.run();
	}
}
