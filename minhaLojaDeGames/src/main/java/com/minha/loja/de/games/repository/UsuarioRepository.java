package com.minha.loja.de.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minha.loja.de.games.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	List<UsuarioModel> findAllCategoriaModel();

	public List<UsuarioModel> findAllByDescricaoContainingIgnoreCase(String descricao);

	List<UsuarioModel> findAllUsuarioModel();

}
