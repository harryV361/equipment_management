package com.infrastructure.exception;

/**
 * 权限异常类
 *
 */
public class PermissionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6008004025445496953L;

	public PermissionException(String msg)  
    {  
        super(msg);  
    }
	
}
