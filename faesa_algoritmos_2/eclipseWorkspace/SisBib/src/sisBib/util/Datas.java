package sisBib.util;

// Importação de bibliotecas
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import sisBib.util.Config;

/**
 * <p>A classe Datas contém métodos auxiliares para formatar e trabalhar com datas no SisBib,
 * de acordo com as configurações de i10n/i18n obtidas a partir de um arquivo de configurações.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-29
 */
public class Datas {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>config</b></p>
	 * <ul>
	 * <li>Objeto para obter as configurações a partir de um arquivo.</li>
	 * <li>Tipo: Config</li>
	 * </ul>
	 */
	private Config config;
	
	/**
	 * <p><b>lingua, pais</b></p>
	 * <p>Variáveis que recebem as configurações de linguagem a partir do arquivo
	 * de configurações.</p>
	 */
	private String lingua = "";
	private String pais   = "";
	
	/**
	 * <p><b>local</b></p>
	 * <p>Objeto do tipo Locale para configurar e formatar dadas conforme as configurações
	 * de i10n/i18n do arquivod e configurações.</p>
	 */
	private Locale local;
	
	/**
	 * <p><b>dataCompleta, dataDDMMAA, dataDDMMAAAA</b></p>
	 * <p>Variáveis para formatação de data, de diversas maneiras.</p>
	 */
	private SimpleDateFormat dataCompleta;
	private SimpleDateFormat dataCompletaComDiaDaSemana;
	private SimpleDateFormat dataDDMMAA;
	private SimpleDateFormat dataDDMMAAAA;
	
	/**
	 * <p><b>hora24, hora12</b></p>
	 * <p>Variáveis para formatação de hora</p>
	 */
	private SimpleDateFormat hora24;
	private SimpleDateFormat hora12;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////	

	public Datas() {
		// Lê o arquivo de configuração, pega as configurações de língua e país
		// e gera um Locale adequado
		this.config = new Config();
		this.lingua = config.getLingua();
		this.pais   = config.getPais();
		this.local  = new Locale(this.lingua, this.pais);
		
		// Formato para datas "completas"
		this.dataCompleta = new SimpleDateFormat("d 'de' MMMM 'de' YYYY", local);
		this.dataCompletaComDiaDaSemana = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' YYYY", local);
		
		// Formato para datas "simples"
		this.dataDDMMAA = new SimpleDateFormat("d/M/YY", local);
		this.dataDDMMAAAA = new SimpleDateFormat("d/M/YYYY", local);
		
		// Formato para horas
		this.hora24 = new SimpleDateFormat("H:m");
		this.hora12 = new SimpleDateFormat("h:mm a");
	}
	
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////		
	
	/**
	 * <p><b>fmtDataCompleta(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "DD de MÊS de ANO".</p>
	 * @param data (Date)
	 * @return "DD de MÊS de ANO" (String)
	 */
	public String fmtDataCompleta(Date data) {
		return this.dataCompleta.format(data);
	}
	
	/**
	 * <p><b>fmtDataCompletaComDiaDaSemna(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "DIA-DA-SEMANA, DD de MÊS de ANO".</p>
	 * @param data (Date)
	 * @return "DIA-DA-SEMANA, DD de MÊS de ANO" (String)
	 */
	public String fmtDataCompletaComDiaDaSemana(Date data) {
		return this.dataCompletaComDiaDaSemana.format(data);
	}

	/**
	 * <p><b>fmtDataDDMAA(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "DD/MM/AA".</p>
	 * @param data (Date)
	 * @return "DD/MM/AA" (String)
	 */
	public String fmtDataDDMMAA(Date data) {
		return this.dataDDMMAA.format(data);
	}
	
	/**
	 * <p><b>fmtDataDDMAAAA(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "DD/MM/AAAA".</p>
	 * @param data (Date)
	 * @return "DD/MM/AAAA" (String)
	 */
	public String fmtDataDDMMAAAA(Date data) {
		return this.dataDDMMAAAA.format(data);
	}
	
	/**
	 * <p><b>fmtHora24(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "HH:MM" (hora em 24 horas).</p>
	 * @param data (Date)
	 * @return "HH:MM" (String representando uma hora em 24 horas)
	 */
	public String fmtHora24(Date data) {
		return this.hora24.format(data);
	}
	
	/**
	 * <p><b>fmtHora12(Date data)</b></p>
	 * <p>Recebe um objeto do tipo Date e retorna uma string no formato
	 * "HH:MM AM/PM" (hora em 12 horas).</p>
	 * @param data (Date)
	 * @return "HH:MM AM/PM" (String representando uma hora em 12 horas)
	 */
	public String fmtHora12(Date data) {
		return this.hora12.format(data);
	}
	
} // Fecha Classe Datas
