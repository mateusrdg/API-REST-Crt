package br.com.crtsistemas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
	@Id
	@Column(name = "cliid")
	private Integer id;
	@Column(name = "clinome")
	private String nome;
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente () {
	}
	
	public Cliente (Integer id) {
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
