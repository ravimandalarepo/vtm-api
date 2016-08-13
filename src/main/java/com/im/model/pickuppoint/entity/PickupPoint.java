package com.im.model.pickuppoint.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class PickupPoint.
 */
public class PickupPoint {

	
	/** The pickup point id. */
	private long pickupPointId ;
	
	/** The latitude. */
	private double latitude ;
	
	/** The longitude. */
	private double longitude;
	
	/** The vehicle id. */
	private long vehicleId;
	
	/** The student id. */
	private long studentId;
	
	/** The pickup point name. */
	private String pickupPointName;
	
	/** The route id. */
	private long routeId;
	
	private String arrivalTime;
	
	
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Gets the route id.
	 *
	 * @return the route id
	 */
	public long getRouteId() {
		return routeId;
	}
	
	/**
	 * Sets the route id.
	 *
	 * @param routeId the new route id
	 */
	public void setRouteId(long routeId) {
		this.routeId = routeId;
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
	
	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the vehicle id.
	 *
	 * @return the vehicle id
	 */
	public long getVehicleId() {
		return vehicleId;
	}
	
	/**
	 * Sets the vehicle id.
	 *
	 * @param vehicleId the new vehicle id
	 */
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public long getStudentId() {
		return studentId;
	}
	
	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Gets the pickup point name.
	 *
	 * @return the pickup point name
	 */
	public String getPickupPointName() {
		return pickupPointName;
	}
	
	/**
	 * Sets the pickup point name.
	 *
	 * @param pickupPointName the new pickup point name
	 */
	public void setPickupPointName(String pickupPointName) {
		this.pickupPointName = pickupPointName;
	}
	
	
	
}
