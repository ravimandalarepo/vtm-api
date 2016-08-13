package com.im.restservice;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.im.framework.exceptions.AppException;
import com.im.framework.exceptions.ValidationException;
import com.im.framework.sdo.ResponseObject;
import com.im.model.route.entity.Route;
import com.im.model.route.service.RouteService;

@Component
@Path("/routes")
public class RouteRestServce extends AppRestService {
	private static final Logger logger = LoggerFactory.getLogger(RouteRestServce.class);
	@Resource
	RouteService routeService;
	
	 

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllRoutes() {
 
    	

		if(logger.isDebugEnabled()){
			logger.debug("getAllRoutes  start");
		}
		
		Response responseObject= null;
		try{
					
			//validation 
				
			//business
			List<Route> allRoutes = routeService.getAllRoutes();
			//output
			responseObject= buildSuccessResponse(allRoutes, "read.success", "Routes",200);
		
		
		} catch (ValidationException ve) {
			logger.error("Validation Error ", ve);
			responseObject = buildValidationErrorResponse(ve);
		}catch(AppException e){			
			responseObject = buildExceptionResponse(e, "get Routes");
		}catch(Exception e){
			responseObject = buildExceptionResponse(e, "get Routes");
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("getAllRoutes end :  responseObject : " + responseObject);
		}
		return responseObject;
		
		
    }
    

    @GET
    @Path("{Id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getRouteById(@PathParam("Id") Long Id) {
 
    	

		if(logger.isDebugEnabled()){
			logger.debug("getRouteById  start");
		}
		
		Response responseObject= null;
		try{
					
			//validation 
				
			//business
			Route routeById = routeService.getRouteById(Id);
			//output
			responseObject= buildSuccessResponse(routeById, "read.success", "Routes", 200);
		
		
		} catch (ValidationException ve) {
			logger.error("Validation Error ", ve);
			responseObject = buildValidationErrorResponse(ve);
		}catch(AppException e){			
			responseObject = buildExceptionResponse(e, "get Route");
		}catch(Exception e){
			responseObject = buildExceptionResponse(e, "get Route");
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("getRouteById end :  responseObject : " + responseObject);
		}
		return responseObject;
		
		
    }
    

    @GET
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("test")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BookType getBookInfo() {
 
        // retrieve book information based on the id supplied in the formal argument
 
        BookType bookType = new BookType();
        bookType.setBookId(2522);
        bookType.setBookName("rrrrr");
        bookType.setAuthor("");
        bookType.setCategory("sss");
        return bookType;
    }

 }
