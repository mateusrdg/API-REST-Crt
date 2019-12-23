package br.com.crtsistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
	@Id
	@Column(name = "cliid")
	private Integer id;
	@Column(name = "clinome")
	private String nome;
	
	private Cliente () {
		
	}
	
	private Cliente (Integer id) {
		this.id = id;
	}
	
	public Integer getId () {
		return this.id;
	}
	
	public void setId (Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
