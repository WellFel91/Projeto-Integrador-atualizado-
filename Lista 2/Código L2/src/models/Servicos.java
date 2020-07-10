package models;

public class Servicos {
	private String data;
	private String relatorios;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getRelatorios() {
		return relatorios;
	}
	public void setRelatorios(String relatorios) {
		this.relatorios = relatorios;
	}
	
	public String toString() {
		String profile =  "Data: " + this.data + "\n" +
							"Serviços: " + this.relatorios;
		
		return profile;
	}
}
