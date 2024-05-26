package com.mycompany.texpress.daoImp;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EnviarEmailmImp {

	
	@Autowired
	private JavaMailSender javamailsender;
	
	 public void sendEmail(String subject, String content, String email, String fileName ,MultipartFile multipartFile) {

	        MimeMessage msg = javamailsender.createMimeMessage();
	        try {
	        	
	            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	            

	            helper.setTo(email);
	            helper.setSubject(subject);
	            helper.setText(content, true);
	            
	         
	    		
	    		if (!multipartFile.isEmpty()) {
	    		
	    			
	    			InputStreamSource source = new InputStreamSource() {
	    				
	    				@Override
	    				public InputStream getInputStream() throws IOException {
	    					return multipartFile.getInputStream();
	    				}
	    			};
	    			
	    			helper.addAttachment(fileName, source);
	    		}
	    		
	 

	            javamailsender.send(msg);
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
