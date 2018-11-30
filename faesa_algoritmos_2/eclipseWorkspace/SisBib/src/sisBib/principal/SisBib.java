package sisBib.principal;

import java.io.IOException;
// Importação de bibliotecas
import java.util.Scanner;

import sisBib.db.*;
import sisBib.principal.*;
import sisBib.util.*;

/**
 * <p>A classe SisBib é a classe principal do sistema de biblioteca.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-23
 */
public class SisBib {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	private static Scanner         scan       = new Scanner(System.in);
	private static VetorDeUsuarios usuarios;
	private static boolean         usuariosOK = false;
	private static CSV             csv        = new CSV();

	/**
	 * <p><b>main(String[] args)</b></p>
	 * <p>Método MAIN do SisBib.</p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.println("--------------- MENU DE OPÇÕES ---------------\n" +
		                       "9 - Sair\n" +
		                       "----------------------------------------------\n"+
					           "Informe sua opção: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 9:
				System.out.println("\nSaindo do SisBib!");
				System.out.println("Moriturus te saluto!");
				break;
			default:
				System.out.println("\nOpção inválida, tente novamente:\n");
				try {
					csv.lerCSVfuncionarios("/home/abrantesasf/teste.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			
		} while (opcao != 9);

	} // Fecha método main

}
