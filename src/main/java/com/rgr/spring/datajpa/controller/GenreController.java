package com.rgr.spring.datajpa.controller;

import com.rgr.spring.datajpa.model.Genre;
import com.rgr.spring.datajpa.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class GenreController {

	@Autowired
	GenreRepository repository;

	@GetMapping("/genre")
	public ResponseEntity<List<Genre>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Genre> genreList = new ArrayList<Genre>();

			if (title == null)
				repository.findAll().forEach(genreList::add);
			else
				repository.findByTitleContaining(title).forEach(genreList::add);

			if (genreList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(genreList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/genre/{id}")
	public ResponseEntity<Genre> getTutorialById(@PathVariable("id") long id) {
		Optional<Genre> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/genreadmin")
	public ResponseEntity<Genre> createTutorial(@RequestBody Genre film) {
		try {
			Genre _genre = repository
					.save(new Genre(film.getTitle()/*, tutorial.getDescription(), false*/));
			return new ResponseEntity<>(_genre, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/genreadmin/{id}")
	public ResponseEntity<Genre> updateTutorial(@PathVariable("id") long id, @RequestBody Genre film) {
		Optional<Genre> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			Genre _genre = tutorialData.get();
			_genre.setTitle(film.getTitle());
			/*_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());*/
			return new ResponseEntity<>(repository.save(_genre), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/genreadmin/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/genreadmin")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
