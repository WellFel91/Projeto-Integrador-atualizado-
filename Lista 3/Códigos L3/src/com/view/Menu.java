package com.view;

import java.util.Scanner;

import com.controller.Controller;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();
	
	public void telaInicial() {
		System.out.println("0- Sair");
		System.out.println("1- Cadastrar usuário");
		System.out.println("2- Fazer login");
		System.out.println("3- Cadastrar Entrada/Saída fluxo de caixa");
		System.out.println("4- Relatórios de fluxo de caixa");
	}
	
	public void cadastrarUsuario() {
		System.out.println("Nome: ");
		String nome = scanner.next();
		
		System.out.println("Email: ");
		String email = scanner.next();
		
		System.out.println("Senha: ");
		String senha = scanner.next();
		
		System.out.println("Telefone: ");
		String telefone = scanner.next();
		
		System.out.println("CEP: ");
		String cep = scanner.next();
		
		System.out.println("Bairro: ");
		String bairro = scanner.next();
		
		System.out.println("Rua: ");
		String rua = scanner.next();
		
		System.out.println("Número: ");
		String numero = scanner.next();
		
		controller.cadastrarUsuario(nome, email, senha, telefone, cep, bairro, rua, numero);
		System.out.println("Cadastro finalizado.");
		
	}
	
	public void fazerLogin() {
		System.out.println("Email: ");
		String email = scanner.next();
		
		System.out.println("Senha: ");
		String senha = scanner.next();
		
		controller.fazerLogin(email, senha);
		
		if (controller.estaLogado()) {
			System.out.println("Login realizado");
		}
		else {
			System.out.println("Credenciais incorretas.");
		}
	}
	
	
	public void cadastrarEntradaSaida() {
		int aux;
		String descricao = "";
		if(controller.estaLogado()) {
		  System.out.println("Tipo (entrada/saída): ");
		  String tipo = scanner.next();
		  if(tipo.equals("entrada")) {
			  this.opcoesEntrada();
			  aux = scanner.nextInt();
			  if (aux==1) {
				  descricao = "Salário" ;
			  }
			  else if (aux==2) {
				  descricao = "Receita de vendas" ;
			  }
			  if (aux==3) {
				  descricao = "Investimentos" ;
			  }
		  }
	  
		  if(tipo.equals("saída")) {
			  this.opcoesSaida();
			  aux = scanner.nextInt();
			  if (aux==1) {
				  descricao = "Energia Elétrica" ;
			  }
			  else if (aux==2) {
				  descricao = "Gás" ;
			  }
			  if (aux==3) {
				  descricao = "Alimentação" ;
			  }  
			  if (aux==4) {
				  descricao = "Combustível e/ou locomoção" ;
			  }
			  if (aux==5) {
				  System.out.println("Digite a descrição da saida:");
				  descricao = scanner.next(); ;
			  }
		  }  
	  
	  System.out.println("Valor (R$): ");
	  Double valor = scanner.nextDouble();
	  
	  controller.cadastrarEntradaSaida(tipo, descricao, valor);
	}
		else {System.out.println("Realizar login");}
	}
	public void opcoesEntrada() {
		System.out.println("1- Salário");
		System.out.println("2- Receita de vendas");
		System.out.println("3- Investimentos");	
	}
	public void opcoesSaida() {
		System.out.println("1- Energia Elétrica");
		System.out.println("2- Gás");
		System.out.println("3- Alimentação");
		System.out.println("4- Combustível e/ou locomoção");
		System.out.println("5- Outros");
	}
	
	public void relatoriosFluxoDeCaixa() {
		if(controller.estaLogado()) {
			
			System.out.println("Nº do mês do relatório: ");
			int inputMes = scanner.nextInt();
			
			System.out.println("Nº da semana do relatório: ");
			int inputSemana = scanner.nextInt();
			
			System.out.println("====Itens fluxo de caixa====");
			controller.relatoriosFluxoDeCaixa(inputMes, inputSemana);
			System.out.println("========");
			System.out.println("Total em caixa: R$" + controller.calcularFluxoDeCaixa());
	}
		else
		{
		System.out.println("Realizar login");
		}
	}
}