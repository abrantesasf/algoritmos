// Imports:
import java.util.ArrayList;
import java.util.List;

public class Locadora {
	// Atributos da classe:
	static List<Filme> acervo = new ArrayList<Filme>();
	static ScannerGlobal scan = ScannerGlobal.getInstancia();
	MeuMenu cardapio = new MeuMenu(2);
	
	
	// Métodos da classe:

	// Método main:
	public static void main(String[] args) {		
		// Atributos
		
		// Cria lista de filmes para compor o acervo
		//List<Filme> acervo = new ArrayList<Filme>();
		
		// Pega a instância do ScannerGlobal:
		//ScannerGlobal scan = ScannerGlobal.getInstancia();
		
		Filme f1 = new Filme();
		f1.setCodigo(12);
		f1.setTitulo("Carruagens de Fogo");
		f1.setGenero('T');
		
		Filme f2 = new Filme();
		f2.setCodigo(2);
		f2.setTitulo("Carruagens de Fogo");
		f2.setGenero('D');
		
		Filme f3 = new Filme();
		f3.setCodigo(3);
		f3.setTitulo("Missão Impossível");
		f3.setGenero('A');
		
		System.out.println(acervo.size());
		acervo.add(f1);
		System.out.println(acervo.size());
		acervo.add(f2);
		System.out.println(acervo.size());
		acervo.add(f3);
		System.out.println(acervo.size());
		incluiFilme();
		System.out.println(acervo.size());
		
		for(Filme i : acervo) {
			System.out.println(i.getTitulo() + " " + i.getGenero() + " " + i.getCodigo());
		}

	} // fecha main
	

	//static // teste
	private static void incluiFilme() {
		ScannerGlobal scan = ScannerGlobal.getInstancia();
		Filme f = new Filme();
		f.setTitulo("Teste");
		f.setGenero('A');
		f.setCodigo(scan.getNextInt());
		acervo.add(f);
	}

} // fecha classe
