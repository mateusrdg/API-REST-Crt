package br.com.crtsistemas.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {
	@Id
	@Column(name = "proid")
	private Integer id;
	@Column(name = "pronome")
	private String nome;
	@Column(name = "proreferencia")
	private String referencia;
	@Column(name = "provalorvenda")
	private BigDecimal valorVenda;

	@JsonIgnore
	@Transient
	private List<ItemPedido> itens = new ArrayList<>();

	public Produto() {
	}

	public Produto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

}
