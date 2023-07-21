package com.mahi.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String ingredients;

	public Ingredients() {
		super();
	}

	public Ingredients(int id, String ingredients) {
		super();
		this.id = id;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
