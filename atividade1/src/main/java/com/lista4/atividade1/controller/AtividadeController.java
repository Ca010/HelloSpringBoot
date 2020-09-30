package com.lista4.atividade1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista4")
public class AtividadeController {
	
	@GetMapping("/atividade1")
	public String lista4() {
		return "Nesta atividade eu tive a mentalidade de persistência e a habilidade de atenção ao detalhe";
	}
}




