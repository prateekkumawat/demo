package com.aoct.emr.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CommonController {
	//http://localhost:8075/contract  ->>
	//https://mynx/contract  ->   https://mynx.com/swagger-ui/index.html
	
	
	@GetMapping("/contract")
	public void swagger(HttpServletRequest request,HttpServletResponse response)
	{
			
			String requestedURL = request.getRequestURL().toString();
			String url=requestedURL.substring(0, requestedURL.length()-9);
	        System.out.println("Requested URL: " + url);
	        String path = "/swagger-ui/index.html";   
	        response.setStatus(HttpServletResponse.SC_FOUND);
	        response.setHeader("Location", url+path);
	}
	

}
