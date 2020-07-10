package com.view;

import java.util.Scanner;

import com.controller.Controller;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();
	
	public void telaInicial() {
		System.out.println("0- Sair");
		System.out.println("1- Cadastrar usu�rio");
		System.out.println("2- Fazer login");
		System.out.println("3- Cadastrar Entrada/Sa�da fluxo de caixa");
		System.out.println("4- Relat�rios de fluxo de caixa");
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
		
		System.out.println("N�mero: ");
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
		  System.out.println("Tipo (entrada/sa�da): ");
		  String tipo = scanner.next();
		  if(tipo.equals("entrada")) {
			  this.opcoesEntrada();
			  aux = scanner.nextInt();
			  if (aux==1) {
				  descricao = "Sal�rio" ;
			  }
			  else if (aux==2) {
				  descricao = "Receita de vendas" ;
			  }
			  if (aux==3) {
				  descricao = "Investimentos" ;
			  }
		  }
	  
		  if(tipo.equals("sa�da")) {
			  this.opcoesSaida();
			  aux = scanner.nextInt();
			  if (aux==1) {
				  descricao = "Energia El�trica" ;
			  }
			  else if (aux==2) {
				  descricao = "G�s" ;
			  }
			  if (aux==3) {
				  descricao = "Alimenta��o" ;
			  }  
			  if (aux==4) {
				  descricao = "Combust�vel e/ou locomo��o" ;
			  }
			  if (aux==5) {
				  System.out.println("Digite a descri��o da saida:");
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
		System.out.println("1- Sal�rio");
		System.out.println("2- Receita de vendas");
		System.out.println("3- Investimentos");	
	}
	public void opcoesSaida() {
		System.out.println("1- Energia El�trica");
		System.out.println("2- G�s");
		System.out.println("3- Alimenta��o");
		System.out.println("4- Combust�vel e/ou locomo��o");
		System.out.println("5- Outros");
	}
	
	public void relatoriosFluxoDeCaixa() {
		if(controller.estaLogado()) {
			
			System.out.println("N� do m�s do relat�rio: ");
			int inputMes = scanner.nextInt();
			
			System.out.println("N� da semana do relat�rio: ");
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