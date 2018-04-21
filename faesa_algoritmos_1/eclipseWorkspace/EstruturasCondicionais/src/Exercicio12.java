// Importa Scanner
import java.util.Scanner;

public class Exercicio12 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double horasTrabalhadas = 0;
		double valorDaHora = 0;
		double salarioBruto = 0;
		double percentualIRRF = 0;
		double valorIRRF = 0;
		double percentualSindicato = 0.03;
		double valorSindicato = 0;
		double percentualFGTS = 0.11;
		double valorFGTS = 0;
		double percentualINSS = 0.10;
		double valorINSS = 0;
		double salarioLiquido = 0;
				
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o número de horas trabalhadas: ");
				horasTrabalhadas = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Pega segundo número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o valor por hora: ");
				valorDaHora = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento:
		
		// Calcula salário bruto
		salarioBruto = horasTrabalhadas * valorDaHora;
		
		// Calcula % de IRRF:
		if (salarioBruto > 2500) {
			percentualIRRF = 0.20;
		} else if (salarioBruto > 1500) {
			percentualIRRF = 0.10;
		} else if (salarioBruto > 900) {
			percentualIRRF = 0.05;
		} else {
			percentualIRRF = 0;
		}
		
		// Calcula valor de IRRF:
		valorIRRF = salarioBruto * percentualIRRF;
		
		// Calcula INSS:
		valorINSS = salarioBruto * percentualINSS;
		
		// Calcula FGTS:
		valorFGTS = salarioBruto * percentualFGTS;
		
		// Calcula Sindicato:
		valorSindicato = salarioBruto * percentualSindicato;
		
		// Calcula salário líquido:
		salarioLiquido = salarioBruto - valorIRRF - valorSindicato - valorINSS;
		
		// Exibe folha
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.printf("Salário Bruto (" + horasTrabalhadas + " * " + valorDaHora + "):\t\t%,10.2f\n", salarioBruto);
		System.out.println("--------------------------------------------------");
		System.out.printf("FGTS (" + percentualFGTS*100 + "%%):\t\t\t\t%,10.2f\n", valorFGTS);
		System.out.println("--------------------------------------------------");
		System.out.printf("(-) IRFF (" + percentualIRRF*100 + "%%):\t\t\t%,10.2f\n", valorIRRF);
		System.out.printf("(-) Sindicato (" + percentualSindicato*100 + "%%):\t\t\t%,10.2f\n", valorSindicato);
		System.out.printf("(-) INSS (" + percentualINSS*100 + "%%):\t\t\t%,10.2f\n", valorINSS);
		System.out.printf("    Total de descontos:\t\t\t%,10.2f\n", (valorIRRF + valorSindicato + valorINSS));
		System.out.println("--------------------------------------------------");
		System.out.printf("Salário Líquido:\t\t\t%,10.2f\n", salarioLiquido);
		System.out.println("--------------------------------------------------");
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
