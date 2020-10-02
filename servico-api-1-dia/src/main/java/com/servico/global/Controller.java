package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	// ela faz uniao/injecao do jpa, é obrigatorio
	@Autowired
	private ServicoRepository repository;

	// puxa do banco de dados
	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos() {
		
		//achar tudo dentro do repository
		return repository.findAll();
	}
	//requerer a respostas
	@PostMapping("/servicos")
	public ServicoModel criar (@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping ("/servicos/nome/{nome}")
	public List<ServicoModel> buscarPorNome(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	@PutMapping("/servicos/{id}")
	public ServicoModel atualizar (@PathVariable Long id, @RequestBody ServicoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}
}
