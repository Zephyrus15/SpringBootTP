package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BookEntity;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repository;

	public List<UserRepo> findAll() {
		return this.repository.findAll();
	}

	public void generateUsers(final Integer nb, List<RoleEntity> listRole) {
		Random rand = new Random();
		if(this.findAll().isEmpty()) {
			for (int i = 0; i < nb; i++) {
				UserEntity user = new UserEntity();
				user.setFirstname("Jean"+i);
				user.setLastname("Dubois"+i);
				RoleEntity role = listRole.get(rand.nextInt(listRole.size()));
				user.setRole(role);
				this.repository.save(user);
			}
		}
	}
	
	public ArrayList<UserEntity> getSeller(){
		ArrayList<UserEntity> users = new ArrayList<UserEntity>();
		for (UserRepo user : this.findAll()) {
			if(user.getRole().getName() == "Seller") {
				users.add(user);
			}
        }
		
		return users;
	}
	
	public List<UserEntity> getUserListBook(BookEntity book){
        List<UserEntity> result = new ArrayList<UserEntity>();
        for (UserEntity user : this.getSeller()) {
        	for (BookEntity myBook : user.getBooks()) {
        		if (myBook.getName().equals(book.getName()) && myBook.getNbPage() == book.getNbPage() && myBook.getPrice().equals(book .getPrice())) {
        			System.out.println("Good");
        			result.add(user);
				}
			}
        }

        return result;
    }
	
	public Optional<UserRepo> findById(Long id) {
        return this.repository.findById(id);
    }
}