package com.im.framework.sdo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Error Message object instance is supplied ResponseObject incase of error occurred at server side.
 * Attribute: message -- this is used by AppException to indicate internal server error --500 series. 
 * Attribute: errorMassages --List is used to collect all business logic/input errors which arised out user inputs. 400 series.
 * Restufull services from infogps -- will have 400 as status and list of errors for all user input related errors
 * 								   -- will have 500 as status and message as error for all internal server errors									
 *  
 * @author rgannaba
 *
 */
@XmlRootElement
public class ErrorMessage {
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ErrorMessage.class);

	
	
	/** application specific error appErrorCode
	 * This helps to provide for the error appErrorCode
	 *  */
	int appErrorCode; 
		
	/** link documenting the exception */	
	String link;
	
	
	
	List<String> errorMassages ;

	
	
	public int getAppErrorCode() {
		return appErrorCode;
	}

	public void setAppErrorCode(int appErrorCode) {
		this.appErrorCode = appErrorCode;
	}

	

	public List<String> getErrorMassages() {
		return errorMassages;
	}

	public void setErrorMassages(List<String> errorMassages) {
		this.errorMassages = errorMassages;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	

	public ErrorMessage(int errorCode, String link, List<String> errorMassages) {
		this.errorMassages = errorMassages;
		this.appErrorCode = errorCode;
		this.link = link;
		
	}


	public ErrorMessage(int errorCode,  List<String> errorMassages) {
		this.errorMassages = errorMassages;
		this.appErrorCode = errorCode;
		
	}

	
}
