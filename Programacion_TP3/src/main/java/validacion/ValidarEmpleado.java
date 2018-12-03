package validacion;

import error.ErrorEmpleado;

public class ValidarEmpleado {

	private static ErrorEmpleado error;

	public static ErrorEmpleado datos(String dni, String nombre, String apellido, String telefono,
			String email, String legajo) {

		error = new ErrorEmpleado();

		error.setOk(true);

		if (!Validacion.dni(dni)) {

			error.setDniError("*El número de documento no es válido.");
			error.setOk(false);
		}

		if (!Validacion.soloTexto(nombre)) {

			error.setNombreError("*El nombre solo debe contener letras.");
			error.setOk(false);
		}

		if (!Validacion.soloTexto(apellido)) {

			error.setApellidoError("*El apellido debe contener solo letras.");
			error.setOk(false);
		}

		if (!Validacion.soloNumero(telefono)) {

			error.setTelefonoError("*El telefono debe contener solo números.");
			error.setOk(false);
		}

		if (!Validacion.validarEmail(email)) {

			error.setEmailError("*El e-mail no es válido.");
			error.setOk(false);
		}
		
		if (!Validacion.soloNumero(legajo)) {

			error.setLegajoError("*El legajo debe contener solo números.");
			error.setOk(false);
		}

		return error;
	}

}
