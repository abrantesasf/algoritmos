package revisao;
public class ProvaLP {
	static int[] vetor1 = new int[1];
	static int[] vetor2 = new int[1];
	static int teste(int[] v) {
		v[0] = v[0] * 2;
		return v[0] + 2;
	}
	public static void main(String[] args) {
		vetor1[0] = 4;
		vetor2[0] = vetor1[0] + teste(vetor1) + teste(vetor1);	
		System.out.println(vetor1[0]);
		System.out.println(vetor2[0]);
		vetor1[0] = 4;
		vetor2[0] = 2 * teste(vetor1);
		vetor2[0] = vetor1[0] + vetor2[0]*vetor2[0];
		System.out.println("\n");
		System.out.println(vetor1[0]);
		System.out.println(vetor2[0]);		
	}
}