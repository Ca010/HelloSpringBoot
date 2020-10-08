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

import com.minha.loja.de.games.model.UsuarioModel;
import com.minha.loja.de.games.repository.UsuarioRepository;


@RestController
public class UsuarioController {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private UsuarioRepository repository;

	// puxa do banco de dados
	@GetMapping("/usuarios")
	public List<UsuarioModel> pegarTodos() {
		
		//achar tudo dentro do repository
		return repository.findAllUsuarioModel();
	}
	//requerer a respostas
	@PostMapping("/usuarios")
	public UsuarioModel criar (@RequestBody UsuarioModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping ("/usuarios/id/{id}")
	public Optional<UsuarioModel> buscarPorNome(@PathVariable Long id){
		return repository.findById(id);
	}

	@PutMapping("/categorias/{id}")
	public UsuarioModel atualizar (@PathVariable Long id, @RequestBody UsuarioModel model) {
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