package net.lnno2.talkingkitchen.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RecipeVO")
public class RecipeVO implements Serializable {

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
	private String recImgPath;
	private double recRating;
	private int recReadCnt;
	private int recScrapCnt;
	private int recGood;
	private int recBad;
	private Date regDate;
	private Date modDate;
	
}
