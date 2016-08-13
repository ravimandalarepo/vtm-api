package com.im.model.pickuppoint.service;

import java.util.List;

import com.im.framework.exceptions.ValidationException;
import com.im.model.pickuppoint.entity.PickupPoint;

// TODO: Auto-generated Javadoc
/**
 * The Interface PickupPointService.
 */
public interface PickupPointService {

	

/**
 * Gets the all pickup points.
 *
 * @return the all pickup points
 */
public List<PickupPoint> getAllPickupPoints();

/**
 * Gets the pickup points by route id.
 *
 * @param routeId the route id
 * @return the pickup points by route id
 * @throws ValidationException the validation exception
 */
public List<PickupPoint> getPickupPointsByRouteId(long routeId) throws ValidationException;

/**
 * Gets the by pickup point id.
 *
 * @param id the id
 * @return the by pickup point id
 * @throws ValidationException the validation exception
 */
public PickupPoint getByPickupPointId(long id) throws ValidationException;
}
