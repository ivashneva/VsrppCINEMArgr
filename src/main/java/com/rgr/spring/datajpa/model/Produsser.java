package com.rgr.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "produsser")
public class Produsser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String title;

	public Produsser() {

	}

	public Produsser(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
