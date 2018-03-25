/**
 * 
 */
package com.gcit.library.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author gcit
 *
 */
@Component
public class template {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	   // Do any additional configuration here
	   return builder.build();
	}
	
	@Bean
	public List<MediaType> mediaType(){
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.APPLICATION_JSON);
		list.add(MediaType.APPLICATION_XML);
		return list;
	}
}
