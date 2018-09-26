/*
 * Este programa calcula o consumo de energia de um prédio de 8 andares.
 * Os consumos dos apartamentos, em cada andar, são armazenados nas colunas da matriz:
 * Índice 0 = coluna A, índice 1 = coluna B, índice 2 = coluna C e índice 3 = coluna D). 
 * São 4 apartamentos por andar, um em cada coluna.
 * A opção 1 calcula o consumo por coluna.
 * A opção 2 calcula o consumo por andar.
 * A opção 3 mostra o consumo por apartamento.
 * A opção 0 finaliza o programa.
 */
import java.util.Scanner;
public class CalculaConsumoEnergia {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;// Opção do menu fiscal
		int andar,coluna;
		char col=' ';
		int qtdAndar=3, qtdCol=4; //Quantidade de andares do prédio

		//Matriz armazena na linha da matriz o consumo de cada coluna 
		double matriz[][] = new double[qtdAndar][qtdCol];//;

		//Armazena os valores de consumo em seus respectivos apartamentos
		for(int i = 0; i<matriz.length; i++)
		{
			for(int j = 0; j<matriz[i].length; j++)
			{
				switch(j)
				{
				case 0: col = 'A';
					break;
				case 1: col = 'B';
					break;
				case 2: col = 'C';
					break;
				case 3: col = 'D';
				}
				System.out.println("Informe o consumo do apartamento do "+(i+1)+"º andar da coluna "+col);
				matriz[i][j]= scan.nextDouble();//armazena o consumo do apartamento do andar (i+1) e da coluna j (se j for 0 = A, 1 = B, 2 = C, 3 = D)		
			}
		}
		
		do {
			opcao = menu();	
			//Processa as ações definidas pela opção escolhida pelo usuário
			switch (opcao){
			case 1:
				// Valida se a coluna informada existe
				do
				{
					System.out.println("Informe a coluna:");
					col= Character.toUpperCase(scan.next().charAt(0));
					// Iicializa a variável "coluna" com o respectivo índice da coluna da matriz que a representa
					switch(col)
					{
						case 'A': coluna = 0;
						break;
						case 'B': coluna = 1;
						break;
						case 'C': coluna = 2;
						break;
						case 'D': coluna = 3;
						break;
						default:
							System.out.println("A Coluna "+ col +" não existe!");
							coluna=-1; //Inicializa a variável coluna com o valor -1 para indicar que a coluna não existe
					}
				}while(coluna==-1);
				
				System.out.println("O consumo total da coluna "+col+" é: "+
									consumoColuna(coluna,matriz));	
				break;
			case 2:
				boolean erro;
				// valida se o andar informado existe
				do
				{
					erro = false;
					System.out.println("Informe o andar:");
					andar=scan.nextInt();
					if(andar<1 || andar>qtdAndar)
					{
						System.out.println("O "+andar+"º andar não existe!");
						erro = true;
					}
				}while(erro);
				
				andar--;//Ajusta para o índice correto da matriz
				System.out.println("O consumo total do andar "+(andar+1)+" é: "+
									consumoAndar(andar,matriz));
				break;
			case 3:
				// valida se o andar informado existe
				do
				{
					erro = false;
					System.out.println("Informe o andar:");
					andar=scan.nextInt();
					if(andar<1 || andar>qtdAndar)
					{
						System.out.println("O "+andar+"º andar não existe!");
						erro = true;
					}
				}while(erro);
				andar--;//Ajusta para o índice correto do vetor

				// valida se a coluna informada existe e mostra o consumo do apartamento
				do
				{
					System.out.println("Informe a coluna:");
					col = Character.toUpperCase(scan.next().charAt(0)); //Lê e transforma a identificação da coluna para maiúscula

					switch(col)
					{
						case'A':
							System.out.println("O consumo do apartamento do "+(andar+1)+"º andar, coluna " +col+" é: "+matriz[andar][0]);
							break;
						case'B':
							System.out.println("O consumo do apartamento do "+(andar+1)+"º andar, coluna " +col+" é: "+matriz[andar][1]);
							break;
						case'C':
							System.out.println("O consumo do apartamento do "+(andar+1)+"º andar, coluna " +col+" é: "+matriz[andar][2]);
							break;
						case'D':
							System.out.println("O consumo do apartamento do "+(andar+1)+"º andar, coluna " +col+" é: "+matriz[andar][3]);
							break;
						default:
							System.out.println("A Coluna "+col+" não existe!");
							col=' ';
					}
				}while(col==' ');
				break;
			case 0:
				break;
			default:
				System.out.println("A Opção "+opcao+" é inválida!");
			}
		}while (opcao != 0);
		System.out.println("Fim do Programa!");
	}
	
	public static double consumoColuna(int coluna, double matriz[][])
	{
		double soma=0.0;
		//Soma todos os valores dos apartamentos que estão nesta coluna
		for(int i=0;i<matriz.length;i++ )
		{
			soma=soma+matriz[i][coluna];
		}
		return soma;
	}
	
	public static double consumoAndar(int andar, double matriz[][])
	{
		double soma=0.0;
		//Soma todos os valores dos apartamentos que estão nesta coluna
		for(int j=0;j<matriz[0].length;j++ )
		{
			soma=soma+matriz[andar][j];
		}
		return soma;
	}
	
	public static int menu()
	{
		// Imprime na tela as opções do menu
		System.out.println("Escolha uma opção: ");
		System.out.println("1: Calcula valor total de consumo por coluna");
		System.out.println("2: Calcula valor total de consumo por andar");
		System.out.println("3: Consumo por apartamento");
		System.out.println("0: Sair");
		System.out.println("Opção: ");
		// Lê a opção escolhida pelo usuário
		return scan.nextInt();
	}
}