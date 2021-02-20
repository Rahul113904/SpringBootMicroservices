package com.external.resttemplate.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	//	private static String countries_url ="https://restcountries.eu/rest/v2/name/india";
	//	private static String movie_url ="https://api.themoviedb.org/3/movie/";

	@GetMapping("/{n}")
	public List<Country> getCountry(@PathVariable String n) {

		try {
			Country[] countries = restTemplate.getForObject("https://restcountries.eu/rest/v2/name" + "/{n}", Country[].class, n);
			return Arrays.asList(countries);
		}catch (HttpStatusCodeException e) {
			e.getMessage();
		}
		return null;
	}

	//http://www.omdbapi.com/?apikey=121ca141&t=tenet
	@GetMapping("{t}")
	public List<Movie> getMovie(@PathVariable String t) {
		Movie[] movie = restTemplate.getForObject("http://www.omdbapi.com/?apikey=" + "121ca141" + "&t=" + "{t}", Movie[].class, t);
		return Arrays.asList(movie);
	}

	//	@GetMapping("/{name}")
	//	public Country getName(@PathVariable String name) {
	//		Country con = service.getByname(name);
	//		return con;
	//	}
} 
