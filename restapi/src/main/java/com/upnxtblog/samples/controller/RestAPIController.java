package com.upnxtblog.samples.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.upnxtblog.samples.dao.CustomerRepository;
import com.upnxtblog.samples.model.Country;
import com.upnxtblog.samples.model.Customer;
import com.upnxtblog.samples.props.AppProperties;
import com.upnxtblog.samples.props.GlobalProperties;

@RestController
public class RestAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    CustomerRepository customerRepository;
	
//	@Value("${environment}")
//	private String env;
	
    @Autowired
    GlobalProperties global;	
    
    @Autowired
    AppProperties appProp;
	
	@GetMapping("/api/hello")
	public String hello(@RequestHeader("uid") String uid) {
		return "Hello world! >>> <a href='http://upnxtblog.com' target='_blank'>upnxtblog.com</a> <br> " 
					+ "uid header value: " + uid;
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
	
//	@GetMapping("/api/env")
//	public String getEnv() {
//		return this.env;
//	}
	
	@GetMapping("/api/globalprop")
	public String getGlobalProp() {
		return this.global.getEmail();
	}
	
	@GetMapping("/api/appprop")
	public AppProperties getAppProp() {
		return this.appProp;
	}
	
	@GetMapping("/api/redirect")
	public void redirect(HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie("test", "test-data");
			cookie.setPath("/demo-weblogic");
			response.addCookie(cookie );
			response.setHeader("uid", "user_7788");
			response.sendRedirect("/demo-weblogic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
