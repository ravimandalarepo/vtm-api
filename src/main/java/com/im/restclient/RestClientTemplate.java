package com.im.restclient;


import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.security.KeyStore;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.spi.ConnectorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.im.framework.AppInfo;
import com.im.framework.ApplicationContextProvider;
import com.im.framework.exceptions.AppException;
import com.im.framework.sdo.ResponseObject;
import com.im.restclient.product.Product;

/**
 * The Class RestClientTemplate.
 */
public class RestClientTemplate {

	/** The Constant logger. */
	
	
	private static final Logger logger = LoggerFactory.getLogger(RestClientTemplate.class);

	private static AppInfo appInfo;
	private static String webToken =null;

	private static WebTarget webTarget;
	
	

	/*
	 * enable ssl
	 * enable authentcation with token based appraoch 
	 * enable encryption
	 */


	/**
	 * This method gets data from cloud service with or without query parameters..
	 *
	 * @param path the path
	 * @param queryParms the query parms
	 * @return the request
	 */
	public static  Product  getRequest(String path, Map<String,String> queryParms){
		 /* 
		     WebTarget webTarget = getRestWebTarget();
		     WebTarget resourceWebTarget = webTarget.path(path);
		     Builder request = resourceWebTarget.request(MediaType.APPLICATION_JSON);
		     ResponseObject response =request.get(ResponseObject.class);
		     
		     logger.debug(response.getStatus()  + " : " + response.getResult());
		   */
		   WebTarget webTarget = getRestWebTarget();
	      WebTarget resourceWebTarget = webTarget.path(path);
	      Builder request =null;
	      if(queryParms != null){
	    	  WebTarget queryParam =resourceWebTarget;
	       
			    for(Map.Entry<String, String> entry : queryParms.entrySet()){
			    	
			      queryParam =  queryParam.queryParam(entry.getKey(), entry.getValue());
			      
			    }
	        request = queryParam.request(MediaType.APPLICATION_JSON);
	      }else{
	         request = resourceWebTarget.request(MediaType.APPLICATION_JSON);
	      }
	       
	      Product response =request.get(Product.class);
		  
	     // logger.debug("response from server  ::::::::::::: "  + response.getStatus()  + " : " + response.getResult());

		  
		  return response;  
		 }


	
	/**
	 * Gets the rest web target.
	 *
	 * @return the rest web target
	 */




	private  static WebTarget getRestWebTarget() {

		if(appInfo == null){
			try {
				appInfo = (AppInfo) ApplicationContextProvider.getBean("appInfo");
			} catch (AppException e2) {
				logger.error("Error while getting info bean");
			}
		}
	
		
		if(webTarget == null){

			URI url = UriBuilder.fromUri(appInfo.getProductServiceURL()).build();
			

				// Commenting old code SSL Test 

				ClientConfig config = new ClientConfig();
				ConnectorProvider provider = new ApacheConnectorProvider();
				config.connectorProvider(provider);
				Client client1 = ClientBuilder.newClient(config);
				webTarget = client1.target(url);
				
			

			

		}
		
		return webTarget;

	}


	





}
