package com.rgr.spring.datajpa.repository;

import com.rgr.spring.datajpa.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	List<Genre> findByTitleContaining(String title);
}
