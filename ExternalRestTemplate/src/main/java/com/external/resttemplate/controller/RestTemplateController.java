package com.external.resttemplate.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.external.resttemplate.entity.Country;
import com.external.resttemplate.entity.Movie;


@RestController
public class RestTemplateController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String api_key;

	private static String countries_url ="https://restcountries.eu/rest/v2/name/";
	private static String movie_url ="https://api.themoviedb.org/3/movie/";

	@GetMapping("/country/{country_name}")
	public List<Country> getCountry(@PathVariable String country_name) {

		try {
//			Country[] countries = restTemplate.getForObject(countries_url + country_name, Country[].class, country_name);
//			return Arrays.asList(countries);
			return Arrays.stream(restTemplate.getForObject(countries_url + country_name, Country[].class))
                    .collect(Collectors.toList());
		}catch (HttpStatusCodeException e) {
			e.getMessage();
		}
		return null;
		
	}

	@GetMapping("/movie/{movie_id}")
	public Movie getMovie(@PathVariable String movie_id) {
		Movie movie = restTemplate.getForObject(movie_url + movie_id +"?api_key=" + api_key, Movie.class);
		return movie;
	} 
} 
