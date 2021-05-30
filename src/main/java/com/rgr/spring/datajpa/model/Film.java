package com.rgr.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String title;

	@Column(name = "ID_Genre")
	private int id_genre;

	@Column(name = "ID_Produsser")
	private int id_produsser;

	public Film() {

	}

	public Film(String title, int id_genretmp, int id_produssertmp) {
		this.title = title;
		this.id_genre = id_genretmp;
		this.id_produsser = id_produssertmp;
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

	public int getId_genre() {
		return id_genre;
	}

	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}

	public int getId_produsser() {
		return id_produsser;
	}

	public void setId_produsser(int id_produsser) {
		this.id_produsser = id_produsser;
	}


}
