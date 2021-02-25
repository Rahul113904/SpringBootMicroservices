package com.external.resttemplate.entity;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	private int id;
	private String imdb_id;
	private String title;
	private String status;
	private String release_date;
	
//	@OneToOne(targetEntity = Genres.class)
	private List<Genres> genres;
}
