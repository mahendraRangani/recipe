package com.mahi.recipe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.recipe.entity.Recipe;
import com.mahi.recipe.exception.RecipeNotFoundException;
import com.mahi.recipe.repository.IRecipeRepository;
import com.mahi.recipe.service.IRecipeService;

@RestController
public class RecipeController {

	@Autowired
	private IRecipeService recipeService;
	
	@Autowired
	private IRecipeRepository recipeRepository;
	
	@GetMapping("/allrecipes")
	public ResponseEntity<?> getAllRecipes() throws RecipeNotFoundException {
		if (!recipeRepository.findAll().isEmpty()) {
			return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
		} else {
			throw new RecipeNotFoundException("No recipes in the list");
		}

	}

	@PostMapping("/addrecipes")
	public ResponseEntity<?> createdAllRecipes(@RequestBody Recipe recipe) throws RecipeNotFoundException {
		Optional<Recipe> opt = recipeRepository.findByName(recipe.getName());

		if (!opt.isPresent()) {
			recipeService.saveRecipe(recipe);
			return new ResponseEntity<>("Recipe is add in the list", HttpStatus.CREATED);
		
		} else {
			throw new RecipeNotFoundException("Recipes is already created");
		}

	}
	 
	@PutMapping("/updateRecipe/{recipeId}")
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe) throws RecipeNotFoundException{
		if(recipeRepository.existsById(recipe.getRecipeId())) {
			
			recipeService.updateRecipe(recipe);
			
			return new ResponseEntity<> ("RecipeId"+recipe.getRecipeId()+"updated Sucessfully",HttpStatus.ACCEPTED);
		}else {
			throw new RecipeNotFoundException("RecipeId"+recipe.getRecipeId()+"No add in the list");
		}
	}
	@DeleteMapping("/deleteRecipe/{recipeId}")
	public ResponseEntity<?> deleteRecipes(@PathVariable ("recipeId")int recipeId) throws RecipeNotFoundException {
		Optional<Recipe> opt = recipeRepository.findById(recipeId);

		if (!opt.isPresent()) {
			throw new RecipeNotFoundException("RecipeId"+recipeId+ "No  add in the list");

		} else {
			recipeService.deleteRecipe(recipeId);
			return new ResponseEntity<>("RecipeId"+recipeId+"deleted successfully", HttpStatus.CREATED);
		}

	}
	 @GetMapping("/getrecipe/{recipeId}")
	    public ResponseEntity<?> getRecipeDetails(@PathVariable int recipeId) throws RecipeNotFoundException {
			Optional<Recipe> opt = recipeRepository.findById(recipeId);
			if(!opt.isPresent()) {
				  throw  new RecipeNotFoundException("Recipe"+recipeId+   " No  add in the list");

			}else {
				 return new ResponseEntity(recipeService.getRecipeDetails(recipeId),HttpStatus.OK);
				 
			}
	       
	    }
}




















































































