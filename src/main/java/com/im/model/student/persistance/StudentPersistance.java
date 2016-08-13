package com.im.model.student.persistance;

import java.util.List;

import com.im.model.student.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentPersistance.
 */
public interface StudentPersistance {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Student> findAll();
	
	/**
	 * Find students by pickup points id.
	 *
	 * @param pickupPointId the pickup point id
	 * @return the list
	 */
	public List<Student> findStudentsByPickupPointsId(long pickupPointId);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the student
	 */
	public Student findById(long id);
	
	/**
	 * Find students by routeId id.
	 *
	 * @param pickupPointId the routeId
	 * @return the list
	 */
	public List<Student> getStudentsByrouteId(long routeId);
	
	/**
	 * Find students by  id.
	 *
	 * @param routeId
	 * @return the list
	 */
	public Student storeStudentOnBoardStatus(long studentId,long pickupPointId);
	
	/**
	 * Find students by  id.
	 *
	 * @param routeId
	 * @return the list
	 */
	
	public Student getStudentsPresentCountByrouteId(long routeId);
	
	/**
	 * Find students by  id.
	 *
	 * @param pickupPintID
	 * @return the list
	 */
	
	public Student getStudentsPresentCountByPickupPointId(long pickupPointId);
}
