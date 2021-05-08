package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Long> {
	List<BookEntity> findByNameLikeAndNbPageBetweenAndPriceBetween(String name, int nbPageMin, int nbPageMax, Float priceMin, Float priceMax);
}