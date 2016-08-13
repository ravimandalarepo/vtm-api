package com.im.restclient.product;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.im.restclient.RestClientTemplate;

@Component
public class ProductProxy {

	public Product getProductByProductId(Integer productId){
		
		HashMap<String, String>  map = new HashMap<String, String>();
		
		map.put("productId", productId.toString());
		Product request = RestClientTemplate.getRequest("products/" + productId, null);
		
		return request;
	}
}
