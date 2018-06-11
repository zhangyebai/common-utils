package com.yebai.common.utils.property;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date 2018/4/4 16:11
 ****************************************************/
public class Property {
	private Property(){}
	
	public static final class Resp{
		private Resp(){}
		public static final int SUCCESS_CODE = 200;
		public static final int ERROR_CODE = 500;
	
		public static final String SUCCESS_MESSAGE = "success";
		public static final String ERROR_MESSAGE = "error";
	}
	

	public static final class ExceptionMessage{
		private ExceptionMessage(){}
		
		public static final String ILLEGAL_ARGUMENT_MESSAGE = "parameter is illegal for this request. ";
		public static final String RUNTIME_EXCEPTION_MESSAGE = "unknown runtime exception happens in this request. ";
	}
}
