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
public class CtrlResp {
	
	private CtrlResp(){
	
	}
	
	public static <T> RespEntry<T> ok(T data){
		return ok(Property.Resp.SUCCESS_CODE, Property.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> ok(int code, T data){
		return ok(code, Property.Resp.SUCCESS_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> ok(String message, T data){
		return ok(Property.Resp.SUCCESS_CODE, message, data);
	}
	
	public static <T> RespEntry <T> err(int code, T data){
		return ok(code, Property.Resp.ERROR_MESSAGE, data);
	}
	
	public static <T> RespEntry <T> err(String message, T data){
		return ok(Property.Resp.ERROR_CODE, message, data);
	}
	
	public static <T> RespEntry <T> err(String message){
		return ok(Property.Resp.ERROR_CODE, message, null);
	}
	
	public static <T> RespEntry <T> ok(int code, String message, T data){
		return new RespEntry<>(code, message, data);
	}

	public static <T> PageRespEntry<T> okay(List<T> data){
		return okay(Property.Resp.SUCCESS_CODE, Property.Resp.SUCCESS_MESSAGE, data);
	}

	public static <T> PageRespEntry<T> okay(String message, List<T> data){
		return okay(Property.Resp.SUCCESS_CODE, message, data);
	}

	public static <T> PageRespEntry<T> okay(int code, List<T> data){
		return okay(code, Property.Resp.SUCCESS_MESSAGE, data);
	}

	public static <T> PageRespEntry <T> okay(int code, String message, List<T> data){
		return new PageRespEntry<T>().setCode(code).setMessage(message).setPage(new Page<>(data)).setData(data);
	}

}
