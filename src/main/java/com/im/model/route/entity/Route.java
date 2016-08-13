package com.im.model.route.entity;

import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class Route.
 */
@XmlRootElement
public class Route {

	
	
	/** The route id. */
	private long routeId ;
	
	/** The route type. */
	private String routeType ;
	
	/** The name. */
	private  String name;
	
	/** The startlatitude. */
	private double startlatitude;
	
	/** The start longitude. */
	private double startLongitude;
	
	/** The end longitude. */
	private double endLongitude;
	
	/** The end latitude. */
	private double endLatitude;
	
	/** The bus no. */
	private String busNo;
	
	/** The start_time no. */
	private String startTime;
	
	/** The end_time no. */
	private String endTime;
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	/** The start point. */
	private String startPoint;
	
	/** The end point. */
	private String endPoint;
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
	 * Gets the route type.
	 *
	 * @return the route type
	 */
	public String getRouteType() {
		return routeType;
	}
	
	/**
	 * Sets the route type.
	 *
	 * @param routeType the new route type
	 */
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the startlatitude.
	 *
	 * @return the startlatitude
	 */
	public double getStartlatitude() {
		return startlatitude;
	}
	
	/**
	 * Sets the startlatitude.
	 *
	 * @param startlatitude the new startlatitude
	 */
	public void setStartlatitude(double startlatitude) {
		this.startlatitude = startlatitude;
	}
	
	/**
	 * Gets the start longitude.
	 *
	 * @return the start longitude
	 */
	public double getStartLongitude() {
		return startLongitude;
	}
	
	/**
	 * Sets the start longitude.
	 *
	 * @param startLongitude the new start longitude
	 */
	public void setStartLongitude(double startLongitude) {
		this.startLongitude = startLongitude;
	}
	
	/**
	 * Gets the end longitude.
	 *
	 * @return the end longitude
	 */
	public double getEndLongitude() {
		return endLongitude;
	}
	
	/**
	 * Sets the end longitude.
	 *
	 * @param endLongitude the new end longitude
	 */
	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}
	
	/**
	 * Gets the end latitude.
	 *
	 * @return the end latitude
	 */
	public double getEndLatitude() {
		return endLatitude;
	}
	
	/**
	 * Sets the end latitude.
	 *
	 * @param endLatitude the new end latitude
	 */
	public void setEndLatitude(double endLatitude) {
		this.endLatitude = endLatitude;
	}
	
	
	
}
