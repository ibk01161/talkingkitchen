package net.lnno2.talkingkitchen.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RecipeIngredientVO")
public class RecipeIngredientVO {
	
	private long recNo;
	private String ingrCode;
	private String recIngrQnt;
	//private String ingrSub;

}
