package controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Clases.CierreMensual;
import entidad.Empleado;
import entidad.Licencia;
import entidad.RqPorEmpleado;
import entidad.Tarea;
import servicio.LicenciaServicio;
import servicio.RequerimientoServicio;
import servicio.TareaServicio;

@Controller
public class WebControlador {
	
	@Autowired
	RequerimientoServicio requerimientoServicio;
	
	@Autowired
	LicenciaServicio licenciaServicio;
	
	@Autowired
	TareaServicio tareaServicio;
	
	String MESES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

	
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
	    	
	    	//Inicio la pagina mostrando todos los requerimientos cargados por el empleado logueado
			
	    	 HttpSession session = request.getSession();
	    	 Empleado empleado = new Empleado();		 
			 empleado = (Empleado) session.getAttribute("loggedIn");
			 
	    	 List<RqPorEmpleado> requerimientos = new ArrayList<RqPorEmpleado>();
	    	 
	    	 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());
			 ModelAndView mv = new ModelAndView("desarrollador/Requerimientos");
			 
			 mv.addObject("requerimientos", requerimientos);
			 
		     return mv;
		
		}
		
		@RequestMapping(value = "/licencias-desarrollador", method = { RequestMethod.GET })
		public ModelAndView licenciasDesarrollador(HttpServletRequest request) {
			
			//muestro todas las licencias del empleado logueado
			
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
		public ModelAndView tareasDesarrollador(HttpServletRequest request) {
			
			//muestro las tareas y las licencias del empleado del mes actual
			
			 ModelAndView mv = new ModelAndView("desarrollador/Tareas");
			 String form2 = "none";
			 mv.addObject("form2", form2);
			 
			 Calendar fecha = Calendar.getInstance();
		     Integer anioencurso = fecha.get(Calendar.YEAR);
		     Integer mes = fecha.get(Calendar.MONTH) + 1;   
		     
		     String nombreMes = MESES[mes-1].toUpperCase();
		     
			 
			 HttpSession misession = request.getSession(true);
	    	 Empleado empleado = new Empleado();		 
			 empleado = (Empleado) misession.getAttribute("loggedIn");
			 
			 List<Licencia> licencias = new ArrayList<Licencia>();
			 List<Tarea> tareas = new ArrayList<Tarea>();
			 
			 tareas = tareaServicio.tareasPorEmpleadoYMes(empleado.getDni(), mes, anioencurso);
			 licencias = licenciaServicio.licenciaPorEmpleadoYMes(empleado.getDni(),mes,anioencurso);
			 
			 misession.setAttribute("SessionLicencias", licencias);			
			 misession.setAttribute("SessionTareas", tareas);			 
			 mv.addObject("anioencurso", anioencurso);
			 mv.addObject("nombreMes", nombreMes);
			 mv.addObject("titulo", "TAREAS CARGADAS PARA EL MES DE "+nombreMes+" DE "+anioencurso);
			 
		     return mv;
		
		}
		
		  // *********************** RRHH ********************************* //
		
		 @RequestMapping(value = "/inicio-rrhh", method = { RequestMethod.GET })
			public ModelAndView inicioRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/InicioRRHH");
			     return mv;
			
			}		 
		 
		
		 @RequestMapping(value = "/menu-ABM", method = { RequestMethod.GET })
			public ModelAndView menuABM() {
				
				 ModelAndView mv = new ModelAndView("rrhh/MenuABM");
			     return mv;
			
			}
		 
		 @RequestMapping(value = "/alta-desarrollador", method = { RequestMethod.GET })
			public ModelAndView altaDesarrollador() {
				
				 ModelAndView mv = new ModelAndView("rrhh/AltaDesarrollador");
			     return mv;
			
			}
		 
		 @RequestMapping(value = "/baja-desarrollador", method = { RequestMethod.GET })
			public ModelAndView bajaDesarrollador() {
				
				 ModelAndView mv = new ModelAndView("rrhh/BajaDesarrollador");
			     return mv;
			
			}
		 
		 @RequestMapping(value = "/modificar-desarrollador", method = { RequestMethod.GET })
			public ModelAndView modificarDesarrollador() {
				
				 ModelAndView mv = new ModelAndView("rrhh/ModificarDesarrollador");
			     return mv;
			
			}
			
			@RequestMapping(value = "/licencias-rrhh", method = { RequestMethod.GET })
			public ModelAndView licenciasRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/Licencias");
				 String form2 = "none";
				 mv.addObject("form2", form2);
			     return mv;
			
			}
			
			@RequestMapping(value = "/listado-rrhh", method = { RequestMethod.GET })
			public ModelAndView listadoRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/Listado");
			     return mv;
			
			}
			
			@RequestMapping(value = "/tareas-rrhh", method = { RequestMethod.GET })
			public ModelAndView tareasRRHH(HttpServletRequest request) {
				
				 ModelAndView mv = new ModelAndView("rrhh/Tareas");	
				 
				 HttpSession misession = request.getSession(true);
				 
				 List<Tarea> tareas = new ArrayList<Tarea>();
 				 
				 String form2 = "none";
				 mv.addObject("form2", form2);		
				 
				 misession.removeAttribute("sTareas");
				 misession.setAttribute("sTareas",tareas);
							     
			     return mv;
			
			}
			
			@RequestMapping(value = "/cierre-rrhh", method = { RequestMethod.GET })
			public ModelAndView cierreMensual(HttpServletRequest request) {
				
				 ModelAndView mv = new ModelAndView("rrhh/CierreMensual");
				 
				 String form2 = "none";
				 mv.addObject("form2", form2);	
				 
				 HttpSession misession = request.getSession(true);
				 
				 List<CierreMensual> lista = new ArrayList<CierreMensual>();
				 
				 Calendar fecha = Calendar.getInstance();
			     Integer anioencurso = fecha.get(Calendar.YEAR);
				 
				 misession.setAttribute("cierre", lista);
				 mv.addObject("anioencurso", anioencurso);
				 
				 
			     return mv;
			
			}
			
			@RequestMapping(value = "/menu-rq-rrhh", method = { RequestMethod.GET })
			public ModelAndView requerimientosRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/MenuRq");			 
				 
			     return mv;
			
			}
			
			@RequestMapping(value = "/seguimiento-requerimiento", method = { RequestMethod.GET })
			public ModelAndView seguimientoRRHH() {
				
				 ModelAndView mv = new ModelAndView("rrhh/SeguimientoRq");		
				 
				 List<Tarea> tareas = new ArrayList<Tarea>();
				 
				 mv.addObject("tareas", tareas);
				 
			     return mv;
			
			}
			
			@RequestMapping(value = "/alta-requerimiento", method = { RequestMethod.GET })
			public ModelAndView altaRequerimiento() {
				
				 ModelAndView mv = new ModelAndView("rrhh/AltaRequerimiento");		
				 
				 String form2 = "none";
				 mv.addObject("form2", form2);	
				 
			     return mv;
			
			}
			
			@RequestMapping(value = "/asignar-requerimiento", method = { RequestMethod.GET })
			public ModelAndView asignarRQ() {
				
				 ModelAndView mv = new ModelAndView("rrhh/AsignarRequerimiento");
				 
				 String form2 = "none";
				 mv.addObject("form2", form2);
				 List<RqPorEmpleado> requerimientos = new ArrayList<RqPorEmpleado>();
				 
				 mv.addObject("requerimientos", requerimientos);
			     return mv;
			
			}
			
			
			
}
