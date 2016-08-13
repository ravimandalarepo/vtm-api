package com.im.model.pickuppoint.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.entity.PickupPoint;
import com.im.model.pickuppoint.persistance.PickupPointPersistance;

@Component("pickupPointService")
public class PickupPointServiceImpl implements PickupPointService {

	private static final Logger logger = LoggerFactory.getLogger(PickupPointServiceImpl.class);
	
	@Autowired(required=true)
	PickupPointPersistance pckupPointPersistance;

	/* (non-Javadoc)
	 * @see com.im.model.pickuppoint.service.PickupPointService#getAllPickupPoints()
	 */
	public List<PickupPoint> getAllPickupPoints() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAllPickupPoints() - start ");
		}
 
	/*	
		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(productId == null ){
			
			hashMap.put("value.required", new Object[]{"product Id"});
		}
		*/
		
		List<PickupPoint> findAll = pckupPointPersistance.findAll();

        if (logger.isDebugEnabled()) {
			logger.debug("getAllPickupPoints() - end ");
		}
		return  findAll;

	}

	public List<PickupPoint> getPickupPointsByRouteId(long routeId) throws ValidationException {
		
		if (logger.isDebugEnabled()) {
			logger.debug("getPickupPointsByRouteId() - start ");
		}
 

		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(routeId == 0 ){
			
			hashMap.put("value.required", new Object[]{"Route Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		List<PickupPoint> findPickupPointsByRouteId = pckupPointPersistance.findPickupPointsByRouteId(routeId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getPricingByProductId() - end ");
		}
		
		return findPickupPointsByRouteId;
	
	}

	public PickupPoint getByPickupPointId(long id) throws ValidationException {
		
		if (logger.isDebugEnabled()) {
			logger.debug("getPickupPointsByRouteId() - start ");
		}
		
		HashMap<String, Object[]> hashMap = new HashMap<String,Object[]>();
		if(id == 0 ){
			
			hashMap.put("value.required", new Object[]{"Pickup point Id"});
		}
		

		if(!hashMap.isEmpty()){
			ValidationException valExc = new ValidationException(400,hashMap );
			throw valExc;
		}
		
		PickupPoint findById = pckupPointPersistance.findById(id);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getPricingByProductId() - end ");
		}
		
		return findById;
	}

}
