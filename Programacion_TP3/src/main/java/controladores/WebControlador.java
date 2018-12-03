package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import entidad.Licencia;
import entidad.Requerimiento;
import servicio.LicenciaServicio;
import servicio.RequerimientoServicio;

@Controller
public class WebControlador {
	
	@Autowired
	RequerimientoServicio requerimientoServicio;
	
	@Autowired
	LicenciaServicio licenciaServicio;
	
	 @RequestMapping(path = "/")
	    public ModelAndView iniciar() {  
		 
	        ModelAndView mv = new ModelAndView("IniciarSesion");
	        return mv;
	    }
	 
	    @RequestMapping(path = "/cerrar-sesion")
	    public ModelAndView cerrarSesion(HttpServletRequest request) {
	    	
	    	request.getSession().invalidate(); 	     	
	        ModelAndView mv = new ModelAndView("IniciarSesion");
	    
	        return mv;
	    }
	    
	    // *********************** desarrollador *********************** //
	    
	    @RequestMapping(value = "/inicio-desarrollador", method = { RequestMethod.GET })
		public ModelAndView inicioDesarrollador() {
			
			 ModelAndView mv = new ModelAndView("desarrollador/InicioDesa");
		     return mv;
		
		}
	    
	    @RequestMapping(value = "/requerimientos-desarrollador", method = { RequestMethod.GET })
		public ModelAndView requerimientosDesarrollador(HttpServletRequest request) {
			
	    	 HttpSession session = request.getSession();
	    	 Empleado empleado = new Empleado();		 
			 empleado = (Empleado) session.getAttribute("loggedIn");
			 
	    	 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
	    	 
	    	 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());
			 ModelAndView mv = new ModelAndView("desarrollador/Requerimientos");
			 
			 mv.addObject("requerimientos", requerimientos);
			 
		     return mv;
		
		}
		
		@RequestMapping(value = "/licencias-desarrollador", method = { RequestMethod.GET })
		public ModelAndView licenciasDesarrollador(HttpServletRequest request) {
			
			 ModelAndView mv = new ModelAndView("desarrollador/Licencias");
			 
			 HttpSession session = request.getSession();
	    	 Empleado empleado = new Empleado();		 
			 empleado = (Empleado) session.getAttribute("loggedIn");
			 
			 List<Licencia> licencias = new ArrayList<Licencia>();
			 
			 licencias = licenciaServicio.licenciaPorEmpleado(empleado.getDni());
			 
			 mv.addObject("licencias", licencias);
			 
		     return mv;
		
		}
		
		@RequestMapping(value = "/tareas-desarrollador", method = { RequestMethod.GET })
		public ModelAndView menuTareas() {
			
			 ModelAndView mv = new ModelAndView("desarrollador/Tareas");
		     return mv;
		
		}
		
		  // *********************** RRHH ********************************* //
		
		 @RequestMapping(value = "/menu-empleados-rrhh", method = { RequestMethod.GET })
			public ModelAndView menuEmpleadosRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/MenuEmpleados");
			     return mv;
			
			}
			
			@RequestMapping(value = "/menu-licencias-rrhh", method = { RequestMethod.GET })
			public ModelAndView menuLicenciasRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/MenuLicencias");
			     return mv;
			
			}
			
			@RequestMapping(value = "/menu-tareas-rrrhh", method = { RequestMethod.GET })
			public ModelAndView menuTareasRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/MenuTareas");
			     return mv;
			
			}
			
			
			
}
