package com.im.model.route.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
import com.im.framework.exceptions.AppException;
import com.im.model.route.entity.Route;

// TODO: Auto-generated Javadoc
/**
 * The Class RoutePersistanceImpl.
 */
@Repository

public class RoutePersistanceImpl implements RoutePersistance {

/** The Constant logger. */
private static final Logger logger = LoggerFactory.getLogger(RoutePersistanceImpl.class);
	
	/** The named parameter jdbc template. */
/** The named parameter jdbc template. */
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

 @Autowired
 void setJdbcTemplateOracle(@Qualifier("datasource") DataSource dataSource) {
	 namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
 }
	/* (non-Javadoc)
	 * @see com.im.model.route.persistance.RoutePersistance#findAll()
	 */
	public List<Route> findAll(){
		
		String sql = SqlReader.getMessageByKey("ROUTE_SELECT_BY_ALL");
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
		
			
		;

		if(logger.isInfoEnabled()){
			logger.info("findAll : sql : " + sql);
		}
		
		List<Route> routes = null;
		try {
			routes = namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Route>(){
				
				public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
							
									  
					Route route = new Route();
					route.setRouteId(rs.getLong("id"));
					route.setRouteType(rs.getString("route_type"));
					route.setName(rs.getString("name"));
					route.setStartlatitude(rs.getDouble("start_latitude"));
					route.setStartLongitude(rs.getDouble("start_longitude"));
					route.setEndLatitude(rs.getDouble("end_latitude"));
					route.setEndLongitude(rs.getDouble("end_longitude"));
					route.setStartPoint(rs.getString("start_point"));
					route.setEndPoint(rs.getString("end_point"));
					route.setBusNo(rs.getString("bus_no"));
					
					return route;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
			logger.info("NO records found");
		}
		
		return routes;
	}
		


	
/**
 * Creates the.
 *
 * @param pricing the pricing
 * @return the route
 */
public Route create(Route pricing){
	
	String sql = SqlReader.getMessageByKey("PRICING_CREATE");
	
	//values( :productId, :quoteprice)
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()

	;

	
	
	if(logger.isInfoEnabled()){
		logger.info("create : sql : " + sql);
	}
	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder, new String[] { "id" });
	
	pricing.setRouteId(keyHolder.getKey().longValue());
	
	return pricing;
}



/* (non-Javadoc)
 * @see com.im.model.route.persistance.RoutePersistance#findRouteById(java.lang.Long)
 */
public Route findRouteById(Long Id) throws AppException {

	String sql = SqlReader.getMessageByKey("ROUTE_SELECT_BY_ID");
	
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
	.addValue("routeId", Id)
	;

	if(logger.isInfoEnabled()){
		logger.info("findAll : sql : " + sql);
	}
	
	Route route = null;
	try {
		route = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new RowMapper<Route>(){
			
			public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
						
								  
				Route route = new Route();
				route.setRouteId(rs.getLong("id"));
				route.setRouteType(rs.getString("route_type"));
				route.setName(rs.getString("name"));
				route.setStartlatitude(rs.getDouble("start_latitude"));
				route.setStartLongitude(rs.getDouble("start_longitude"));
				route.setEndLatitude(rs.getDouble("end_latitude"));
				route.setEndLongitude(rs.getDouble("end_longitude"));
				route.setStartPoint(rs.getString("start_point"));
				route.setEndPoint(rs.getString("end_point"));
				route.setBusNo(rs.getString("bus_no"));
				route.setStartTime(rs.getString("start_time"));
				route.setEndTime(rs.getString("end_time"));
				return route;
			}
			
		});
	} catch (EmptyResultDataAccessException e) {
		logger.info("NO records found");
	}
	
	return route;

}
	

}
