package com.demo.springbootdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

@Entity
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Developer> developers;


	
	public Team(String name, List<Developer> developer) {
		super();
		this.name = name;
		this.developers = developer;
	}


	public Team() {
		super();

	}
	


	public List<Developer> getDevelopers() {
		return developers;
	}


	public void setDevelopers(List<Developer> developer) {
		this.developers = developer;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
