package com.im.framework.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ValidationException. For all input and business validations..  400 
 * This is something user needs to fix by providing alternate path.
 */
public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2006607111405797654L;

	
	
	/** application specific error appErrorCode
	 * This helps to provide for the error appErrorCode
	 *  */
	int appErrorCode; 
		
	/** link documenting the exception */	
	String link;
	
	
	
	Map<String,Object[]> errorMassages = new HashMap<String,Object[]>();
	
	/**
	 * 
	 * @param status
	 * @param appErrorCode
	 * @param message
	 * @param developerMessage
	 * @param link
	 */
	public ValidationException(int code, 
			 String link, Map<String,Object[]> errors) {
		this.appErrorCode = code;
		this.link = link;
		errorMassages=errors;
	}

	public ValidationException( int code, 
			Map<String,Object[]> errors) {
		this.appErrorCode = code;
		errorMassages=errors;
	}

	

	public int getAppErrorCode() {
		return appErrorCode;
	}

	public void setAppErrorCode(int appErrorCode) {
		this.appErrorCode = appErrorCode;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Map<String, Object[]> getErrorMassages() {
		return errorMassages;
	}

	public void setErrorMassages(Map<String, Object[]> errorMassages) {
		this.errorMassages = errorMassages;
	}

	
	
	
	
}
