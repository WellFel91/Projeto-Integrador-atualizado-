package models;

public class Client implements Comparable<Client> {
    private String nome;
    private String telefone;
    private String endereco;
    public String cpf;
    public Veiculos veiculo;

    public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String toString() {
		String profile =  "Nome: " + this.nome + "\n" +
							"Telefone: " + this.telefone + "\n" + 
							"Endereço: " + this.endereco + "\n"+
							"CPF: " + this.cpf +"\n"+
							"Veículo: " + this.veiculo;
		return profile;
    }

    public int compareTo(Client o) {
        return this.nome.compareTo(o.nome);
    }
}