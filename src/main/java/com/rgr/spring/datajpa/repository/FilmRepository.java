package com.rgr.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgr.spring.datajpa.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
	//qqqqq List<Tutorial> findByPublished(boolean published);
	List<Film> findByTitleContaining(String title);
}
