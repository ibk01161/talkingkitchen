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
	private String setpContent;
	private int stepTime;
	private long recNo;
	
	private MultipartFile stepImg;
	
}
