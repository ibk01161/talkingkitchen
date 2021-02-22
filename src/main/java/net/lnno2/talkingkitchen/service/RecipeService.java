package net.lnno2.talkingkitchen.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.lnno2.talkingkitchen.domain.AttachVO;
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
			log.info("RecipeService_파일 업로드......");
			recImgName = UploadFileUtils.uploadFile(recImg.getOriginalFilename(), recImg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		attachVO.setAttachName(recImgName);
		attachVO.setAttachPath(UploadFileUtils.makeDir());
		attachVO.setStepNo(0);
		
		recipeMapper.insertRecipe(recipeVO);
		recipeMapper.insertRecipeAttach(attachVO);
		//recipeMapper.insertRecipeIngr(recipeVO);
		//recipeMapper.insertRecipeStep(recipeVO);
		log.info("insert success....");
	}

	
	
}
