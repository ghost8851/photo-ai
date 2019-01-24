package com.ai.photo.core.everything;
import java.nio.Buffer;
import java.util.Date;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WTypes.LPWSTR;
import com.sun.jna.platform.win32.WinBase.FILETIME;
import com.sun.jna.platform.win32.WinNT.LARGE_INTEGER;
import com.sun.jna.ptr.PointerByReference;

public interface Everything extends Library {

	Everything instanceDll = (Everything) Native.loadLibrary("Everything64",Everything.class);

	public static final int EVERYTHING_OK = 0;
	public static final int EVERYTHING_ERROR_MEMORY = 1;
	public static final int EVERYTHING_ERROR_IPC = 2;
	public static final int EVERYTHING_ERROR_REGISTERCLASSEX = 3;
	public static final int EVERYTHING_ERROR_CREATEWINDOW = 4;
	public static final int EVERYTHING_ERROR_CREATETHREAD = 5;
	public static final int EVERYTHING_ERROR_INVALIDINDEX = 6;
	public static final int EVERYTHING_ERROR_INVALIDCALL = 7;
	public static final int EVERYTHING_ERROR_INVALIDREQUEST = 8; 
	public static final int EVERYTHING_ERROR_INVALIDPARAMETER = 9; 

	public static final int EVERYTHING_SORT_NAME_ASCENDING = 1;
	public static final int EVERYTHING_SORT_NAME_DESCENDING = 2;
	public static final int EVERYTHING_SORT_PATH_ASCENDING = 3;
	public static final int EVERYTHING_SORT_PATH_DESCENDING = 4;
	public static final int EVERYTHING_SORT_SIZE_ASCENDING = 5;
	public static final int EVERYTHING_SORT_SIZE_DESCENDING = 6;
	public static final int EVERYTHING_SORT_EXTENSION_ASCENDING = 7;
	public static final int EVERYTHING_SORT_EXTENSION_DESCENDING = 8;
	public static final int EVERYTHING_SORT_TYPE_NAME_ASCENDING = 9;
	public static final int EVERYTHING_SORT_TYPE_NAME_DESCENDING = 10;
	public static final int EVERYTHING_SORT_DATE_CREATED_ASCENDING = 11;
	public static final int EVERYTHING_SORT_DATE_CREATED_DESCENDING = 12;
	public static final int EVERYTHING_SORT_DATE_MODIFIED_ASCENDING = 13;
	public static final int EVERYTHING_SORT_DATE_MODIFIED_DESCENDING = 14;
	public static final int EVERYTHING_SORT_ATTRIBUTES_ASCENDING = 15;
	public static final int EVERYTHING_SORT_ATTRIBUTES_DESCENDING = 16;
	public static final int EVERYTHING_SORT_FILE_LIST_FILENAME_ASCENDING = 17;
	public static final int EVERYTHING_SORT_FILE_LIST_FILENAME_DESCENDING = 18;
	public static final int EVERYTHING_SORT_RUN_COUNT_ASCENDING = 19;
	public static final int EVERYTHING_SORT_RUN_COUNT_DESCENDING = 20;
	public static final int EVERYTHING_SORT_DATE_RECENTLY_CHANGED_ASCENDING = 21;
	public static final int EVERYTHING_SORT_DATE_RECENTLY_CHANGED_DESCENDING = 22;
	public static final int EVERYTHING_SORT_DATE_ACCESSED_ASCENDING = 23;
	public static final int EVERYTHING_SORT_DATE_ACCESSED_DESCENDING = 24;
	public static final int EVERYTHING_SORT_DATE_RUN_ASCENDING = 25;
	public static final int EVERYTHING_SORT_DATE_RUN_DESCENDING = 26;

	public static final int EVERYTHING_REQUEST_FILE_NAME = 0x00000001;
	public static final int EVERYTHING_REQUEST_PATH = 0x00000002;
	public static final int EVERYTHING_REQUEST_FULL_PATH_AND_FILE_NAME = 0x00000004;
	public static final int EVERYTHING_REQUEST_EXTENSION = 0x00000008;
	public static final int EVERYTHING_REQUEST_SIZE = 0x00000010;
	public static final int EVERYTHING_REQUEST_DATE_CREATED = 0x00000020;
	public static final int EVERYTHING_REQUEST_DATE_MODIFIED = 0x00000040;
	public static final int EVERYTHING_REQUEST_DATE_ACCESSED = 0x00000080;
	public static final int EVERYTHING_REQUEST_ATTRIBUTES = 0x00000100;
	public static final int EVERYTHING_REQUEST_FILE_LIST_FILE_NAME = 0x00000200;
	public static final int EVERYTHING_REQUEST_RUN_COUNT = 0x00000400;
	public static final int EVERYTHING_REQUEST_DATE_RUN = 0x00000800;
	public static final int EVERYTHING_REQUEST_DATE_RECENTLY_CHANGED = 0x00001000;
	public static final int EVERYTHING_REQUEST_HIGHLIGHTED_FILE_NAME = 0x00002000;
	public static final int EVERYTHING_REQUEST_HIGHLIGHTED_PATH = 0x00004000;
	public static final int EVERYTHING_REQUEST_HIGHLIGHTED_FULL_PATH_AND_FILE_NAME = 0x00008000;

	public static final int EVERYTHING_TARGET_MACHINE_X86 = 1;
	public static final int EVERYTHING_TARGET_MACHINE_X64 = 2;
	public static final int EVERYTHING_TARGET_MACHINE_ARM = 3;

	public int Everything_SetSearchW(WString lpSearchString);

	public int Everything_SetSearchA(WString lpSearchString);

	public void Everything_SetMatchPath(boolean bEnable);

	public void Everything_SetMatchCase(boolean bEnable);

	public void Everything_SetMatchWholeWord(boolean bEnable);

	public void Everything_SetRegex(boolean bEnable);

	public void Everything_SetMax(int dwMax);

	public void Everything_SetOffset(int dwOffset);
	
	public void Everything_SetRequestFlags(int dwRequestFlags);

	public boolean Everything_GetMatchPath();

	public boolean Everything_GetMatchCase();

	public boolean Everything_GetMatchWholeWord();

	public boolean Everything_GetRegex();

	public int Everything_GetMax();

	public int Everything_GetOffset();

	public WString Everything_GetSearchW();

	public WString Everything_GetSearchA();

	public int Everything_GetLastError();

	public boolean Everything_QueryW(boolean bWait);

	public boolean Everything_QueryA(boolean bWait);

	public boolean Everything_Query(boolean bWait);

	public void Everything_SortResultsByPath();

	public int Everything_GetNumFileResults();

	public int Everything_GetNumFolderResults();

	public int Everything_GetNumResults();

	public int Everything_GetTotFileResults();

	public int Everything_GetTotFolderResults();

	public int Everything_GetTotResults();

	public boolean Everything_IsVolumeResult(int nIndex);

	public boolean Everything_IsFolderResult(int nIndex);

	public boolean Everything_IsFileResult(int nIndex);

	//获取文件全路径
	public int Everything_GetResultFullPathNameW(int nIndex, Buffer lpString, int nMaxCount);

	
	public WString Everything_GetResultExtensionW(int dwIndex); 
	
	//获取文件名
	public WString Everything_GetResultFileNameW(int dwIndex);
	//获取文件路径
	public WString Everything_GetResultPathW(int index);
	
	public WString Everything_GetResultHighlightedPathW(int index);
	
	public boolean  Everything_GetResultSize(int dwIndex,LARGE_INTEGER.LowHigh  size);
	
	public int Everything_GetResultListSort();

	public void Everything_Reset();

}
