package com.rgr.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String title;

	public Genre() {

	}

	public Genre(String title) {
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
