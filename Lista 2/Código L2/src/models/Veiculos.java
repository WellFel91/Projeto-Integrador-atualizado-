package models;

import java.util.List;
import java.util.ArrayList;

public class Veiculos implements Comparable<Veiculos> {
	public String proprietario;
	private String placa;
	private String modelo;
	private int ano;
	private int valor;
	public List<Servicos> servicos = new ArrayList<Servicos>();
	
	
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String toString() {
		String profile =   "\n" +
							"Placa: " + this.placa + "\n" + 
							"Modelo: " + this.modelo + "\n"+
							"Ano: " + this.ano +"\n"+
							"Valor: " + this.valor;
		
		return profile;
	}
	
	public int compareTo(Veiculos o) {
        return this.proprietario.compareTo(o.proprietario);
    }
}
