import java.util.Scanner;

public class TestaLSE {
	
	private static Scanner                    scan   = new Scanner(System.in);
	private static ListaSimplesmenteEncadeada lista1 = new ListaSimplesmenteEncadeada();

	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.println("\n--------------- MENU DE OPÇÕES ---------------\n" +
                               "10. Mostrar a lista\n" +
					           "11. Informar quantidade de nós\n" +
                               "\n" +
			                   "20. Inserir no início\n" +
                               "21. Inserir no fim\n" +
			                   "22. Inserir ordenado\n" +
                               "23. Inserir após um determinado nó pela chave\n" +
			                   "24. Inserir antes de um determinado nó pela chave\n" +
                               "25. Inserir após o k-ésimo nó\n" +
                               "\n" +
			                   "30. Remover o primeiro\n" +
                               "31. Remover o último\n" +
			                   "32. Remover um único nó pela chave\n" +
                               "33. Remover o k-ésimo nó\n" +
                               "\n" +
                               "99. Sair\n" +
                               "----------------------------------------------\n"+
			                   "Informe sua opção: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			
			case 10:
				mostrarLista();
				break;
				
			case 11:
				quantosNos();
				break;
				
			case 20:
				inserirNoInicio();
				break;
				
			case 21:
				inserirNoFim();
				break;
				
			case 22:
				inserirOrdenado();
				break;
				
			case 23:
				inserirAposNo();
				break;
				
			case 24:
				inserirAntesNo();
				break;
				
			case 25:
				inserirAposKesimo();
				break;
				
			case 30:
				removerPrimeiro();
				break;
				
			case 31:
				removerUltimo();
				break;
				
			case 32:
				removerNoPelaChave();
				break;
				
			case 33:
				removerKesimo();
				break;
				
			case 99:
				System.out.println("\nPrograma encerrado.\nMoriturus te saluto!");
				break;

			default:
				System.out.println("\nOpção inválida, informe novamente.\n");
				break;
				
			} // fim do switch
			
		} while (opcao != 99);

	} // fim do main
	
	
	/////////////////////////////////////////////////////////////////
	// 10. Mostrar a lista
	/////////////////////////////////////////////////////////////////
	public static void mostrarLista() {
		System.out.println(lista1.toString());
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 11. Informar quantidade de nós
	/////////////////////////////////////////////////////////////////
	public static void quantosNos() {
		System.out.println("\nA lista tem " + lista1.getTamanho() + " nós.");
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 20. Inserir no Início
	/////////////////////////////////////////////////////////////////
	public static void inserirNoInicio () {
		int chave;
		System.out.println("Informe a chave a ser inserida: ");
		chave = scan.nextInt();
		scan.nextLine();
		
		Item novoItem = new Item(chave);
		No   novoNo   = new No(novoItem);
		
		if ( lista1.inserirNoInicio(novoNo) ) {
			System.out.println("\nItem inserido com sucesso.");
		} else {
			System.out.println("\nNão foi possível inserir o item.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 21. Inserir no fim
	/////////////////////////////////////////////////////////////////
	public static void inserirNoFim () {
		int chave;
		System.out.println("Informe a chave a ser inserida: ");
		chave = scan.nextInt();
		scan.nextLine();
		
		Item novoItem = new Item(chave);
		No   novoNo   = new No(novoItem);
		
		if ( lista1.inserirNoFinal(novoNo) ) {
			System.out.println("\nItem inserido com sucesso.");
		} else {
			System.out.println("\nNão foi possível inserir o item.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 22. Inserir ordenado
	/////////////////////////////////////////////////////////////////	
	public static void inserirOrdenado () {
		int chave;
		System.out.println("Informe a chave a ser inserida: ");
		chave = scan.nextInt();
		scan.nextLine();
		
		Item novoItem = new Item(chave);
		No   novoNo   = new No(novoItem);
		
		if (lista1.inserirOrdenado(novoNo)) {
			System.out.println("\nItem inserido com sucesso.");
		} else {
			System.out.println("\nNãofoi possível inserir.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 23. Inserir após determinado nó buscando pela chave
	/////////////////////////////////////////////////////////////////
	public static void inserirAposNo () {
		int chave;
		int n;
		
		System.out.println("Digite o número que você deseja inserir:");
		chave = scan.nextInt();
		scan.nextLine();
		
		System.out.println("\nDigite a chave de busca: ");
		n = scan.nextInt();
		scan.nextLine();
		
		if ( ! lista1.eVazia() ) {
			Item novoItem = new Item(chave);
			No   novoNo   = new No(novoItem);
			if (lista1.inserirAposNo(novoNo, n)) {
				System.out.println("\nO número " + chave + " foi inserido após o nó com a chave " + n);
			} else {
				System.out.println("\nA chave buscada não existe, não foi possível inserir");
			}
		} else {
			System.out.println("\nLista vazia, nada a fazer.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 24. Inserir antes de determinado nó buscando pela chave
	/////////////////////////////////////////////////////////////////
	public static void inserirAntesNo() {
		int chave;
		int n;
		
		System.out.println("Digite o número que você deseja inserir:");
		chave = scan.nextInt();
		scan.nextLine();
		
		System.out.println("\nDigite a chave de busca: ");
		n = scan.nextInt();
		scan.nextLine();
		
		if ( ! lista1.eVazia() ) {
			Item novoItem = new Item(chave);
			No   novoNo   = new No(novoItem);
			if (lista1.inserirAntesNo(novoNo, n)) {
				System.out.println("\nO número " + chave + " foi inserido antes do nó com a chave " + n);
			} else {
				System.out.println("\nA chave buscada não existe, não foi possível inserir");
			}
		} else {
			System.out.println("\nLista vazia, nada a fazer.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 25. Inserir após k-ésimo
	/////////////////////////////////////////////////////////////////
	public static void inserirAposKesimo() {
		// TODO: implementar
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 30. Remover o primeiro
	/////////////////////////////////////////////////////////////////
	public static void removerPrimeiro() {
		if ( ! lista1.eVazia() ) {
			if ( lista1.removerPrimeiro() ) {
				System.out.println("\nPrimeiro item removido com sucesso.");
			} else {
				System.out.println("\nNão foi possível remover o primeiro item.");
			}
		} else {
			System.out.println("\nLista vazia, nada a remover.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 31. Remover o último
	/////////////////////////////////////////////////////////////////
	public static void removerUltimo() {
		if ( ! lista1.eVazia() ) {
			if ( lista1.removerUltimo() ) {
				System.out.println("\nÚltimo nó removido com sucesso.");
			}
		} else {
			System.out.println("\nNão foi possível remover o último nó.");
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 32. Remover um único nó pela chave
	/////////////////////////////////////////////////////////////////
	public static void removerNoPelaChave() {
		int chave;
		System.out.println("Digite a chave a ser removida: ");
		chave = scan.nextInt();
		scan.nextLine();
		
		if ( ! lista1.eVazia() ) {
			if ( lista1.removerNoPelaChave(chave)) {
				System.out.println("Nó com a chave " + chave + " removido com sucesso.");
			} else {
				System.out.println("Não foi possível remover.");
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// 33. Remover k-ésimo nó
	/////////////////////////////////////////////////////////////////
	public static void removerKesimo() {
		int k;
		System.out.println("Digite o número do nó que deseja remover: ");
		k = scan.nextInt();
		scan.nextLine();
		
		if ( lista1.eVazia() ) {
			System.out.println("\nLista vazia, nada para remover.");
		} else if (k > lista1.getQtdNos()) {
			System.out.println("O número informado é maior do que a quantidade de elementos na lista.");
		} else {
			if (lista1.removerKesimo(k) ) {
				System.out.println("O " + k + "º nó foi removido com sucesso.");
			}
		}
	}
	
}
