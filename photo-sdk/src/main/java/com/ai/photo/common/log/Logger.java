package com.ai.photo.common.log;

public class Logger {
	public static void consoleNL(String msg){
		console(msg,false);
	}
	public static void console(String msg){
		console(msg,true);
	}
	public static void console(String msg,boolean line){
		if(line){
			msg = msg + "\r\n";
		}
		System.out.print(msg);
	}
}
