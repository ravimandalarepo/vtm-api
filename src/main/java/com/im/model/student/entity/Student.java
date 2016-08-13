package com.im.model.student.entity;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student {
	
	/** The id. */
	private long id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The dob. */
	private Date dob;
	
	/** The parent id. */
	private long parentId;
	
	/** The enrollement id. */
	private long enrollementId;
	
	/** The gender. */
	private String gender;
	
	/** The observations. */
	private String observations;
	
	/** The student class. */
	private int studentClass;
	
	/** The section. */
	private String section;
	
	/** The contact no. */
	private long contactNo;
	
	/** The pickup point id. */
	private long pickupPointId;
	
	/** The route id. */
	private long routeId;
	
	/**Presentee count*/
	private int presentCount;
	
	/**Absentee count*/
	private int absenteeCount;
	
	/**Exceptional count*/
	private int exceptionalCount;
	
	/** TotalStudents by route ID*/
	
	private int totalStudentsByRoute;
	
/** TotalStudents by route ID*/
	
	private int totalStudentsByPickup;
	
	private int onBoardedCount;

	private String onBoardedStatus;
	
	public String getOnBoardedStatus() {
		return onBoardedStatus;
	}

	public void setOnBoardedStatus(String onBoardedStatus) {
		this.onBoardedStatus = onBoardedStatus;
	}

	public int getOnBoardedCount() {
		return onBoardedCount;
	}

	public void setOnBoardedCount(int onBoardedCount) {
		this.onBoardedCount = onBoardedCount;
	}

	public int getTotalStudentsByPickup() {
	return totalStudentsByPickup;
}

public void setTotalStudentsByPickup(int totalStudentsByPickup) {
	this.totalStudentsByPickup = totalStudentsByPickup;
}

	public int getTotalStudentsByRoute() {
		return totalStudentsByRoute;
	}

	public void setTotalStudentsByRoute(int totalStudentsByRoute) {
		this.totalStudentsByRoute = totalStudentsByRoute;
	}

	public int getExceptionalCount() {
		return exceptionalCount;
	}

	public void setExceptionalCount(int exceptionalCount) {
		this.exceptionalCount = exceptionalCount;
	}

	public int getPresentCount() {
		return presentCount;
	}

	public void setPresentCount(int presentCount) {
		this.presentCount = presentCount;
	}

	public int getAbsenteeCount() {
		return absenteeCount;
	}

	public void setAbsenteeCount(int absenteeCount) {
		this.absenteeCount = absenteeCount;
	}

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	
	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * Gets the parent id.
	 *
	 * @return the parent id
	 */
	public long getParentId() {
		return parentId;
	}
	
	/**
	 * Sets the parent id.
	 *
	 * @param parentId the new parent id
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * Gets the enrollement id.
	 *
	 * @return the enrollement id
	 */
	public long getEnrollementId() {
		return enrollementId;
	}
	
	/**
	 * Sets the enrollement id.
	 *
	 * @param enrollementId the new enrollement id
	 */
	public void setEnrollementId(long enrollementId) {
		this.enrollementId = enrollementId;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the observations.
	 *
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}
	
	/**
	 * Sets the observations.
	 *
	 * @param observations the new observations
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	/**
	 * Gets the student class.
	 *
	 * @return the student class
	 */
	public int getStudentClass() {
		return studentClass;
	}
	
	/**
	 * Sets the student class.
	 *
	 * @param studentClass the new student class
	 */
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * Gets the section.
	 *
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	
	/**
	 * Gets the contact no.
	 *
	 * @return the contact no
	 */
	public long getContactNo() {
		return contactNo;
	}
	
	/**
	 * Sets the contact no.
	 *
	 * @param contactNo the new contact no
	 */
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	/**
	 * Gets the pickup point id.
	 *
	 * @return the pickup point id
	 */
	public long getPickupPointId() {
		return pickupPointId;
	}
	
	/**
	 * Sets the pickup point id.
	 *
	 * @param pickupPointId the new pickup point id
	 */
	public void setPickupPointId(long pickupPointId) {
		this.pickupPointId = pickupPointId;
	}
	
	
	
}
