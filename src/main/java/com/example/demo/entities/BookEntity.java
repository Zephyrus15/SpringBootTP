package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class BookEntity extends Enti{
	
	private String name;
	private int nbPage;
	private Float price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}