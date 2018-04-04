package com.yebai.common.utils.bean;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date create in 12:05 2018/3/30
 *
 ****************************************************/

public class RespEntry<T> {
	
	private Integer code;
	
	private String message;
	
	private T data;
	
	public RespEntry(){}
	
	public RespEntry(Integer code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public RespEntry setCode(Integer code) {
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
}
