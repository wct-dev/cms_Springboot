package com.briup.utils;
/**
 * 自定义异常类
 * @author Elvira
 *
 */
public class CustomerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException() {
	}

	public CustomerException(String message, Throwable cause, boolean enableSupperssion, boolean writableStackTrace) {
		super(message, cause, enableSupperssion, writableStackTrace);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}
	
}
