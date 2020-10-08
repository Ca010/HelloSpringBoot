package com.minha.loja.de.games.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categoria;
	
	@Column
	private String marca;
		
	@Column
	private String descricao;
	
	@Column
	private Long fk_id_tema;

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getFk_id_tema() {
		return fk_id_tema;
	}

	public void setFk_id_tema(Long fk_id_tema) {
		this.fk_id_tema = fk_id_tema;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
