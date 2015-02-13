package com.infrastructure.exception;

/**
 * 实体操作异常类
 *
 */
public class EntityOperateException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1762283867533955865L;

	public EntityOperateException(String msg)  
    {  
        super(msg);  
    }
	
}
