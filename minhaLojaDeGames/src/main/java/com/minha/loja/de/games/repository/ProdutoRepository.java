package com.minha.loja.de.games.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.minha.loja.de.games.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	List<ProdutoModel> findAllProdutoModel();

	public List<ProdutoModel> findAllByDescricaoContainingIgnoreCase(String descricao);

}
