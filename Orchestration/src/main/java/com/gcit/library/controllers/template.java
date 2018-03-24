/**
 * 
 */
package com.gcit.library.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
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
}
