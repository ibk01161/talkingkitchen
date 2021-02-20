package net.lnno2.talkingkitchen.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("AttachVO")
public class AttachVO {
	
	private long attachNo;
	private String attachName;
	private String attachPath;
	private long recNo;
	private long stepNo;
	private Date regDate;
	private Date modDate;
	
}
