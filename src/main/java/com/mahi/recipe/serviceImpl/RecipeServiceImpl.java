package com.mahi.recipe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.recipe.entity.Recipe;
import com.mahi.recipe.repository.IRecipeRepository;
import com.mahi.recipe.service.IRecipeService;

@Service
public class RecipeServiceImpl implements IRecipeService{

	@Autowired
	private IRecipeRepository recipeRepository;
	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
		
	}

	@Override
	public void deleteRecipe(int recipeId) {
		recipeRepository.deleteById(recipeId);
	}

	@Override
	public Recipe getRecipeDetails(int recipeId) {
		return recipeRepository.findById(recipeId).get();
	}

}
