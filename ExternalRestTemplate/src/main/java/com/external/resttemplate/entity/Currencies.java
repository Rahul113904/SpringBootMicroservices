package com.external.resttemplate.entity;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currencies {

	@Id
	private String code;
	private String name;
	private String symbol;
}
