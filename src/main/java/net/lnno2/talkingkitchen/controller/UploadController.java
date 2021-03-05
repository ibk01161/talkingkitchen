package net.lnno2.talkingkitchen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	@RequestMapping("/displayFile")
	public void displayFile(String fileName, HttpServletResponse response) throws Exception {
		
//		log.info("displayFile......");
//		log.info("displayFile_fileName : " + fileName);
		
		File file = new File(fileName);
		response.setContentLength((int) file.length());
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader("Content-Disposition", "attachment;filename='" + URLEncoder.encode(fileName, "UTF-8") + "'");
		
//		log.info("displayFile_response : " + response.toString());
//		log.info("displayFile_response_status : " + response.getStatus());
//		log.info("displayFile_response_contentType : " + response.getContentType());
		
		InputStream is = new FileInputStream(fileName);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
		os.flush();
		
		if (os != null) {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
