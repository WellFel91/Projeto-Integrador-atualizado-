package com.model;

public class Usuario {
	private String nome;
	private String telefone;
	private Endereco endereco;
	private String email;
	private String senha;
	
	//Constructor
	public Usuario(String nome, String telefone, Endereco endereco, String email, String senha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}

	
	//Getter / Setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		String perfil =
				"Nome: " + this.getNome() + "\n" + 
		        "Email: " + this.getEmail() + "\n" +
				"Telefone: " + this.getTelefone() + "\n" + 
				"CEP: " + this.getEndereco().getCep() + "\n" + 
				"Rua: " + this.getEndereco().getRua() + "\n" +
				"Bairro: " + this.getEndereco().getBairro() + "\n" + 
				"Numero: " + this.getEndereco().getNumero() + "\n";
		return perfil;
	};
}
