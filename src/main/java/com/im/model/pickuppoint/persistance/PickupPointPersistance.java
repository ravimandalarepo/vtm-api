package com.im.model.pickuppoint.persistance;

import java.util.List;

import com.im.model.pickuppoint.entity.PickupPoint;

// TODO: Auto-generated Javadoc
/**
 * The Interface PickupPointPersistance.
 */
public interface PickupPointPersistance {

/**
 * Find all.
 *
 * @return the list
 */
public List<PickupPoint> findAll();

/**
 * Find pickup points by route id.
 *
 * @param routeId the route id
 * @return the list
 */
public List<PickupPoint> findPickupPointsByRouteId(long routeId);

/**
 * Find by id.
 *
 * @param id the id
 * @return the pickup point
 */
public PickupPoint findById(long id);


}
