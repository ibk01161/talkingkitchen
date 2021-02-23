package net.lnno2.talkingkitchen.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RecipeVO")
public class RecipeVO {

	private long recNo;
	private String recTitle;
	private String recIntro;
	private String recCategory1;
	private String recCategory2;
	private String recCategory3;
	private String recCategory4;
	private String recPortion;
	private String recTime;
	private String recLevel;
	private double recRating;
	private int recReadCnt;
	private int recScrapCnt;
	private int recGood;
	private int recBad;
	private Date regDate;
	private Date modDate;
	
	private MultipartFile recImg;
	
	private List<RecipeIngredientVO> recipeIngrVoList;
	private List<RecipeStepVO> recipeStepVoList;
	
	private AttachVO attachVO;
}
