package com.external.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.external.resttemplate.entity.Country;
import com.external.resttemplate.repo.CountryRepo;

@Service
public class CountryService {

	@Autowired
	private CountryRepo repo;
	 
	public Country getByname(String name){
		return repo.findByname(name);
	}
}
