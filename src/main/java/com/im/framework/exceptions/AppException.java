package com.im.framework.exceptions;


/**
 * The Class AppException.
 * This is to maintain details about server exceptions 500 and not found 404 Status
 */
public class AppException extends Exception {
	private static final long serialVersionUID = -8999932578270387947L;
		
	
	/** application specific error appErrorCode
	 * This helps to provide for the error appErrorCode
	 *  */
	int appErrorCode; 
		
	/** link documenting the exception */	
	String link;
	
	


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


	public AppException(String message, Throwable t) {
		super(message, t);
	}

	public AppException() {
		super();
	}
					
}
