package net.lnno2.talkingkitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.lnno2.talkingkitchen.domain.RecipeVO;
import net.lnno2.talkingkitchen.service.RecipeService;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	// 레시피 등록 페이지
	@GetMapping("/insert")
	public void recipeInsert() {
		
		log.info("recipe insert page.......");
		
	}
	
	// 레시피 등록
	@PostMapping("/insert")
	public String recipeInsert(RecipeVO recipeVO, RedirectAttributes rttr) {
		
		log.info("recipe insert RecipeVO : " + recipeVO);
		
		try {
			recipeService.insertRecipe(recipeVO);
			recipeService.insertRecipeIngr(recipeVO);
			recipeService.insertRecipeStep(recipeVO);
			rttr.addFlashAttribute("msg", "success");			
		} catch (Exception e) {
			log.info("recipe insert error!!! : " + e.getMessage());
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:../recipe/list";
		
	}
	
	// 리스트 출력
	@GetMapping("/list")
	public void recipeList(Model model) throws Exception {
		log.info("show recipe list....");
		model.addAttribute("list", recipeService.selectRecipe());
	}

}
