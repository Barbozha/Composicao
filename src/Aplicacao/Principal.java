package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import Entidades.Contratos;
import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enun.Nivel;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("----------------------------------------------------------");
		System.out.println("                      DADOS DO DEPARTAMENTO               ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Digite o nome do Departamento: ");
		String dep = ler.nextLine();
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("                      DADOS DO TRABALHADOR                ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Digite o nome do Funcion�rio: ");
		String nome = ler.nextLine();
		System.out.println("");
		System.out.print("Digite o n�vel:");
		String nivel = ler.nextLine();
		System.out.println("");
		System.out.println("Digite o sal�rio base: ");
		double basesalario = ler.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, basesalario, Nivel.valueOf(nivel), new Departamento(dep));
		
		System.out.print("Quantos contratos tem este trabalhador? ");
		int qtdcontrato = ler.nextInt();
		System.out.println("");
		for(int i = 1 ; i <= qtdcontrato ; i ++) {
			System.out.println("Digite a data do contrato #"+i+": ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contratodata = sdf.parse(ler.next());
			System.out.println("");
			System.out.print("Digite o valor da hora trabalhada: ");
			double vahora = ler.nextDouble();
			System.out.println("");
			System.out.print("Digite a dura��o do contrato: ");
			int horas = ler.nextInt();
			Contratos contrato = new Contratos(contratodata, vahora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		System.out.println("");
		System.out.print("Entra com o m�s e ano (MM/YYYY) para calcular o sal�rio:");
		String meseano = ler.next();
		int me = Integer.parseInt(meseano.substring(0, 2));
		int an = Integer.parseInt(meseano.substring(3));
		
		System.out.println("Nome: "+trabalhador.getNome());
		// Eu acesso o objeto departamento e depois e acesso o nome do departamento
		System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
		System.out.println("Sal�rio para  M�s: "+ meseano+" : "+String.format("%.2f", trabalhador.calculaValoresContratos(an, me)));
		System.out.println("");
		
		ler.close();
	}

}
