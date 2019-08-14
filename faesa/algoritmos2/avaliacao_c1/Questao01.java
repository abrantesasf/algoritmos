/*
 * Este programa calcula o consumo de energia de um pr�dio de 8 andares.
 * Os consumos dos apartamentos, em cada andar, s�o armazenados nas colunas da matriz:
 * �ndice 0 = coluna A, �ndice 1 = coluna B, �ndice 2 = coluna C e �ndice 3 = coluna D). 
 * S�o 4 apartamentos por andar, um em cada coluna.
 * A op��o 1 calcula o consumo por coluna.
 * A op��o 2 calcula o consumo por andar.
 * A op��o 3 mostra o consumo por apartamento.
 * A op��o 0 finaliza o programa.
 */
import java.util.Scanner;
public class CalculaConsumoEnergia {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;// Op��o do menu fiscal
		int andar,coluna;
		char col=' ';
		int qtdAndar=3, qtdCol=4; //Quantidade de andares do pr�dio

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
				System.out.println("Informe o consumo do apartamento do "+(i+1)+"� andar da coluna "+col);
				matriz[i][j]= scan.nextDouble();//armazena o consumo do apartamento do andar (i+1) e da coluna j (se j for 0 = A, 1 = B, 2 = C, 3 = D)		
			}
		}
		
		do {
			opcao = menu();	
			//Processa as a��es definidas pela op��o escolhida pelo usu�rio
			switch (opcao){
			case 1:
				// Valida se a coluna informada existe
				do
				{
					System.out.println("Informe a coluna:");
					col= Character.toUpperCase(scan.next().charAt(0));
					// Iicializa a vari�vel "coluna" com o respectivo �ndice da coluna da matriz que a representa
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
							System.out.println("A Coluna "+ col +" n�o existe!");
							coluna=-1; //Inicializa a vari�vel coluna com o valor -1 para indicar que a coluna n�o existe
					}
				}while(coluna==-1);
				
				System.out.println("O consumo total da coluna "+col+" �: "+
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
						System.out.println("O "+andar+"� andar n�o existe!");
						erro = true;
					}
				}while(erro);
				
				andar--;//Ajusta para o �ndice correto da matriz
				System.out.println("O consumo total do andar "+(andar+1)+" �: "+
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
						System.out.println("O "+andar+"� andar n�o existe!");
						erro = true;
					}
				}while(erro);
				andar--;//Ajusta para o �ndice correto do vetor

				// valida se a coluna informada existe e mostra o consumo do apartamento
				do
				{
					System.out.println("Informe a coluna:");
					col = Character.toUpperCase(scan.next().charAt(0)); //L� e transforma a identifica��o da coluna para mai�scula

					switch(col)
					{
						case'A':
							System.out.println("O consumo do apartamento do "+(andar+1)+"� andar, coluna " +col+" �: "+matriz[andar][0]);
							break;
						case'B':
							System.out.println("O consumo do apartamento do "+(andar+1)+"� andar, coluna " +col+" �: "+matriz[andar][1]);
							break;
						case'C':
							System.out.println("O consumo do apartamento do "+(andar+1)+"� andar, coluna " +col+" �: "+matriz[andar][2]);
							break;
						case'D':
							System.out.println("O consumo do apartamento do "+(andar+1)+"� andar, coluna " +col+" �: "+matriz[andar][3]);
							break;
						default:
							System.out.println("A Coluna "+col+" n�o existe!");
							col=' ';
					}
				}while(col==' ');
				break;
			case 0:
				break;
			default:
				System.out.println("A Op��o "+opcao+" � inv�lida!");
			}
		}while (opcao != 0);
		System.out.println("Fim do Programa!");
	}
	
	public static double consumoColuna(int coluna, double matriz[][])
	{
		double soma=0.0;
		//Soma todos os valores dos apartamentos que est�o nesta coluna
		for(int i=0;i<matriz.length;i++ )
		{
			soma=soma+matriz[i][coluna];
		}
		return soma;
	}
	
	public static double consumoAndar(int andar, double matriz[][])
	{
		double soma=0.0;
		//Soma todos os valores dos apartamentos que est�o nesta coluna
		for(int j=0;j<matriz[0].length;j++ )
		{
			soma=soma+matriz[andar][j];
		}
		return soma;
	}
	
	public static int menu()
	{
		// Imprime na tela as op��es do menu
		System.out.println("Escolha uma op��o: ");
		System.out.println("1: Calcula valor total de consumo por coluna");
		System.out.println("2: Calcula valor total de consumo por andar");
		System.out.println("3: Consumo por apartamento");
		System.out.println("0: Sair");
		System.out.println("Op��o: ");
		// L� a op��o escolhida pelo usu�rio
		return scan.nextInt();
	}
}