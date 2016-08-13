package com.im.model.route.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.im.framework.exceptions.AppException;
import com.im.framework.exceptions.ValidationException;
import com.im.model.route.entity.Route;
import com.im.model.route.persistance.RoutePersistance;

// TODO: Auto-generated Javadoc
/**
 * The Class RouteServiceImpl.
 */
@Component("routeService")
public class RouteServiceImpl implements RouteService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);
	
	/** The route persistance. */
	
	@Autowired(required=true)
	RoutePersistance routePersistance;

	
	/* (non-Javadoc)
	 * @see com.im.model.route.service.RouteService#getAllRoutes()
	 */
	public List<Route> getAllRoutes() throws ValidationException,AppException{
		if (logger.isDebugEnabled()) {
			logger.debug("getAllRoutes() - start ");
		}
 
	
		
		List<Route> findAll = routePersistance.findAll();

        if (logger.isDebugEnabled()) {
			logger.debug("getPricingByProductId() - end ");
		}
		return  findAll;
	}


	/* (non-Javadoc)
	 * @see com.im.model.route.service.RouteService#getRouteById(java.lang.Long)
	 */
	public Route getRouteById(Long Id) throws AppException, ValidationException {
		if (logger.isDebugEnabled()) {
			logger.debug("getPricingByProductId() - start ");
		}
 
		
		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(Id == null ){
			
			hashMap.put("value.required", new Object[]{"Route Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
				
		
		Route findRouteById = routePersistance.findRouteById(Id);

        if (logger.isDebugEnabled()) {
			logger.debug("getPricingByProductId() - end ");
		}
		return  findRouteById;
	}



	
}
