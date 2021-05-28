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

	public Genre(String title/*, String description, boolean published*/) {
		this.title = title;
//		this.description = description;
//		this.published = published;
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


	/*public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}*/

	/*@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}*/

}
