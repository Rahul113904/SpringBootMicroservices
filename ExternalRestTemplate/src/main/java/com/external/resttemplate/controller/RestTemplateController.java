package com.external.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.external.resttemplate.entity.Country;
import com.external.resttemplate.service.CountryService;


@RestController
public class RestTemplateController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CountryService service;

	//121ca141
	@Value("${api.key}")
	private String api_key;

	//	private static String countries_url ="https://restcountries.eu/rest/v2/name/india";
	//	private static String movie_url ="https://api.themoviedb.org/3/movie/";

	@GetMapping("/{name}")
	public Country getCountry(@PathVariable String name){
		Country countries = restTemplate.getForObject("https://restcountries.eu/rest/v2/name" + name, Country.class);
		return countries;
	}

	//http://www.omdbapi.com/?apikey=121ca141&t=tenet
	@GetMapping("/movie")
	public Object getMovieById() {
		Object movie = restTemplate.getForObject("https://omdbapi.com/?api_key=121ca141&t=tenet" , Object.class);
		return movie;
	}
	
	@GetMapping("/{name}")
	public Country getName(@PathVariable String name) {
		Country con = service.getByname(name);
		return con; 
	}
} 
