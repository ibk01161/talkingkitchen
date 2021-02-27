package net.lnno2.talkingkitchen.mapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.lnno2.talkingkitchen.domain.AttachVO;
import net.lnno2.talkingkitchen.domain.RecipeIngredientVO;
import net.lnno2.talkingkitchen.domain.RecipeStepVO;
import net.lnno2.talkingkitchen.domain.RecipeVO;

@Repository
public interface RecipeMapper {

	void insertRecipe(RecipeVO recipeVO) throws SQLException;

	void insertRecipeAttach(AttachVO attachVO);
	
	void insertRecipeIngr(RecipeVO recipeVO) throws SQLException;

	void insertRecipeStep(RecipeVO recipeVO) throws SQLException;

	List<RecipeVO> getRecipeList() throws SQLException;

	RecipeVO getRecipeDetail(long recNo);

	List<RecipeIngredientVO> getIngrDetail(long recNo);

	List<RecipeStepVO> getStepDetail(long recNo);

	List<AttachVO> getAttachInfo(long recNo);


	

}
