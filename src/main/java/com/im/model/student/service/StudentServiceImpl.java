package com.im.model.student.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.service.PickupPointServiceImpl;
import com.im.model.student.entity.Student;
import com.im.model.student.persistance.StudentPersistance;

@Component("studentService")
public class StudentServiceImpl implements StudentService {


	private static final Logger logger = LoggerFactory.getLogger(PickupPointServiceImpl.class);
	
	@Autowired(required=true)
	StudentPersistance studentPersistance;
	
	/* (non-Javadoc)
	 * @see com.im.model.student.service.StudentService#getAllStudents()
	 */
	public List<Student> getAllStudents() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAllPickupPoints() - start ");
		}
 
		
		List<Student> findAll = studentPersistance.findAll();

        if (logger.isDebugEnabled()) {
			logger.debug("getAllPickupPoints() - end ");
		}
		return  findAll;


	}

	public List<Student> getStudentsByPickupPointsId(long pickupPointId) throws ValidationException {
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentsByPickupPointsId() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(pickupPointId == 0 ){
			
			hashMap.put("value.required", new Object[]{"pickupPointId Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		List<Student> findStudentsByPickupPointsId = studentPersistance.findStudentsByPickupPointsId(pickupPointId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentsByPickupPointsId() - end ");
		}
		
		return findStudentsByPickupPointsId;

	}

	public Student getById(long id) throws ValidationException {

		if (logger.isDebugEnabled()) {
			logger.debug("findById() - start ");
		}
		
		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(id == 0 ){
			
			hashMap.put("value.required", new Object[]{"Student Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		Student findById = studentPersistance.findById(id);
		
		if (logger.isDebugEnabled()) {
			logger.debug("findById() - end ");
		}
		
		return findById;

	}

	public List<Student> getStudentsByrouteId(long routeId)
			throws ValidationException {
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(routeId == 0 ){
			
			hashMap.put("value.required", new Object[]{"routeId Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		List<Student> findStudentsByrouteId = studentPersistance.getStudentsByrouteId(routeId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - end ");
		}
		
		return findStudentsByrouteId;
	}

	public Student storeStudentOnboardStatus(long studentId,long pickupPointId)
			throws ValidationException {
	
		if (logger.isDebugEnabled()) {
			logger.debug("storeStudentOnboardStatus() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(studentId == 0 ){
			
			hashMap.put("value.required", new Object[]{"studentId Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		Student student = studentPersistance.storeStudentOnBoardStatus(studentId,pickupPointId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - end ");
		}
		return student;	
	}
	
	public Student getStudentsPresentCountByrouteId(long routeId)
			throws ValidationException {
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(routeId == 0 ){
			
			hashMap.put("value.required", new Object[]{"routeId Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		Student findStudentsByrouteId = studentPersistance.getStudentsPresentCountByrouteId(routeId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - end ");
		}
		
		return findStudentsByrouteId;
	}
	
	public Student getStudentsPresentCountByPickupPointId(long pickupId)
			throws ValidationException {
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(pickupId == 0 ){
			
			hashMap.put("value.required", new Object[]{"pickupId Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		Student findStudentsByrouteId = studentPersistance.getStudentsPresentCountByPickupPointId(pickupId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getStudentsByrouteId() - end ");
		}
		
		return findStudentsByrouteId;
	}
}
