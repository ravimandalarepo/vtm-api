package com.im.model.student.persistance;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.im.framework.SqlReader;
import com.im.model.student.entity.Student;

@Repository
public class StudentPersistanceImpl implements StudentPersistance{

	
private static final Logger logger = LoggerFactory.getLogger(StudentPersistanceImpl.class);

	
	
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

@Autowired
void setJdbcTemplateOracle(@Qualifier("datasource") DataSource dataSource) {
	 namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
}
	
	/* (non-Javadoc)
	 * @see com.im.model.student.persistance.StudentPersistance#findAll()
	 */
	public List<Student> findAll(){
		
		String sql = SqlReader.getMessageByKey("STUDENT_ALL");
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
		
			
		;

		if(logger.isInfoEnabled()){
			logger.info("findAll : sql : " + sql);
		}
		
		List<Student> students = null;
		try {
			students = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Student>(){
				
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
							
					
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setDob(rs.getDate("dob"));
				student.setParentId(rs.getLong("parent_id"));
				student.setEnrollementId(rs.getLong("enrollment_no"));
				student.setGender(rs.getString("gender"));
				student.setObservations(rs.getString("observation"));
				student.setStudentClass(rs.getInt("class"));
				student.setSection(rs.getString("section"));
				student.setContactNo(rs.getLong("contact_no"));
				student.setPickupPointId(rs.getLong("pickup_point_id"));
				
					
					
					
					return student;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
			logger.info("NO records found");
		}
		
		return students;
	}
		


	
public List<Student> findStudentsByPickupPointsId(long pickupPointId){
		
		String sql = SqlReader.getMessageByKey("STUDENTS_BY_PICKUP_POINT_ID");
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
		.addValue("pickupPointId", pickupPointId)
			
		;

		if(logger.isInfoEnabled()){
			logger.info("findStudentsByPickupPointsId : sql : " + sql);
		}
		
		List<Student> students = null;
		try {
			students = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Student>(){
				
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
							
						
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setDob(rs.getDate("dob"));
				student.setParentId(rs.getLong("parent_id"));
				student.setEnrollementId(rs.getLong("enrollment_no"));
				student.setGender(rs.getString("gender"));
				student.setObservations(rs.getString("observation"));
				student.setStudentClass(rs.getInt("class"));
				student.setSection(rs.getString("section"));
				student.setContactNo(rs.getLong("contact_no"));
				student.setPickupPointId(rs.getLong("pickup_point_id"));
				student.setRouteId(rs.getLong("route_id"));
				student.setOnBoardedStatus(rs.getString("onboard_status"));

					return student;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
			logger.info("NO records found");
		}
		
		return students;
	}
		



public Student findById(long id){
	
	String sql = SqlReader.getMessageByKey("STUDENT_BY_ID");
	
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("studentId", id)
	
		
	;

	if(logger.isInfoEnabled()){
		logger.info("findById : sql : " + sql);
	}
	
	Student student = null;
	try {
		student = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setDob(rs.getDate("dob"));
				student.setParentId(rs.getLong("parent_id"));
				student.setEnrollementId(rs.getLong("enrollment_no"));
				student.setGender(rs.getString("gender"));
				student.setObservations(rs.getString("observation"));
				student.setStudentClass(rs.getInt("class"));
				student.setSection(rs.getString("section"));
				student.setContactNo(rs.getLong("contact_no"));
				student.setPickupPointId(rs.getLong("pickup_point_id"));
				student.setRouteId(rs.getLong("route_id"));
				return student;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
	}
	
	return student;
}




public List<Student> getStudentsByrouteId(long routeId) {
	String sql = SqlReader.getMessageByKey("STUDENTS_BY_ROUTE_ID");
	System.out.println("Students routeID-->"+routeId);
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("routeId", routeId);

	if(logger.isInfoEnabled()){
		logger.info("getStudentsByrouteId : sql : " + sql);
	}
	
	List<Student> students = null;
	try {
		students = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					
			Student student = new Student();
			student.setId(rs.getLong("id"));
			student.setFirstName(rs.getString("first_name"));
			student.setLastName(rs.getString("last_name"));
			student.setDob(rs.getDate("dob"));
			student.setParentId(rs.getLong("parent_id"));
			student.setEnrollementId(rs.getLong("enrollment_no"));
			student.setGender(rs.getString("gender"));
			student.setObservations(rs.getString("observation"));
			student.setStudentClass(rs.getInt("class"));
			student.setSection(rs.getString("section"));
			student.setContactNo(rs.getLong("contact_no"));
			student.setPickupPointId(rs.getLong("pickup_point_id"));
			student.setPickupPointId(rs.getLong("route_id"));

				return student;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
	}
	
	return students;
}

public Student storeStudentOnBoardStatus(long studentId,long pickupPointId) {
	String sql = SqlReader.getMessageByKey("STUDENT_ONBOARD_DETAILS");
	Student student=findById(studentId);
	UUID id = UUID.randomUUID();
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id)
	.addValue("student_id", studentId).addValue("route_id", student.getRouteId()).
	addValue("pickup_point_id",  student.getPickupPointId())
	.addValue("onboard_date", getDateValue())
	.addValue("onboard_status", "Y");
	
	namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	Student studentCount=new Student();
	studentCount.setOnBoardedCount(getOnBoardedCount(pickupPointId).getOnBoardedCount());
	System.out.println("On Boarded COunt-->"+studentCount.getOnBoardedCount());
	return studentCount;
}

public Student getStudentsPresentCountByrouteId(long routeId) {
	String sql = SqlReader.getMessageByKey("STUDENTS_BY_ROUTE_ID_PRESENT");
	System.out.println("Students routeID-->"+routeId);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	String pickup_date = sdf.format(date);
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("routeId", routeId)
	.addValue("pickup_date", pickup_date);
	Student studentCount = new Student();
	if(logger.isInfoEnabled()){
		logger.info("getStudentsByrouteIdPresent : sql : " + sql);
	}
	
	List<Student> students = null;
	try {
		students = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					
			Student student = new Student();
		/*	student.setId(rs.getLong("id"));
			student.setFirstName(rs.getString("first_name"));
			student.setLastName(rs.getString("last_name"));
			student.setDob(rs.getDate("dob"));
			student.setParentId(rs.getLong("parent_id"));
			student.setEnrollementId(rs.getLong("enrollment_no"));
			student.setGender(rs.getString("gender"));
			student.setObservations(rs.getString("observation"));
			student.setStudentClass(rs.getInt("class"));
			student.setSection(rs.getString("section"));
			student.setContactNo(rs.getLong("contact_no"));*/
			student.setPickupPointId(rs.getLong("pickup_point_id"));
			student.setRouteId(rs.getLong("route_id"));

				return student;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
		studentCount.setPresentCount(0);
		studentCount.setAbsenteeCount(0);
		studentCount.setExceptionalCount(0);
		studentCount.setTotalStudentsByRoute(0);
	}
	studentCount.setTotalStudentsByRoute(getStudentsByrouteId(routeId).size());
	studentCount.setPresentCount(students.size());
	studentCount.setAbsenteeCount(getStudentsByrouteId(routeId).size()-studentCount.getPresentCount());
	studentCount.setExceptionalCount(0);
	return studentCount;
}

public Student getStudentsPresentCountByPickupPointId(long pickupPointId) {
	String sql = SqlReader.getMessageByKey("STUDENTS_BY_PICKUP_ID_PRESENT");
	System.out.println("Students routeID-->"+pickupPointId);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	String pickup_date = sdf.format(date);
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("pickupPointId", pickupPointId)
	.addValue("pickup_date", pickup_date);
	Student studentCount = new Student();
	if(logger.isInfoEnabled()){
		logger.info("getStudentsByrouteIdPresent : sql : " + sql);
	}
	
	List<Student> students = null;
	try {
		students = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					
			Student student = new Student();
			/*student.setId(rs.getLong("id"));
			student.setFirstName(rs.getString("first_name"));
			student.setLastName(rs.getString("last_name"));
			student.setDob(rs.getDate("dob"));
			student.setParentId(rs.getLong("parent_id"));
			student.setEnrollementId(rs.getLong("enrollment_no"));
			student.setGender(rs.getString("gender"));
			student.setObservations(rs.getString("observation"));
			student.setStudentClass(rs.getInt("class"));
			student.setSection(rs.getString("section"));
			student.setContactNo(rs.getLong("contact_no"));*/
			student.setPickupPointId(rs.getLong("pickup_point_id"));
			student.setRouteId(rs.getLong("route_id"));

				return student;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
		studentCount.setPresentCount(0);
		studentCount.setAbsenteeCount(0);
		studentCount.setExceptionalCount(0);
		studentCount.setTotalStudentsByPickup(findStudentsByPickupPointsId(pickupPointId).size());
		studentCount.setOnBoardedCount(0);
	}
	studentCount.setTotalStudentsByPickup(findStudentsByPickupPointsId(pickupPointId).size());
	studentCount.setPresentCount(students.size());
	studentCount.setAbsenteeCount(findStudentsByPickupPointsId(pickupPointId).size()-studentCount.getPresentCount());
	studentCount.setExceptionalCount(0);
	studentCount.setOnBoardedCount(0);
	return studentCount;
}

public Student getOnBoardedCount(long pickupPointId)
{
	String sql = SqlReader.getMessageByKey("STUDENTSCOUNT_BY_PICKUP");
	System.out.println("Students routeID-->"+pickupPointId);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	String pickup_date = sdf.format(date);
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("pickupPointId", pickupPointId)
	.addValue("pickup_date", pickup_date);
	if(logger.isInfoEnabled()){
		logger.info("getStudentsByrouteIdPresent : sql : " + sql);
	}
	
	Student studentOnBoardedCount = null;
	try {
		studentOnBoardedCount = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					
			Student student = new Student();
			student.setOnBoardedCount(rs.getInt("onBoardedCount"));
			System.out.println("On Boarded Count-->"+rs.getInt("onBoardedCount"));
			return student;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
		System.out.println("No Records-->");
		studentOnBoardedCount.setOnBoardedCount(0);
		
	}

	return studentOnBoardedCount;
}

public String getDateValue(){
	 SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");//dd/MM/yyyy
	    Date now =new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
}

}
