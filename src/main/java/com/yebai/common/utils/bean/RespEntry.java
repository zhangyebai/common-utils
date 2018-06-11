package com.yebai.common.utils.bean;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date create in 12:05 2018/3/30
 *
 ****************************************************/

public class RespEntry<T> {
	
	private int code;
	
	private String message;

	private T data;
	
	public RespEntry(){}
	
	public RespEntry(int code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	
	public RespEntry setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public RespEntry setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public T getData() {
		return data;
	}
	
	public RespEntry setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "RespEntry{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
