package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

	public static boolean validarEmail(String email) {
		Pattern expresion = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher validar = expresion.matcher(email);

		if (!validar.matches()) {
			return false;
		}

		return true;
	}

	public static boolean soloTexto(String texto) {
		Pattern expresion = Pattern.compile("([a-zA-Z])*");
		Matcher validacion = expresion.matcher(texto);

		if ((!validacion.matches())) {
			return false;
		}

		return true;
	}

	public static boolean soloNumero(String texto) {
		Pattern expresion = Pattern.compile("([0-9])*");
		Matcher validar = expresion.matcher(texto);

		if (!validar.matches()) {
			return false;
		}

		return true;
	}

	public static boolean dni(String dni) {
		Pattern expresion = Pattern.compile("([0-9])*");
		Matcher validar = expresion.matcher(dni);

		if (dni.length() < 7 || dni.length() > 8 || (!validar.matches())) {
			return false;
		}

		return true;
	}

}
