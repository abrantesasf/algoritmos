// Imports
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio24 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		String decimalInteiro = "";
		String parImpar = "";
		String positivoNegativo = "";
		int escala = 0;
		BigDecimal diferenca = new BigDecimal("0");
		BigDecimal tolerancia = new BigDecimal("1E-100");
		BigDecimal zero = new BigDecimal("0");
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("0");
		BigDecimal resultado = new BigDecimal("0");
		BigDecimal divisor = new BigDecimal("2");
		byte codigo = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o número X: ");
				num1 = scan.nextBigDecimal();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega segundo número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o número Y: ");
				num2 = scan.nextBigDecimal();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}		
		
		// Pergunta a operação:
		ok = true;
		while (ok) {
			try {
				System.out.println("Os números são: X = " + num1.toString() + ", Y = " + num2.toString());
				System.out.println("Escolha uma operação matemática, conforme os códigos abaixo");
				System.out.println("   1) X + Y");
				System.out.println("   2) X - Y");
				System.out.println("   3) Y - X");
				System.out.println("   4) X * Y");
				System.out.println("   5) X / Y");
				System.out.println("   6) Y / X");
				System.out.println("Digite aqui o código (1 a 6) da operação desejada: ");
				codigo = scan.nextByte();
				if (codigo < 1 || codigo > 10) {
					System.out.println("O código informado não é válido. Informe novamente.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (codigo == 1) {
			resultado = num1.add(num2);
		} else if (codigo == 2) {
			resultado = num1.subtract(num2);
		} else if (codigo == 3) {
			resultado = num2.subtract(num1);
		} else if (codigo == 4) {
			resultado = num1.multiply(num2);
		} else if (codigo == 5) {
			if (num2.compareTo(zero) == 0) {
				System.out.println("O divisor é ZERO e, portanto a operação não pode ser feita.");
				System.exit(0);
			} else {
				resultado = num1.divide(num2, 30, RoundingMode.HALF_UP);
			}
		} else if (codigo == 6) {
			if (num1.compareTo(zero) == 0) {
				System.out.println("O divisor é ZERO e, portanto a operação não pode ser feita.");
				System.exit(0);
			} else {
				resultado = num2.divide(num1, 30, RoundingMode.HALF_UP);
			}
		}
		
		// Verifica se é decimal ou não
		diferenca = resultado.setScale(escala, RoundingMode.DOWN).subtract(resultado).abs();
		if (diferenca.compareTo(tolerancia) < 0) {
			decimalInteiro = "Inteiro";
		} else {
			decimalInteiro = "Decimal";
		}
		
		// Verifica se é positivo ou negativo
		if (resultado.compareTo(zero) == -1) {
			positivoNegativo = "Negativo";
		} else {
			positivoNegativo = "Positivo";
		}
		
		// Verifica se é par ou ímpar:
		if (resultado.remainder(divisor).compareTo(zero) != 0) {
			parImpar = "Ímpar";
		} else {
			parImpar = "Par";
		}
		
		// Frase final:
		System.out.println("O resultado é " + resultado.toString() + " (" + decimalInteiro + ", " + positivoNegativo + ", " + parImpar + ")");
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe