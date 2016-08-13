package com.im.model.route.persistance;

import java.util.List;

import com.im.framework.exceptions.AppException;
import com.im.model.route.entity.Route;


public interface RoutePersistance {

	List<Route> findAll();

    Route findRouteById(Long Id)throws AppException;


}
