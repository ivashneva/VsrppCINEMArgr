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

//	@Column(name = "ID_Genre")
//	private int id_genre;
//
//	@Column(name = "ID_Produsser")
//	private int id_produsser;

	public Produsser() {

	}

	public Produsser(String title/*, String description, boolean published*/) {
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

	/*public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}
*/
	/*public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}*/

	/*@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}*/

}
