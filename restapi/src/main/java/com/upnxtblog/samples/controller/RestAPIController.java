package com.upnxtblog.samples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.upnxtblog.samples.dao.CustomerRepository;
import com.upnxtblog.samples.model.Country;
import com.upnxtblog.samples.model.Customer;

@RestController
public class RestAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    CustomerRepository customerRepository;
	
	@Value("${environment}")
	private String env;
	
	
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello world! >>> <a href='http://upnxtblog.com' target='_blank'>upnxtblog.com</a>";
	}
	
	// https://restcountries.eu/#api-endpoints-all
	@GetMapping("/api/countries")
	public List<Country> getContries() {
		String URL = "https://restcountries.eu/rest/v2/all";
		ResponseEntity<List<Country>> responseEntity = 
				restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {});
		List<Country> pojoObjList = responseEntity.getBody();
		
		return pojoObjList;
	}
	
	@GetMapping("/api/customers")
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/api/env")
	public String getEnv() {
		return this.env;
	}
}
