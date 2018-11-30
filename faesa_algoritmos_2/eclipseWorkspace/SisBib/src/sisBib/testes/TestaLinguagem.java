package sisBib.testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import sisBib.util.Config;
import sisBib.util.Datas;

public class TestaLinguagem {
	public static void main(String[] args) {
		Config config = new Config();
		String lingua = config.getLingua();
		String pais   = config.getPais();
		Locale ptBR   = new Locale(lingua, pais);
		Datas data = new Datas();
		
		DateFormat dataCompleta = DateFormat.getDateInstance(DateFormat.FULL, ptBR);
		System.out.println(dataCompleta.format(new Date()));
		
		DateFormat dataDDMMAAAA = DateFormat.getDateInstance(DateFormat.DEFAULT, ptBR);
		System.out.println(dataDDMMAAAA.format(new Date()));
		
		//DateFormat data = DateFormat.getDateInstance(DateFormat., ptBR);
		System.out.println(new SimpleDateFormat("E").format(new Date()));
		System.out.println(new SimpleDateFormat("EEEE").format(new Date()));
		System.out.println(new SimpleDateFormat("EEEEE").format(new Date()));
		SimpleDateFormat teste = new SimpleDateFormat("d/M/YYYY", ptBR);
		System.out.println(teste.format(new Date()));
		
		System.out.println(data.fmtDataCompleta(new Date()));
		System.out.println(data.fmtDataCompletaComDiaDaSemana(new Date()));
		System.out.println(data.fmtDataDDMMAA(new Date()));
		System.out.println(data.fmtDataDDMMAAAA(new Date()));
		System.out.println(data.fmtHora24(new Date()));
		System.out.println(data.fmtHora12(new Date()));
		
	}

}
