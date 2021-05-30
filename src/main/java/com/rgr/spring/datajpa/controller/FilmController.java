package com.rgr.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgr.spring.datajpa.model.Film;
import com.rgr.spring.datajpa.repository.FilmRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class FilmController {

	@Autowired
	FilmRepository tutorialRepository;

	@PersistenceUnit
	private EntityManagerFactory emf;

	@GetMapping("/film")
	public ResponseEntity<List<Film>> getAllTutorials(@RequestParam(required = false) String title) {
		try {

			EntityManager em = emf.createEntityManager();
			List<Film> films = em
 					.createQuery("SELECT f.id, f.title, p.title, g.title FROM Film f, Produsser p, Genre g WHERE f.id_genre =g.id and f.id_produsser =p.id")
					.getResultList();


			return new ResponseEntity<>(films, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/film/{id}")
	public ResponseEntity<Film> getTutorialById(@PathVariable("id") long id) {
		Optional<Film> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/filmadmin")
	public ResponseEntity<Film> createTutorial(@RequestBody Film film) {
		try {
			Film _film = tutorialRepository
					.save(new Film(film.getTitle(), film.getId_genre(), film.getId_produsser()));
			return new ResponseEntity<>(_film, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/filmadmin/{id}")
	public ResponseEntity<Film> updateTutorial(@PathVariable("id") long id, @RequestBody Film film) {
		Optional<Film> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Film _film = tutorialData.get();
			_film.setTitle(film.getTitle());
			return new ResponseEntity<>(tutorialRepository.save(_film), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/filmadmin/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/filmadmin")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
