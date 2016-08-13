package com.im.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppInfo {

	@Value("${productServiceURL}")
	private String productServiceURL;

	public String getProductServiceURL() {
		return productServiceURL;
	}

	public void setProductServiceURL(String productServiceURL) {
		this.productServiceURL = productServiceURL;
	}
	

}
