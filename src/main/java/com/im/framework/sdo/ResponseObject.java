package com.im.framework.sdo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6607224217601526896L;
	private String status ; // it should be either success, failure
	@XmlElement
	private Object result;
	@XmlElement
	private Object message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResponseObject [status=" + status + ", result=" + result
				+ ", message=" + message + "]";
	}

}
