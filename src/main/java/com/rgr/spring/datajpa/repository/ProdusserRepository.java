package com.rgr.spring.datajpa.repository;

import com.rgr.spring.datajpa.model.Produsser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdusserRepository extends JpaRepository<Produsser, Long> {
	//qqqqq List<Tutorial> findByPublished(boolean published);
	List<Produsser> findByTitleContaining(String title);
}
