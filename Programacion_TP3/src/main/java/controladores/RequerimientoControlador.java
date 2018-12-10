package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import entidad.Requerimiento;
import servicio.EmpleadoServicio;
import servicio.RequerimientoServicio;
import validacion.Validacion;


@Controller
public class RequerimientoControlador {
	
	@Autowired
	EmpleadoServicio empleadoServicio;
	
	@Autowired
	RequerimientoServicio requerimientoServicio;
	
	
	
	 @RequestMapping(value = "/cargar-rq", method = { RequestMethod.POST })
		public ModelAndView cargarRQ(String titulo, String numero,HttpServletRequest request) {
		 
		 ModelAndView mv = new ModelAndView("desarrollador/Requerimientos");			
		 String error = "";
		 String confirmacion = "";
		
		 
		 HttpSession session = request.getSession();
		 
		 Empleado empleado = new Empleado();		 
		 empleado = (Empleado) session.getAttribute("loggedIn");
		 
		
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>(); 
		 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());
		 
		 if(titulo.isEmpty()||numero.isEmpty()) {
			 
			 error = "El campo 'número de requerimiento' y 'titulo' son obligatorios";
			 mv.addObject("titulo",titulo);
			 mv.addObject("numero",numero);
			 mv.addObject("error",error);
			 mv.addObject("requerimientos",requerimientos);
			 
		 }else {
	 
			 if(!Validacion.soloNumero(numero)) {
				 
				 error = "El 'número de requerimiento' solo debe contener números";
				 mv.addObject("titulo",titulo);
				 mv.addObject("numero",numero);
				 mv.addObject("error",error);
				 mv.addObject("requerimientos",requerimientos);
			 }else {
				 
				
				 Long id = Long.parseLong(numero);
				 
				 List<Requerimiento> aux = new ArrayList<Requerimiento>();
				 aux = requerimientoServicio.traerPorNumeroYEmpleado(empleado.getDni(), id);	 	 
				
				 
				 if (aux.isEmpty()) {
					 
					 try {
						 
						 Requerimiento rq = new Requerimiento();
						 
						 rq.setNumero(id);
						 rq.setDescripcion(titulo);
						 rq.setHabilitado(true);
						 rq.setEmpleado(empleado);
						 
						 requerimientoServicio.agregar(rq);
						 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());
						 
						 confirmacion = "Se cargó el requerimiento. Se podrá visualizar en la planilla.";
						 mv.addObject("confirmacion",confirmacion); 						 
					 
					 }catch (Exception e) {
						 mv.addObject("titulo",titulo);
						 mv.addObject("numero",numero);						 
						 mv.addObject("error",error);
						 error = "Ocurrió un error al cargar el requerimiento.";
					 }finally {
						 
						 mv.addObject("requerimientos",requerimientos); 
						 mv.addObject("error",error);
					 }	
					 
					
					 
				 }else {
					 error = "El empleado ya tiene cargado este número de requerimiento";
					 mv.addObject("titulo",titulo);
					 mv.addObject("numero",numero);
					 mv.addObject("error",error);
					 mv.addObject("requerimientos",requerimientos);
					 
				 }

			 }
			 
		 }
			
		     return mv;
		
		}
	 
	


	@RequestMapping(value = {"/eliminar-{id}"}, method = { RequestMethod.GET })
	 public ModelAndView eliminar(HttpServletRequest request, @PathVariable Integer id){
		
		 ModelAndView mv = new ModelAndView("desarrollador/Requerimientos");
				 
		 String mensaje = "";
		 String error = ""; 
		 HttpSession session = request.getSession();
		 
		 Empleado empleado = new Empleado();		 
		 empleado = (Empleado) session.getAttribute("loggedIn");
		 
		
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>(); 
		 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());		 
		 
		 try {
			 
			 Requerimiento rq = requerimientoServicio.traer(id);	
			 
			 rq.setHabilitado(false);
			 
			 requerimientoServicio.modificar(rq);
			 
			 mensaje = "Se eliminó el requerimiento correctamente";
			 
			 requerimientos = requerimientoServicio.habilitadosPorEmpleado(empleado.getDni());	
			 
			 
		 }catch (Exception e ) {
			 
			 error = "Ocurrio un error al eliminar el requerimiento.";
			 
		 }finally {
			 mv.addObject("requerimientos", requerimientos);	
			 mv.addObject("mensaje", mensaje);
			 mv.addObject("error", error);
		 }
		
		 return mv;
		 
	 }
	 
	
	

}
