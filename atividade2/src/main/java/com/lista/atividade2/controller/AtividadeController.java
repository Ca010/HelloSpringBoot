package com.lista.atividade2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista")
public class AtividadeController {
	
	@GetMapping("/atividade2")
	public String hello() {
		return "Conseguir criar APIs";
	}

}




