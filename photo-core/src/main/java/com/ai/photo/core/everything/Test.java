package com.ai.photo.core.everything;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.Date;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase.FILETIME;
import com.sun.jna.platform.win32.WinDef.LONGByReference;
import com.sun.jna.platform.win32.WinNT.LARGE_INTEGER;
import com.sun.jna.ptr.PointerByReference;

public class Test {

	public static void main(String[] args) throws Exception {
		Everything.instanceDll.Everything_SetSearchW(new WString("刘鹏鹏"));

		Everything.instanceDll.Everything_SetMatchPath(false);
		Everything.instanceDll.Everything_QueryW(true);
		Everything.instanceDll.Everything_SetRequestFlags(Everything.EVERYTHING_REQUEST_FILE_NAME | Everything.EVERYTHING_REQUEST_PATH | Everything.EVERYTHING_REQUEST_SIZE);
		
//		Everything.instanceDll.Everything_Query(true);

		Buffer p = CharBuffer.allocate(500);
		System.out.println("========搜索条件：" + Everything.instanceDll.Everything_GetSearchW());
		System.out.println("========匹配记录数：" + Everything.instanceDll.Everything_GetNumResults());


		
		for (int i = 0; i < Everything.instanceDll.Everything_GetNumResults(); i++) {
			
			FILETIME filetime = new FILETIME();
//			System.out.println(Everything.instanceDll.Everything_GetResultDateModified(i, filetime));
//			System.out.println(filetime.toDate());
			int a = Everything.instanceDll.Everything_GetResultFullPathNameW(i, p, 500);
			char[] buf = (char[]) p.array();
			char[] curBuf = Arrays.copyOfRange(buf, 0, a);
			System.out.println(Everything.instanceDll.Everything_IsFileResult(i));
			System.out.println(new String(curBuf).trim());
		}
	}
	
	private static Pointer createPointer(long phone) {

		Pointer p = new Memory(32);

		p.setLong(0, phone);


		return p;
		}
}
