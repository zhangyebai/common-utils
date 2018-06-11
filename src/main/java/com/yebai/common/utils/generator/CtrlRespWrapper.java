package com.yebai.common.utils.generator;


import com.yebai.common.utils.bean.Page;
import com.yebai.common.utils.bean.PageRespEntry;
import com.yebai.common.utils.bean.RespEntry;
import com.yebai.common.utils.property.Property;

import java.util.List;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date 2018/4/4 17:06  
 ****************************************************/
public class CtrlRespWrapper {
	
	private CtrlRespWrapper(){
	
	}
	
	public static <T> RespEntry<T> respGenerator(T data){
		return CtrlRespWrapper.respGenerator(Property.Resp.SUCCESS_CODE, Property.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(int code, T data){
		return CtrlRespWrapper.respGenerator(code, Property.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(String message, T data){
		return CtrlRespWrapper.respGenerator(Property.Resp.SUCCESS_CODE, message, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(int code, T data){
		return CtrlRespWrapper.respGenerator(code, Property.Resp.ERROR_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(String message, T data){
		return CtrlRespWrapper.respGenerator(Property.Resp.ERROR_CODE, message, data);
	}
	
	public static <T> RespEntry <T> errorRespGenerator(T data){
		return CtrlRespWrapper.respGenerator(Property.Resp.ERROR_CODE, Property.Resp.ERROR_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> respGenerator(int code, String message, T data){
		return new RespEntry<>(code, message, data);
	}

	public static <T> PageRespEntry<T> pageRespGenerator(List<T> data){
		return pageRespGenerator(Property.Resp.SUCCESS_CODE, Property.Resp.SUCCESS_MESSAGE, data);
	}

	public static <T> PageRespEntry<T> pageRespGenerator(String message, List<T> data){
		return pageRespGenerator(Property.Resp.SUCCESS_CODE, message, data);
	}

	public static <T> PageRespEntry<T> pageRespGenerator(int code, List<T> data){
		return pageRespGenerator(code, Property.Resp.SUCCESS_MESSAGE, data);
	}

	public static <T> PageRespEntry <T> pageRespGenerator(int code, String message, List<T> data){
		return new PageRespEntry<T>().setCode(code).setMessage(message).setPage(new Page<>(data)).setData(data);
	}

}
