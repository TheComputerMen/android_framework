package com.jd.framework.exception;

/**
 * �Զ����쳣
 * 
 * ϵͳ�������쳣��ת��ΪExceptions
 * 
 * @author User
 *
 */
public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BaseException(){
		super();
	}
	
	public BaseException(String detailMessage,Throwable throwable){
		super(detailMessage, throwable);
	}
	
	public BaseException(String detailMessage){
		super(detailMessage);
	}
	
	public BaseException(Throwable throwable){
		super(throwable);
	}

}
