package com.im.model.route.service;

import java.util.List;

import com.im.framework.exceptions.AppException;
import com.im.framework.exceptions.ValidationException;
import com.im.model.route.entity.Route;


// TODO: Auto-generated Javadoc
/**
 * The Interface RouteService.
 */
public interface RouteService {

	/**
	 * Gets the all routes.
	 *
	 * @return the all routes
	 * @throws ValidationException the validation exception
	 * @throws AppException the app exception
	 */
	public List<Route> getAllRoutes() throws ValidationException,AppException;

	 /**
 	 * Gets the route by id.
 	 *
 	 * @param Id the id
 	 * @return the route by id
 	 * @throws AppException the app exception
 	 * @throws ValidationException the validation exception
 	 */
 	Route getRouteById(Long Id)throws AppException, ValidationException;
}
