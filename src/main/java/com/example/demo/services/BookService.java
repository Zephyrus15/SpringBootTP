package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BookEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.UserRepo;


@Service
public class BookService {
	
	@Autowired
	private BookRepo repository;
	
	@Autowired
    private UserRepo userRepository;
	
	public List<BookEntity> findAll() {
		return this.repository.findAll();
	}
	
	public Optional<BookEntity> findById(Long id) {
        return this.repository.findById(id);
    }
	
	public BookRepo generateBooks() {
		Random rand = new Random();
		int randNumber = rand.nextInt(400);
		BookEntity book = new BookEntity();
		book.setName("Harry Potter tome " + randNumber);
		book.setNbPage(randNumber + 10);
		book.setPrice((float) randNumber - 7);

		return this.repository.save(book);
	}
	
	public void linkBookToUser (BookEntity book, UserEntity user) {
		book = this.repository.save(book);
		user.addBook(book);
		this.userRepository.save(user);
	}
	
	public void buyAbook (BookEntity book, UserEntity userLink, UserEntity userUnlink) {
		userUnlink.deleteBook(book);
		this.userRepository.save(userUnlink);
		
		userLink.addBook(book);
		this.userRepository.save(userLink);
	}
	
	public List<BookEntity> search(String name, int nbPageMin, int nbPageMax,Float priceMin ,Float priceMax){
		return repository.findByNameLikeAndNbPageBetweenAndPriceBetween("%" + name + "%", nbPageMin, nbPageMax, priceMin, priceMax );
	}
}