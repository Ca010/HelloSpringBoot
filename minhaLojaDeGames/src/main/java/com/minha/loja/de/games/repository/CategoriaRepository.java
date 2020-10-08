package com.minha.loja.de.games.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.minha.loja.de.games.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	List<CategoriaModel> findAllCategoriaModel();

	public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase (String descricao); 


	}
