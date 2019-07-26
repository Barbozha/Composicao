package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entidades.enun.Nivel;

public class Trabalhador {
	//Atributos b�sicos
	private String nome;
	private Double salariobase;
	private Nivel nivel;
	
	//Associa��es
	//Fa�o a associa��o com a classe Departamento
	private Departamento departamento;
	
	//Fa�o a minha associa��o com a Classe de Contratos, que s�o no m�nimo 1 ou v�rios contratos
	private List<Contratos> contratos = new ArrayList<>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, Double salariobase, Nivel nivel, Departamento departamento) {
		this.nome = nome;
		this.salariobase = salariobase;
		this.nivel = nivel;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalariobase() {
		return salariobase;
	}

	public void setSalariobase(Double salariobase) {
		this.salariobase = salariobase;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contratos> getContrados() {
		return contratos;
	}
	
	//Adiciono contrato ao trabalhador
	public void adicionarContrato(Contratos contrato) {
		contratos.add(contrato);
	}
	
	//Removo contrato do trabalhador
	public void removeContrato(Contratos contrato) {
		contratos.remove(contrato);
	}
	
	public double calculaValoresContratos(int ano, int mes) {
		double soma = this.salariobase;
		Calendar cal = Calendar.getInstance();
		for(Contratos c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma += c.totalValor();
			}
		}
		return soma;
	}
}
