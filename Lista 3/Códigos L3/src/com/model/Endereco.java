package com.model;

public class Endereco {
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	
	//constructor
	public Endereco(String cep, String bairro, String rua, String numero) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	//Getter / Setter
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
