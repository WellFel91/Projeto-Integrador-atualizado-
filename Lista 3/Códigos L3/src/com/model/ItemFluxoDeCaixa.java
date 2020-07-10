package com.model;

import java.util.Date;

public class ItemFluxoDeCaixa {
	private String tipo;
	private String descricao;
	private Double valor;
	private Date dataAdesao;
	
	//Consctuctor
	public ItemFluxoDeCaixa(String tipo, String descricao, Double valor, Date dataAdesao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataAdesao = dataAdesao;
	}
	
	//Getter / Setter
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataAdesao() {
		return dataAdesao;
	}
	
	@Override
	public String toString() {
		String fluxoDeCaixa =
				"Tipo: " + this.getTipo() + "\n" + 
				"Descricao: " + this.getDescricao() + "\n" +
				"Valor: " + this.getValor() + "\n";
		return fluxoDeCaixa;
	};
}
