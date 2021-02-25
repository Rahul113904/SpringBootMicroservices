package com.external.resttemplate.entity;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	private String name;
	private String capital;
	private String region;
	private List<String> borders;

//	@OneToOne(targetEntity = Currencies.class)
	private List<Currencies> currencies;
}
