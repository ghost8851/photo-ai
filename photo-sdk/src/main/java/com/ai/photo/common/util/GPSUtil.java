package com.ai.photo.common.util;

import java.net.URL;
import com.google.gson.Gson;
import com.ai.photo.sdk.model.GPSMapAddrInfo;
import com.ai.photo.sdk.model.GPSMapInfo;
import java.util.Iterator;

public class GPSUtil {
	public static GPSMapInfo getAddOnLine(String log, String lat ){  
		GPSMapInfo mapInfo = null;
        //lat 小  log  大  
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)  
		if(log!=null && log.indexOf("°")>=0){
			log = String.valueOf(GPSUtil.getCoordinate(log));
		}
		if(lat!=null && lat.indexOf("°")>=0){
			lat = String.valueOf(GPSUtil.getCoordinate(lat));
		}
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";  
        String res = "";     
        try {     
            URL url = new URL(urlString);    
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
            conn.setDoOutput(true);    
            conn.setRequestMethod("POST");    
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
            String line;    
           while ((line = in.readLine()) != null) {    
               res += line+"\n";    
         }    
            in.close();    
        } catch (Exception e) {    
        }   
        Gson gson = new Gson();
        mapInfo = gson.fromJson(res, GPSMapInfo.class);
        if(mapInfo!=null && mapInfo.getAddrList()!=null){
        	Iterator<GPSMapAddrInfo> it = mapInfo.getAddrList().iterator();
        	while(it.hasNext()){
        		GPSMapAddrInfo aGPSMapAddrInfo = it.next();
        		aGPSMapAddrInfo.process();
        	}
        }
        return mapInfo;    
    }  
	
	//Decimal Degrees = Degrees + minutes/60 + seconds/3600
		//	例：57°55'56.6" =57+55/60+56.6/3600=57.9323888888888
			//114°65'24.6"=114+65/60+24.6/3600=结果自己算!
	//Degrees,minutes,seconds)
	public static double getCoordinate(String str){
		double coor = 0;
		if(str != null){
			String degrees = str.substring(0, str.lastIndexOf("°"));
			String minutes = str.substring(str.lastIndexOf("°")+1,str.lastIndexOf("'"));
			String seconds = str.substring(str.lastIndexOf("'")+1,str.lastIndexOf("\""));
			coor = Double.parseDouble(degrees) + Double.parseDouble(minutes)/60 + Double.parseDouble(seconds) /3600;
		}
		return coor;
	}

}
