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

import com.minha.loja.de.games.model.CategoriaModel;
import com.minha.loja.de.games.repository.CategoriaRepository;

@RestController
public class CategoriaController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private CategoriaRepository repository;

	// puxa do banco de dados
	@GetMapping("/categorias")
	public List<CategoriaModel> pegarTodos() {
		
		//achar tudo dentro do repository
		return repository.findAllCategoriaModel();
	}
	//requerer a respostas
	@PostMapping("/categorias")
	public CategoriaModel criar (@RequestBody CategoriaModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping ("/categorias/id/{id}")
	public Optional<CategoriaModel> buscarPorNome(@PathVariable Long id){
		return repository.findById(id);
	}
	@GetMapping ("/categorias/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> buscarPorDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PutMapping("/categorias/{id}")
	public CategoriaModel atualizar (@PathVariable Long id, @RequestBody CategoriaModel model) {
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