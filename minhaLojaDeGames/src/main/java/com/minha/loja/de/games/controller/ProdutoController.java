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

import com.minha.loja.de.games.model.ProdutoModel;
import com.minha.loja.de.games.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	//requerer a respostas
	@PostMapping
	public ProdutoModel criar (@RequestBody ProdutoModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long idProduto) {
		return repository.findById(idProduto).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping ("produtos/{titulo}")
	public ResponseEntity<List<ProdutoModel>> buscarPorTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PutMapping("/{idProduto}")
	public ProdutoModel atualizar (@PathVariable Long idProduto, @RequestBody ProdutoModel model) {
		model.setId(idProduto);
		repository.save(model);
		return model;
	}
	
	@DeleteMapping("/{idProduto}")
	public String remover(@PathVariable Long idProduto) {	
		repository.deleteById(idProduto);
	return "sucesso";
	}

}