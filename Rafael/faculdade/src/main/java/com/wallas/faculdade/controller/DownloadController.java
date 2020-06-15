package com.wallas.faculdade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.wallas.faculdade.model.Model;
import com.wallas.faculdade.model.View;
import com.wallas.faculdade.repository.Repository;

@RestController
public class DownloadController {
	
	@Autowired
	Repository repository;

    @JsonView(View.FileInfo.class)
	@GetMapping("/api/file/all")
	public List<Model> getListFiles() {
		return repository.findAll();
	}
    
	@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<Model> arquivoDoRepositorio = repository.findById(id);
		
		if(arquivoDoRepositorio.isPresent()) {
			Model arquivoSalvo = arquivoDoRepositorio.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivoSalvo.getNome() + "\"")
					.body(arquivoSalvo.getTamanho());	
		}
		
		return ResponseEntity.status(404).body(null);
	}

}
