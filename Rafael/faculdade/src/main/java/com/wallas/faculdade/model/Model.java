package com.wallas.faculdade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import com.wallas.faculdade.model.View;

@Entity
@Table(name="file_model")
public class Model {

	@Id
	@GeneratedValue
    @Column(name = "id")
	@JsonView(View.FileInfo.class)
    private Long id;
	
    @Column(name = "nome")
    @JsonView(View.FileInfo.class)
	private String nome;
    
    @Column(name = "tipoArquivo")
	private String tipoArquivo;
	
	@Lob
    @Column(name="tamanho")
    private byte[] tamanho;
	
	public Model(){}
	
	public Model(String nome, String tipoArquivo, byte[] tamanho){
		this.nome = nome;
		this.tipoArquivo = tipoArquivo;
		this.tamanho = tamanho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public byte[] getTamanho() {
		return tamanho;
	}

	public void setTamanho(byte[] tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
