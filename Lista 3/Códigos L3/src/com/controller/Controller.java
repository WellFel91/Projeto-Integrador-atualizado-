package com.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.model.Endereco;
import com.model.ItemFluxoDeCaixa;
import com.model.Usuario;

public class Controller {
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	ArrayList<ItemFluxoDeCaixa> listaItensFluxoDeCaixa = new ArrayList<ItemFluxoDeCaixa>();
	boolean logado=false;
	
	public void cadastrarUsuario(
			String nome,
			String email,
			String senha,
			String telefone,
			String cep,
			String bairro,
			String rua,
			String numero) {
		
		Endereco endereco = new Endereco(cep, bairro, rua, numero);
		
		Usuario usuario = new Usuario(nome, telefone,endereco, email, senha);
		listaUsuarios.add(usuario);
		
	}
	public boolean fazerLogin(String email, String senha) {
		for (Usuario usuario: listaUsuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				logado = true;
			}
		}
		return logado;
	}
	
	public boolean estaLogado() {
		return logado;
	}
	
	public void cadastrarEntradaSaida(String tipo, String descricao, Double valor) {
		
		Calendar hoje = Calendar.getInstance();
		Date dataAdesao = hoje.getTime();
		
		ItemFluxoDeCaixa itemFluxoDeCaixa = new ItemFluxoDeCaixa(tipo, descricao, valor, dataAdesao);
		listaItensFluxoDeCaixa.add(itemFluxoDeCaixa);
	}
	
	public void relatoriosFluxoDeCaixa(int inputMes, int inputSemana) {
		Calendar calendar = Calendar.getInstance();
		int cont = 0;
		
		if (listaItensFluxoDeCaixa.size()==0) {
			System.out.println("Não existem itens");
		}
		for (ItemFluxoDeCaixa item: listaItensFluxoDeCaixa) {
			calendar.setTime(item.getDataAdesao());
			
			int itemMes = calendar.get(Calendar.MONTH);
			int itemSemana = calendar.get(Calendar.WEEK_OF_MONTH);
			if ((itemMes + 1) == inputMes && inputSemana == itemSemana) {
				System.out.println(item);
				cont++;						
			}
			if (cont == 0) {
				System.out.println("Não existem itens cadastrados para o mês e semana do mês escolhido");
			}
		}
		
		
	}
	public Double calcularFluxoDeCaixa() {
		Double totalSaidas = 0.0;
		Double totalEntradas = 0.0;
		for (ItemFluxoDeCaixa item: listaItensFluxoDeCaixa) {
			if(item.getTipo().equals("entrada")) {
				totalEntradas = totalEntradas + item.getValor();
			}
			else if(item.getTipo().equals("saída")) {
				totalSaidas = totalSaidas + item.getValor();
			}
		} 
		return totalEntradas - totalSaidas;
	}
}
