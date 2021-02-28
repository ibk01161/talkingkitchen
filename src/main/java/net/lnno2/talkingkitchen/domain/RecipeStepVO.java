package net.lnno2.talkingkitchen.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RecipeStepVO")
public class RecipeStepVO {

	private int stepNo;
	private String stepContent;
	private int stepTime;
	private long recNo;
	
	private MultipartFile stepImg;
	
	// 레시피 스탭 이미지를 가져오기 위해
	private AttachVO attachVo;
	
}
