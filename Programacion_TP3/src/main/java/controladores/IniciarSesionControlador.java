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
import validacion.Validacion;

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
			
		//

		if (!legajo.isEmpty() && !password.isEmpty()) {
			
			if (Validacion.soloNumero(legajo)){
				
				
				Integer legajoU = Integer.parseInt(legajo);
				
				usuario = empleadoServicio.empleadoAutenticado(password, legajoU);
				
				if (usuario != null) {
					
					if(usuario.isHabilitado()) {
						misession.setAttribute("loggedIn", usuario);					
						
	 					
						if(usuario.getLegajo().getRol().getIdRol()==3) {
							
							MV.setViewName("administrador/InicioAdm");	
						}
						if(usuario.getLegajo().getRol().getIdRol()==2) {
							
							MV.setViewName("rrhh/InicioRRHH");
						}
						if(usuario.getLegajo().getRol().getIdRol()==1) {
							
							MV.setViewName("desarrollador/InicioDesa");
						}
					
					}else {
						
						Message = "El usuario fue dado de baja del sistema.";
						MV.setViewName("IniciarSesion");
						MV.addObject("Message", Message);
					}
					
					
				} else {
					Message = "El usuario o contraseña es incorreccto.";
					MV.setViewName("IniciarSesion");
					MV.addObject("Message", Message);
				}
				
			}else {
				
				Message = "El legajo debe ser solo números.";
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
