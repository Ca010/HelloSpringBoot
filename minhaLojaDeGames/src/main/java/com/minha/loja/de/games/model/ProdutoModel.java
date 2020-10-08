package com.minha.loja.de.games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;
	
	@Column
	private String genero;
	
	@Column
	private float preco;
	
	@Column
	private String nome_jogo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)//mappedBy; qual tabela estamos mapeando
	@JsonIgnoreProperties("categoria")
	private List<CategoriaModel> categoria;

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getNome_jogo() {
		return nome_jogo;
	}

	public void setNome_jogo(String nome_jogo) {
		this.nome_jogo = nome_jogo;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
