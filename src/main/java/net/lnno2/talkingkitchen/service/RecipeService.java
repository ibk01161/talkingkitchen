package net.lnno2.talkingkitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.lnno2.talkingkitchen.domain.RecipeVO;
import net.lnno2.talkingkitchen.mapper.RecipeMapper;

@Slf4j
@Service
@Transactional
public class RecipeService {
	
	@Autowired
	private RecipeMapper recipeMapper;
	
	public void insertRecipe(RecipeVO recipeVO) throws Exception {
		recipeMapper.insertRecipe(recipeVO);
		recipeMapper.insertRecipeIngr(recipeVO);
		recipeMapper.insertRecipeStep(recipeVO);
		log.info("insert success....");
	}

	
	
}
