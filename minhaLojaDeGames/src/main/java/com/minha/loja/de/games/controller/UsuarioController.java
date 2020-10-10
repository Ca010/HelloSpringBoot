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

import com.minha.loja.de.games.model.UsuarioModel;
import com.minha.loja.de.games.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private UsuarioRepository repository;

	// puxa do banco de dados
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// requerer a respostas
	@PostMapping("/usuarios")
	public UsuarioModel criar(@RequestBody UsuarioModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/categorias/{id}")
	public UsuarioModel atualizar(@PathVariable Long id, @RequestBody UsuarioModel model) {
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