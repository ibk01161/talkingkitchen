package net.lnno2.talkingkitchen.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UploadFileUtils {
	
	@Value("${file.path}")
	private String uploadPath;
	
	// 업로드 폴더 생성
	public String makeDir() {
		
		log.info("업로드 폴더 생성....");
		log.info("uploadPath : " + uploadPath);
		
		// 날짜 폴더 만들기
		Calendar cal = Calendar.getInstance();
		String datePath = "";
		
		String year =  new DecimalFormat("0000").format(cal.get(Calendar.YEAR));
		String month = new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String date = new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		datePath = year + month + date;
		
		String filePath = uploadPath + datePath;
		//String filePath = "C:/sts-4-4.8.0.RELEASE/workspace_talkingkitchen/talkingkitchen/upload/" + datePath;
		
		log.info("최종 filePath : " + filePath);
		
		File dirPath = new File(filePath);
		
		if (!dirPath.exists()) {
			log.info("폴더없으면..");
			dirPath.mkdirs();
		}
		
		return filePath;
		
	}
	
}
