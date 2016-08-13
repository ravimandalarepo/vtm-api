package com.im.model.student.service;

import java.util.List;

import com.im.framework.exceptions.ValidationException;
import com.im.model.student.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	public List<Student> getAllStudents();
	
	/**
	 * Gets the students by pickup points id.
	 *
	 * @param pickupPointId the pickup point id
	 * @return the students by pickup points id
	 * @throws ValidationException the validation exception
	 */
	public List<Student> getStudentsByPickupPointsId(long pickupPointId) throws ValidationException;
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 * @throws ValidationException the validation exception
	 */
	public Student getById(long id) throws ValidationException;
	
	/**
	 * Gets the students by pickup points id.
	 *
	 * @param routeId the pickup point id
	 * @return the students by pickup points id
	 * @throws ValidationException the validation exception
	 */
	public List<Student> getStudentsByrouteId(long routeId) throws ValidationException;
	
	/**
	 * Store the students onBoard Details.
	 *
	 * @param studentid 
	 * @return the status
	 * @throws ValidationException the validation exception
	 */
	public Student storeStudentOnboardStatus(long studentId,long pickupPointId) throws ValidationException;
	
	/**
	 * Find students by  id.
	 *
	 * @param routeId
	 * @return the list
	 */
	
	public Student getStudentsPresentCountByrouteId(long routeId) throws ValidationException;;
	
	/**
	 * Find students by  id.
	 *
	 * @param pickupPintID
	 * @return the list
	 */
	
	public Student getStudentsPresentCountByPickupPointId(long pickupPointId) throws ValidationException;;
}
