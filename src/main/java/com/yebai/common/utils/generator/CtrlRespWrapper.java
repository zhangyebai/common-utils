package com.yebai.common.utils.generator;


import com.yebai.common.utils.bean.RespEntry;
import com.yebai.common.utils.config.Config;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date 2018/4/4 17:06  
 ****************************************************/
public class CtrlRespWrapper {
	
	private CtrlRespWrapper(){
	
	}
	
	public static <T> RespEntry<T> respGenerator(T data){
		return CtrlRespWrapper.respGenerator(Config.Resp.SUCCESS_CODE, Config.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(Integer code, T data){
		return CtrlRespWrapper.respGenerator(code, Config.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(String message, T data){
		return CtrlRespWrapper.respGenerator(Config.Resp.SUCCESS_CODE, message, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(Integer code, T data){
		return CtrlRespWrapper.respGenerator(code, Config.Resp.ERROR_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(String message, T data){
		return CtrlRespWrapper.respGenerator(Config.Resp.ERROR_CODE, message, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(T data){
		return CtrlRespWrapper.respGenerator(Config.Resp.ERROR_CODE, Config.Resp.ERROR_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(Integer code, String message, T data){
		return new RespEntry<>(code, message, data);
	}
}
