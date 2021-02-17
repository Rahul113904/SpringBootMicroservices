package com.external.resttemplate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.external.resttemplate.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

	Country findByname(String name);

}
