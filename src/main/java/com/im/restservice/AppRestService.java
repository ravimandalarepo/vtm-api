package com.im.restservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import com.im.framework.exceptions.ValidationException;
import com.im.framework.sdo.ErrorMessage;
import com.im.framework.sdo.ResponseObject;

// TODO: Auto-generated Javadoc
/**
 * The Class AppRestService.
 */
public abstract class AppRestService {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AppRestService.class);

	/** The message source. */
	@Resource(name="messageSource")
	private MessageSource messageSource;
	
	/**
	 * Instantiates a new app rest service.
	 */
	public AppRestService() {
		super();
	}
	
	/**
	 * Builds the success response.
	 *
	 * @param object the object
	 * @param message the message
	 * @param messageParam the message param
	 * @param respNumber TODO
	 * @param clientSession the client session
	 * @return the response object
	 */
	protected Response buildSuccessResponse(Object object, String message, String messageParam, int respNumber) {
		/*ResponseObject responseObject = new ResponseObject();
		responseObject.setResult(object);
		// read from bundle using key 
		Object[] args = new Object[] { messageParam };
		
		responseObject.setMessage(messageSource.getMessage(message, args, null, Locale.US));
		
		responseObject.setStatus("SUCCESS");
		
		//responseObject.setMessage(message);
		
		// clientsesion can be extended to make High availability session by maintinaing them in DB.
		return responseObject;*/
		return Response.status(respNumber).entity(object).build();
	}

	/**
	 * Builds the validation error response.
	 *
	 * @param ve the ve
	 * @param clientSession TODO
	 * @return the response object
	 */
	protected Response buildValidationErrorResponse(ValidationException ve) {
		ResponseObject responseObject = new ResponseObject();
		
		
		ErrorMessage errMsg = getErrorMessageObject(ve.getAppErrorCode(), ve.getErrorMassages());
		
		logger.error("ErrorMessage : " + errMsg.getErrorMassages(),ve);
		
		// load from resource bundle
		
		responseObject.setMessage(errMsg);
		responseObject.setStatus("FAILURE");
		//return responseObject;
		
		return Response.status(ve.getAppErrorCode()).entity(errMsg).build();
		
	}

	

	/*protected ResponseObject buildErrorResponse(AppException ae, ClientSession clientSession) {
		
		// log exception for tracing the issue
	

		ErrorMessage errMsg = getErrorMessageObject(ae.getAppErrorCode(), ae.getErrorMassages());
		
		
		ResponseObject responseObject = new ResponseObject();
		
		responseObject.setMessage(errMsg);
		responseObject.setStatus(AppConstants.FAILURE);
		return responseObject;
	}*/
	
	
	/**
	 * Builds the exception response.
	 *
	 * @param e the exception object
	 * @param objectNameAndOperation the object name and operation
	 * @param clientSession the client session
	 * @return the response object
	 */
	protected Response buildExceptionResponse(Exception e, String objectNameAndOperation){
		// log exception and stack track 
		// or send mail to administrator
		// log to db with key and exceptions info

		// Otherwise setup and send the user to a default error-view.
		String uuid = UUID.randomUUID().toString();
		logger.error("GlobalErrorKey : " + uuid + " Error Message : " + e.getMessage(),e);
		
		// build error message
		
		int errorCode =500;
		Map<String, Object[]> errorMassages = new HashMap<String, Object[]>();
		errorMassages.put("app.exception", new Object[]{objectNameAndOperation,uuid});

		ErrorMessage errMsg = getErrorMessageObject(errorCode, errorMassages);
	
		
		ResponseObject responseObject = new ResponseObject();
		
		responseObject.setMessage(errMsg);
	
		responseObject.setStatus("FAILURE");
		return Response.status(errorCode).entity(errMsg).build();
	}
	
	/**
	 * Gets the error message object.
	 *
	 * @param errorCode the error code
	 * @param errorKeyObject the error key object
	 * @return the error message object
	 */
	private ErrorMessage getErrorMessageObject(int errorCode,
			Map<String, Object[]> errorKeyObject) {
		
		if (errorCode == 0){
			errorCode =  400;
		}
		
		List<String> errorMessages = new ArrayList<String>();
		
		if(errorKeyObject != null){
			for (Map.Entry<String, Object[]> entry : errorKeyObject.entrySet()) {
				errorMessages.add(messageSource.getMessage(entry.getKey(),  entry.getValue(), null, Locale.US));
			}
		}
		
		ErrorMessage errMsg = new ErrorMessage(errorCode,errorMessages );
		return errMsg;
	}
	
	
	
	
	
}