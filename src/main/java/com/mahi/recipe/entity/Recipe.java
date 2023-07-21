package com.mahi.recipe.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipeId;
	
	private String name;
	
	@JsonFormat
	private LocalDate created;
	
	private boolean veg;
	
	private int servings;
	
	private String instructions;
	
	@OneToMany
	@JoinColumn(name="RI_fk",referencedColumnName = "recipeId")
	private List<Ingredients> ingredients;

	
	public Recipe() {
		super();
	}
	

	public Recipe(String name, LocalDate created, boolean veg, int servings, String instructions,
			List<Ingredients> ingredients) {
		super();
		this.name = name;
		this.created = created;
		this.veg = veg;
		this.servings = servings;
		this.instructions = instructions;
		this.ingredients = ingredients;
	}


	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	
}
