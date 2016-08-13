package com.im.sms.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.im.comparator.TimeStringComparator;
import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.entity.PickupPoint;
import com.im.model.pickuppoint.service.PickupPointService;
import com.im.model.student.entity.Student;
import com.im.model.student.service.StudentService;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;
@Service("smsService")
@Repository
public class SMSServiceImpl implements SMSService{
	public static final String ACCOUNT_SID = "AC5f148c6fd0fd85c3441ea3a8905c4160";
	public static final String AUTH_TOKEN = "ca4f9f5bb867b9532044d7cdd53fc96a";
	private DateFormat primaryFormat = new SimpleDateFormat("h:mm a");
	 private SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yy");
	private SimpleDateFormat longformat = new SimpleDateFormat("MM/dd/yy HH:mm a");
	final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID,
			AUTH_TOKEN);
	final Account mainAccount = client.getAccount();
	 
	LinkedHashMap<Long,String> objHashMap=new LinkedHashMap<Long,String>();
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	void setJdbcTemplateOracle(@Qualifier("datasource") DataSource dataSource) {
		 namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	@Autowired(required=true)
	PickupPointService pickupPointService;
	@Autowired(required=true)
	StudentService studentService;
	public void sendSMStoStudents(List<Student> contactList,String message) {
	

	    // Get the main account (The one we used to authenticate the client)
	   
	    SmsFactory messageFactory = mainAccount.getSmsFactory();
        Map<String,String> params = new HashMap<String,String>();
        // Replace with a valid phone number for your account.
        params.put("From", "+12013807244"); // Replace with a valid phone number for your account.
        params.put("Body", message);
        System.out.println("SMS list-->"+contactList.size());
        for(Student contactNumber:contactList)
        {
        	Long number=contactNumber.getContactNo();
        	System.out.println("SMS list-->"+String.valueOf(contactNumber.getContactNo()));
        	 params.put("To", "+91"+String.valueOf(contactNumber.getContactNo()));
        	 System.out.println("SMS Number-->"+params.get("To"));
        	try {
				Sms sms = messageFactory.create(params);
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}

	public void sendSMStoStudentsByPickupId(Long routeId,String message) throws ParseException {
		// TODO Auto-generated method stub
		try {
			if (objHashMap.isEmpty()) {
				List<PickupPoint> listPickupPoints = pickupPointService
						.getPickupPointsByRouteId(routeId);
				TimeStringComparator timeStringComparator = new TimeStringComparator();
				Collections.sort(listPickupPoints, timeStringComparator);
				for (PickupPoint pickupPoint : listPickupPoints) {
					objHashMap.put(pickupPoint.getPickupPointId(),
							pickupPoint.getArrivalTime());
				}
				 Date date = new Date();
		       Long key=objHashMap.keySet().iterator().next();
			       String value=objHashMap.get(key);
			       String dateToStr = DateFormat.getInstance().format(new Date());  
			       Date d1 = longformat.parse(dateToStr);
					Date d2 = longformat.parse(simpleformat.format(new Date())+" "+value);
					long diff = d2.getTime() - d1.getTime();
					int seconds = (int) (diff / 1000) % 60 ;
					System.out.println("Current Time diff-->"+d2.getTime() +" time-2"+ d1.getTime()+"seconds-->"+seconds);
					System.out.println("Current Time is bfore-->"+d1.before(d2));
					System.out.println("Current Time is bfore-->"+objHashMap.size());
					if(d1.before(d2) && seconds<=300 && !objHashMap.isEmpty())
					{ 
						System.out.println("Inside condition-->");
						List<Student> studentList=studentService.getStudentsByPickupPointsId(key);
						sendSMStoStudents(studentList,message);
						objHashMap.remove(key);
					}
			}
		} catch (ValidationException e) {
			// TODO Auto-generated catch blockngC
			e.printStackTrace();
		}
	}
	
public static void main(String args[])
{
	SMSServiceImpl sMSServiceImpl=new SMSServiceImpl();
	Student student = new Student();
	List<Student> studentlist = new ArrayList();
	student.setContactNo(Long.valueOf("9916170049"));
	studentlist.add(student);
	sMSServiceImpl.sendSMStoStudents(studentlist, "Hello message");
}
}
