package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import servicio.EmpleadoServicio;

@Controller
public class IniciarSesionControlador {
	
	@Autowired
	EmpleadoServicio empleadoServicio;
	
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ModelAndView loginUsuario(HttpServletRequest request, String legajo, String password) {
		ModelAndView MV = new ModelAndView();
		String Message = "";

		HttpSession misession = request.getSession(true);
		Empleado usuario = null;
			
		

		if (!legajo.isEmpty() && !password.isEmpty()) {
			//usuario = empleadoServicio.em

			if (usuario != null) {
				misession.setAttribute("loggedIn", usuario);
				
				MV.setViewName("Inicio");
			} else {
				Message = "El usuario o contraseña es incorreccto.";
				MV.setViewName("IniciarSesion");
				MV.addObject("Message", Message);
			}
		} else {
			Message = "Debe ingresar un usuario y contraseña.";
			MV.setViewName("IniciarSesion");
			MV.addObject("Message", Message);
		}

		return MV;

	}

}
