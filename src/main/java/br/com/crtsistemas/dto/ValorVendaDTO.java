package br.com.crtsistemas.dto;

import java.math.BigDecimal;

public class ValorVendaDTO {
	
	private BigDecimal valor;

	public ValorVendaDTO () {
	}
	
	public ValorVendaDTO (BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
