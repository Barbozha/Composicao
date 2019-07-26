package Entidades;

import java.util.Date;

public class Contratos {
	private Date data;
	private Double valorhora;
	private int horas;
	
	public Contratos() {
		
	}
	
	public Contratos(Date data, Double valorhora, int horas) {
		this.data = data;
		this.valorhora = valorhora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValorhora() {
		return valorhora;
	}
	public void setValorhora(double valorhora) {
		this.valorhora = valorhora;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public double totalValor() {
		return getValorhora() * getHoras();
	}
	
}
