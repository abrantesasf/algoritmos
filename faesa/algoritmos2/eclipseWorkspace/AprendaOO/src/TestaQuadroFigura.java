
public class TestaQuadroFigura {

	public static void main(String[] args) {
		// Cria quadros:
		Quadro q1 = new Quadro("Mona Lisa");
		Quadro q2 = new Quadro();
		
		// Ajusta tamanho dos quadros
		q1.setAltura(20);
		q1.setLargura(30);
		q2.setAltura(30);
		q2.setLargura(20);
		
		// Mostra informações dos quadros criados:
		System.out.println("O quadro é " + q1.getDescricaoDaFigura() + ", com " + q1.getAltura() + " cm de altura e " + q1.getLargura() + " cm de largura.");
		System.out.println("O quadro é " + q2.getDescricaoDaFigura() + ", com " + q2.getAltura() + " cm de altura e " + q2.getLargura() + " cm de largura.");

	}

}
