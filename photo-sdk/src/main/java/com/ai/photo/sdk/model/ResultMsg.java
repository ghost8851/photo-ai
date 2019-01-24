package com.ai.photo.sdk.model;
import java.util.LinkedHashMap;
import com.alibaba.fastjson.JSONObject;

/**
 * @date 2017
 * @author zhao
 **/
@SuppressWarnings("unused")
public class ResultMsg extends LinkedHashMap<String, Object> {

	
	private static final long serialVersionUID = -6210037569786898103L;
	
	/*成功标志*/
	private boolean success = false;
	/*错误编码*/
	private String errorCode;
	/*返回消息*/
	private String message;
	/* 数据*/
	private Object data;
	
	

	/**
	 * 不带成功消息的成功返回
	 * @param data
	 */
	public void setSuccess(Object data) {
		this.put("success", true);
		this.put("data", data);	
	}
	
	/**
	 * 带成功消息的成功返回
	 * @param data
	 */
	public void setSuccess(String msg,Object data) {
		this.put("success", true);
		this.put("message", msg);
		this.put("data", data);	
	}
	
	public void setSuccess(){
		this.put("success", true);
	}
	
	/**
	 * 不带错误编码的错误返回
	 * @param data
	 */
	public void setFail(String msg) {
		this.put("success", false);
		this.put("error", new error("100",msg));
	}
	
	/**
	 * 带错误编码的错误返回
	 * @param data
	 */
	public void setFail(String errorCode,String msg) {
		this.put("success", false);
		this.put("error", new error(errorCode,msg));
	}
	
	

	@Override
	public String toString() {
				JSONObject jsonObject = new JSONObject();
		if(this.success){
			jsonObject.remove("errorCode");
		}else{
			jsonObject.remove("data");
		}
		
		return jsonObject.toString();
	}
	
	private class error
	{
		String errorCode;
		String errorMessage;
		
		error(String errorCode,String errorMessage){
			
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
	}

}
