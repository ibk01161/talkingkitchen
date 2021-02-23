package net.lnno2.talkingkitchen.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.lnno2.talkingkitchen.domain.AttachVO;
import net.lnno2.talkingkitchen.domain.RecipeStepVO;
import net.lnno2.talkingkitchen.domain.RecipeVO;
import net.lnno2.talkingkitchen.mapper.RecipeMapper;
import net.lnno2.talkingkitchen.util.UploadFileUtils;

@Slf4j
@Service
@Transactional
public class RecipeService {
	
	@Autowired
	private RecipeMapper recipeMapper;
	
	public void insertRecipe(RecipeVO recipeVO) throws Exception {
		
		AttachVO attachVO = new AttachVO();
		MultipartFile recImg = recipeVO.getRecImg();
		String recImgName = "";
		
		try {
			log.info("RecipeService_레시피 파일 업로드......");
			recImgName = UploadFileUtils.uploadFile(recImg.getOriginalFilename(), recImg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		attachVO.setAttachName(recImgName);
		attachVO.setAttachPath(UploadFileUtils.makeDir());
		attachVO.setStepNo(0);
		
		recipeMapper.insertRecipe(recipeVO);
		recipeMapper.insertRecipeAttach(attachVO);
		log.info("Recipe insert success....");
	}

	public void insertRecipeIngr(RecipeVO recipeVO) throws Exception {
		recipeMapper.insertRecipeIngr(recipeVO);
		log.info("RecipeIngr insert success.....");
	}

	public void insertRecipeStep(RecipeVO recipeVO) throws Exception {
		
		log.info("STEP INSERT, recipeVO : " + recipeVO);
		
		AttachVO attachVO = new AttachVO();
		
		try {
			log.info("RecipeService_레시피 스탭 파일 업로드......");
			
			for (RecipeStepVO vo : recipeVO.getRecipeStepVoList()) {
				log.info("레시피 스탭 파일 업로드 시작...");
				log.info("insertRecipeStep_recipeVO.getRecipeStepVoList() : " + recipeVO.getRecipeStepVoList());
				log.info("insertRecipeStep_Recipe Step VO : " + vo);
				MultipartFile stepImg = vo.getStepImg();
				String stepImgName = "";
				stepImgName = UploadFileUtils.uploadFile(stepImg.getOriginalFilename(), stepImg.getBytes());
				
				log.info("insertRecipeStep_stepImgName : " + stepImgName);
				
				attachVO.setAttachName(stepImgName);
				attachVO.setAttachPath(UploadFileUtils.makeDir());
				attachVO.setStepNo(vo.getStepNo());
			}
			
			recipeMapper.insertRecipeStep(recipeVO);
			recipeMapper.insertRecipeAttach(attachVO);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		log.info("RecipeStep insert success.....");
	}

	
	
}
