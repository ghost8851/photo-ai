package com.ai.photo.core.everything;

import java.util.Date;

class FileTime {    
    /**
     * Unix 时间 1970-01-01 00:00:00 与 Win32 FileTime 时间 1601-01-01 00:00:00
     * 毫秒数差 
     */
    public final static long UNIX_FILETIME_DIFF = 11644473600000L;    
    /**
     * Win32 FileTime 采用 100ns 为单位的，定义 100ns 与 1ms 的倍率
     */
    public final static int MILLISECOND_MULTIPLE = 10000;    
    private long low;
    private long high;    
 
    public FileTime() {        
    }
    
    public FileTime(long low, long high) {
        this.low = low;
        this.high = high;
    }
    
    /**
     * 将 Win32 的 FileTime 结构转为 Java 中的 Date 类型
     * @param fileTime
     * @return
     */
    public static Date fileTime2Date(FileTime fileTime) {
        return new Date(fileTime.getFileTime() 
                        / FileTime.MILLISECOND_MULTIPLE 
                        - FileTime.UNIX_FILETIME_DIFF);
    }
    
    /**
     * 将 Java 中的 Date 类型转为 Win32 的 FileTime 结构
     * @param date
     * @return
     */
    public static FileTime date2FileTime(Date date) {
        long time = (FileTime.UNIX_FILETIME_DIFF 
                     + date.getTime()) * FileTime.MILLISECOND_MULTIPLE;
        FileTime fileTime = new FileTime();
        fileTime.setHigh((int)(time >> 32) &0xffffffff);
        fileTime.setLow((int)time&0xffffffff);
        return fileTime;
    }
 
    public long getLow() {
        return low;
    }
    public void setLow(long low) {
        this.low = low;
    }
    public long getHigh() {
        return high;
    }
    public void setHigh(long high) {
        this.high = high;
    }
    
    /**
     * 获得 FileTime 以 64 位数字表示的数据
     * @return
     */
    public long getFileTime() {
        return ((long)high >> 32 & 0xffffffff) | ((long)low & 0xffffffff);
    }
    
    public String toString() {
        return  "high:" + high + "low:" + low;
    }
}