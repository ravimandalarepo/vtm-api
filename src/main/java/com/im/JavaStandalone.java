package com.im;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.im.framework.exceptions.AppException;
import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.entity.PickupPoint;
import com.im.model.pickuppoint.service.PickupPointService;
import com.im.model.route.entity.Route;
import com.im.model.route.service.RouteService;
import com.im.model.student.entity.Student;
import com.im.model.student.persistance.StudentPersistanceImpl;
import com.im.model.student.service.StudentService;
import com.im.sms.service.SMSService;

public class JavaStandalone {

	private static final Logger logger = LoggerFactory.getLogger(JavaStandalone.class);

	  private JavaStandalone(){
		  
	  }
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	public static void main(String[] arg) {
		/*
		 * Bootstrapping
		 * staring UI
		 */
		ApplicationContext applicationContext=null;
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
		//		"spring-jersey.xml");
		try {
			// bootstrapping the application 
			
			logger.info("Bootstrapping the application Initializing Spring context.");

			sendSMS(1,applicationContext);
		//	getRoutes(applicationContext);
			
		//	getRouteBydId(1, applicationContext);
			
		//	getPickupPointsByRouteId(1, applicationContext);
			
		//	getAllStudents(applicationContext);

		//	getStudentById(1, applicationContext);
		
		//	getStudentsByPickupId(1, applicationContext);
			
			
			// keep checking at intervals saying monitor is fine and processor is fine.
			
		} catch ( Exception e) {
			
			
			logger.error("Exception in agent while running and it is stopped", e);
		} finally{
			
			applicationContext = null;
		}
		
	}
	private static void sendSMS(long routeId,
			ApplicationContext applicationContext) throws ValidationException {
		//Device Discovery
		logger.info("pickupPointService START");
		/*SMSService pickupPointService  = (SMSService) applicationContext
				.getBean("smsService");
		List<Student> contactList=new ArrayList<Student>();
		Student student=new Student();
		student.setContactNo(9916);
		contactList.add(student);
		 pickupPointService.sendSMStoStudents(contactList);;*/
		//StudentService studentService  = (StudentService) applicationContext
		//		.getBean("studentService");
		StudentPersistanceImpl serv= new StudentPersistanceImpl();
		serv.storeStudentOnBoardStatus(1,2);
		
		logger.info("pickupPointService END");
	}
	private static void getPickupPointsByRouteId(long routeId,
			ApplicationContext applicationContext) throws ValidationException {
		//Device Discovery
		logger.info("pickupPointService START");
		PickupPointService pickupPointService  = (PickupPointService) applicationContext
				.getBean("pickupPointService");
		 List<PickupPoint> pickupPoints = pickupPointService.getPickupPointsByRouteId(routeId);
		 for(PickupPoint pp : pickupPoints){
			 System.out.println("pick point name   : " +  pp.getPickupPointName());
		 }
		logger.info("pickupPointService END");
	}
	

	private static void getRoutes(ApplicationContext applicationContext) throws ValidationException, AppException {
		logger.info("getRoutes START");
		RouteService routeService  = (RouteService) applicationContext
				.getBean("routeService");
		List<Route> allRoutes = routeService.getAllRoutes();
		 for(Route route : allRoutes){
			 System.out.println("route name   : " +  route.getName());
		 }
	}
	
	
	private static void getRouteBydId(long routeId,
			ApplicationContext applicationContext) throws ValidationException, AppException {
		logger.info("getRouteBydId START");
		RouteService routeService  = (RouteService) applicationContext
						.getBean("routeService");
				Route routeById = routeService.getRouteById(routeId);
					 System.out.println("route name   : " +  routeById.getName());
	}
	
	
	
	private static void getAllStudents(	ApplicationContext applicationContext) throws ValidationException, AppException {
		logger.info("getAllStudents START");
		StudentService studentService  = (StudentService) applicationContext
						.getBean("studentService");
		List<Student> findAll = studentService.getAllStudents();
		 for(Student student : findAll){
			 System.out.println("student name   : " +  student.getFirstName());
		 }
	}
	
	private static void getStudentsByPickupId(long  pickupId, ApplicationContext applicationContext) throws ValidationException, AppException {
		logger.info("getAllStudents START");
		StudentService studentService  = (StudentService) applicationContext
						.getBean("studentService");
		List<Student> findAll = studentService.getStudentsByPickupPointsId(pickupId);
		 for(Student student : findAll){
			 System.out.println("student name   : " +  student.getFirstName());
		 }
	}
	
	
	private static void getStudentById(long  id, ApplicationContext applicationContext) throws ValidationException, AppException {
		logger.info("getAllStudents START");
		StudentService studentService  = (StudentService) applicationContext
						.getBean("studentService");
		Student findById = studentService.getById(id);
			 System.out.println("student name   : " +  findById.getFirstName());
	}
	
}
