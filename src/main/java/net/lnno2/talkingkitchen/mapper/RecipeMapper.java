package net.lnno2.talkingkitchen.mapper;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import net.lnno2.talkingkitchen.domain.RecipeVO;

@Repository
public interface RecipeMapper {

	void insertRecipe(RecipeVO recipeVO) throws SQLException;

	void insertRecipeIngr(RecipeVO recipeVO) throws SQLException;

	void insertRecipeStep(RecipeVO recipeVO) throws SQLException;

}
