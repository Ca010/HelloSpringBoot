package com.minha.loja.de.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minha.loja.de.games.model.ProdutoModel;
import com.minha.loja.de.games.repository.ProdutoRepository;


@RestController
public class ProdutoController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private ProdutoRepository repository;

	// puxa do banco de dados
	@GetMapping("/produtos")
	public List<ProdutoModel> pegarTodos() {
		
		//achar tudo dentro do repository
		return repository.findAllProdutoModel();
	}
	//requerer a respostas
	@PostMapping("/produtos")
	public ProdutoModel criar (@RequestBody ProdutoModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping ("/produtos/id/{id}")
	public Optional<ProdutoModel> buscarPorNome(@PathVariable Long id){
		return repository.findById(id);
	}
	@GetMapping ("/produtos/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> buscarPorDescricao(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	@PutMapping("/categorias/{id}")
	public ProdutoModel atualizar (@PathVariable Long id, @RequestBody ProdutoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}
	
	@DeleteMapping("/categorias/{id}")
	public String remover(@PathVariable Long id) {	
		repository.deleteById(id);
	return "sucesso";
	}

}