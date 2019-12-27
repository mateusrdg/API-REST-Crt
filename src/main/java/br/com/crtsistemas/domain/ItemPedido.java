package br.com.crtsistemas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ItemPedido")
@Table(name = "itenspedido")
public class ItemPedido {
	@Id
	@Column(name = "ipdid")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "pedid")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "proid")
	private Produto produto;
	
	@Column(name = "ipdvalor")
	private BigDecimal valor;

	private ItemPedido() {
	}

	private ItemPedido(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
