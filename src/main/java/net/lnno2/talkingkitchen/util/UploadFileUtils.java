package net.lnno2.talkingkitchen.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UploadFileUtils {
	
	@Value("${file.path}")
	static String uploadPath;
	
	// 파일 업로드 메소드 (원본 파일 이름, 파일 데이터)
	public static String uploadFile(String originalName, byte[] fileData) throws IOException {
		
		log.info("파일 업로드 시작.....");
		log.info("=======================================");
		log.info("originalName : " + originalName);
		
		String savedName = originalName;
		String savedPath = makeDir();
		
		log.info("savedName : " + savedName);
		log.info("savedPath : " + savedPath);
		log.info("=======================================");
		
		File target = new File(savedPath, savedName);
		
		try {
			FileCopyUtils.copy(fileData, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("파일 업로드 끝........");
		
		return savedName;
	}
	
	
	// 업로드 폴더 생성
	public static String makeDir() {
		
		log.info("업로드 폴더 생성....");
//		log.info("uploadPath : " + uploadPath);
		
		// 날짜 폴더 만들기
		Calendar cal = Calendar.getInstance();
		String datePath = "";
		
		String year =  new DecimalFormat("0000").format(cal.get(Calendar.YEAR));
		String month = new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String date = new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		datePath = year + month + date;
		
//		String filePath = uploadPath + datePath;
		String filePath = "C:/sts-4-4.8.0.RELEASE/upload/" + datePath;
		
		log.info("최종 filePath : " + filePath);
		
		File dirPath = new File(filePath);
		
		if (!dirPath.exists()) {
			log.info("폴더없으면..");
			dirPath.mkdirs();
		}
		
		return filePath;
		
	}
	
}
