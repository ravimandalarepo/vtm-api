package com.vtm.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.im.framework.exceptions.AppException;
import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.entity.PickupPoint;
import com.im.model.pickuppoint.service.PickupPointService;
import com.im.model.route.entity.Route;
import com.im.model.route.service.RouteService;
import com.im.model.student.entity.Student;
import com.im.model.student.service.StudentService;
import com.im.sms.service.SMSService;
import com.vtm.model.StudentList;
import com.vtm.model.User;
import com.vtm.service.UserService;
 
@RestController
public class VtmRestController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    @Autowired
    RouteService routeService;
    @Autowired
    StudentService studentService;
    @Autowired
    SMSService smsService;
    @Autowired
    PickupPointService pickpointService;
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ResponseEntity<List<Route>> listAllRoutes() {
       // List<User> users = userService.findAllUsers();
    	List<Route> allRoutes=null;
		try {
			allRoutes = routeService.getAllRoutes();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(allRoutes.isEmpty()){
            return new ResponseEntity<List<Route>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Route>>(allRoutes, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching Route with id " + id);
		Route route = null;
		try {
			route = routeService.getRouteById(id);
			if (route == null) {
				System.out.println("Route with id " + id + " not found");
				return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
			}
		} catch (AppException e) {
			
			e.printStackTrace();
		} catch (ValidationException e) {
			
			e.printStackTrace();
		}

		return new ResponseEntity<Route>(route, HttpStatus.OK);
	}
     
     
    //-------------------Send SMS--------------------------------------------------------
     
    @RequestMapping(value = "/route/sms", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendSMS(@RequestBody String routeId) throws NumberFormatException, ValidationException {
        System.out.println("Sending SMS " + routeId);
       List<Student> studentList =studentService.getStudentsByrouteId(Long.valueOf(routeId));
       smsService.sendSMStoStudents(studentList);
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/route").buildAndExpand().toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    //-------------------Send SMS--------------------------------------------------------
    
    @RequestMapping(value = "/student/onboard", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> updateStudentOnBoardStatus(@RequestBody String studentId) throws NumberFormatException, ValidationException {
        System.out.println("updating Student onboard " + studentId);
       String status =studentService.storeStudentOnboardStatus(Long.valueOf(studentId));
       Map<String,String> map=new HashMap<String, String>();
       map.put("status", status);
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/route").buildAndExpand().toUri());
        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }
     
    //------------------- Getting Bus pickup points --------------------------------------------------------
     
    @RequestMapping(value = "/pickuppoints/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PickupPoint>> getBusPickuppoints(@PathVariable("id") long id) {
		System.out.println("Fetching Route with id " + id);
		List<PickupPoint> listPickupPints = null;
		try {
			listPickupPints = pickpointService.getPickupPointsByRouteId(id);
			if (listPickupPints == null) {
				System.out.println("Route with id " + id + " not found");
				return new ResponseEntity<List<PickupPoint>>(
						HttpStatus.NOT_FOUND);
			}
		} catch (ValidationException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<List<PickupPoint>>(listPickupPints,
				HttpStatus.OK);
	}
     
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/studentsByPickupPoint/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentList> getstudentsByPickupPoint(@PathVariable("id") long id) {
		System.out.println("Fetching Route with id " + id);
		List<Student> listStudents = null;
		StudentList studentList=new StudentList();
		Map<String,Integer> studentsCountperRoute=new HashMap<String,Integer>();
		try {
			listStudents = studentService.getStudentsByPickupPointsId(id);
			if (listStudents == null) {
				System.out.println("Route with id " + id + " not found");
				return new ResponseEntity<StudentList>(HttpStatus.NOT_FOUND);
			}
		} catch (ValidationException e) {

			e.printStackTrace();
		}
		studentList.setTotalStudents(listStudents.size());
		studentList.setStudents(listStudents);
		return new ResponseEntity<StudentList>(studentList,HttpStatus.OK);
	}
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
}