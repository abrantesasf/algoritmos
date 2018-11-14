package sisBib.util;

//Importação de bibliotecas:
import java.text.Normalizer;

/**
 * <p>Classe que implementa vários métodos utilitários para operações com Strings, para
 * facilitar comparações, buscas, etc.</p>
 * 
 * @author  Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class TextUtils {
	
	/**
	 * <p><b>buscaS1emS2(String <i>string1</i>, String <i>string2</i>)</b></p>
	 * 
	 * <p>Este método verifica se a <i>string1</i> está contida dentro da <i>string2</i>,
	 * <b>sem levar em conta</b> caracteres acentuados, demais marcas diacríticas e diferenças
	 * entre letras maiúsculas ou minúsculas.</p>
	 * <p>Se <i>string2</i> contém <i>string1</i>, retorna True, caso contrário retorna False.</p>
	 * 
	 * @param string1 (String)
	 * @param string2 (String)
	 * @return True, se a string1 está contida na string2<br />False, se a string1 NÃO está contida na string2
	 * @see <a href="https://stackoverflow.com/questions/86780/how-to-check-if-a-string-contains-another-string-in-a-case-insensitive-manner-in/40508106#40508106">String in a case insensitive manner</a>
	 */
	public boolean buscaS1emS2(String string1, String string2) {
		if (Normalizer.normalize(string2, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase().contains(Normalizer.normalize(string1, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

}
