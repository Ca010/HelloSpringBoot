package com.minha.loja.de.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minha.loja.de.games.model.CategoriaModel;
import com.minha.loja.de.games.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private CategoriaRepository repository;
	
	//puxa do banco de dados
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());//acha tudo dentro do repository
	}

	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long idCategoria) {
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping ("/categorias/{descricao}")
	public ResponseEntity<List<CategoriaModel>> buscarPorDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	//requerer a respostas
		@PostMapping
		public CategoriaModel criar (@RequestBody CategoriaModel model) {
			repository.save(model);
			return model;
		}
	@PutMapping("/{idCategoria}")
	public CategoriaModel atualizar (@PathVariable Long idCategoria, @RequestBody CategoriaModel model) {
		model.setIdCategoria(idCategoria);
		repository.save(model);
		return model;
	}
	
	@DeleteMapping("/{idCategoria}")
	public String remover(@PathVariable Long idCategoria) {	
		repository.deleteById(idCategoria);
	return "sucesso";
	}

}