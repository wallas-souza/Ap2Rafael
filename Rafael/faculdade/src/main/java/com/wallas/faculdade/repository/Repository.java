package com.wallas.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wallas.faculdade.model.Model;

@Transactional
public interface Repository extends JpaRepository<Model, Long> {
	public Model findByNome(String nome);
}
