import java.util.*;
public class MostraLocal {

	public static void main(String[] args) {
		int local=0, bloco=0, andar=0, sala=0, temp = 0, i = 0;
		int resto[]= new int[3];
		String rotulo[]=new String[3];
		rotulo[0]= "Sala: ";
		rotulo[1]= "Andar: ";
		rotulo[2]= "Bloco: ";
		
		System.out.print("Informe o local (número inteiro com 3 dígitos): ");
		Scanner in = new Scanner(System.in);
		local = in.nextInt();
		System.out.print("\n");
		
		// Extrai número no Bloco, Andar e Sala
/*		sala = local%10;
		local = local/10;
		andar = local%10;
		bloco = local/10;
*/		
		temp = local;
		do
		{
			resto[i]=temp%10;
			temp = temp/10;
			i++;
		}while(temp>0);
		// Imprime as informações
		System.out.println("Sala " + local);
		for(int k=0;k<i;k++)
		{
			System.out.println(rotulo[k]+ resto[k]);
		}
		in.close();
	}
}
