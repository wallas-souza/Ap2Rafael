package com.wallas.faculdade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wallas.faculdade.model.Model;
import com.wallas.faculdade.repository.Repository;

@RestController
public class UploadController {
	
	@Autowired
	Repository arquivoRepository;
	
	@PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
    	try {
	    	Model filemode = new Model(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    	arquivoRepository.save(filemode);
	    	return "Upload concluído!";
		} catch (	Exception e) {
			return "Erro ao fazer upload!Verifique se o tamanho é maior que 500kb.";
		}    
    }
}
