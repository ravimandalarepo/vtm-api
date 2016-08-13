package com.im.sms.service;

import java.text.ParseException;
import java.util.List;

import com.im.framework.exceptions.ValidationException;
import com.im.model.student.entity.Student;

public interface SMSService {

	/**
	 * Send SMS the all students.
	 *
	 * @return the all students
	 */
	public void sendSMStoStudents(List<Student> contactList,String message);
	
	/**
	 * Send SMS the  students by pickup ID on some interval.
	 *
	 * @return the all students
	 * @throws ParseException 
	 */
	public void sendSMStoStudentsByPickupId(Long routeId,String message) throws ValidationException, ParseException;
}
