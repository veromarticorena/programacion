package controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import entidad.Requerimiento;
import entidad.RqPorEmpleado;
import entidad.Tarea;
import servicio.EmpleadoServicio;
import servicio.RequerimientoServicio;
import servicio.TareaServicio;
import validacion.Validacion;


@Controller
public class RequerimientoControlador {
	
	@Autowired
	EmpleadoServicio empleadoServicio;
	
	@Autowired
	RequerimientoServicio requerimientoServicio;
	
	@Autowired
		TareaServicio tareaServicio;
	
	@Autowired
		servicio.RqPorEmpleadoServicio RqPorEmpleadoServicio;
	
	
	
	
	
	
	 @RequestMapping(value = "/cargar-rq", method = { RequestMethod.POST })
		public ModelAndView cargarRQ(String titulo, String numero) {
		 
		 ModelAndView mv = new ModelAndView("rrhh/AltaRequerimiento");			
		 String error = "";
		 String confirmacion = "";
				
		
		 		 
		 if(titulo.isEmpty()||numero.isEmpty()) {
			 
			 error = "El campo 'número de requerimiento' y 'titulo' son obligatorios";
			 mv.addObject("titulo",titulo);
			 mv.addObject("numero",numero);
			 mv.addObject("error",error);
			 
			 
		 }else {
	 
			 if(!Validacion.soloNumero(numero)) {
				 
				 error = "El 'número de requerimiento' solo debe contener números";
				 mv.addObject("titulo",titulo);
				 mv.addObject("numero",numero);
				 mv.addObject("error",error);

			 }else {
				 
				
				 Long id = Long.parseLong(numero);
				 
				 Requerimiento aux = new Requerimiento();
				 aux = requerimientoServicio.traerPorNumero(id);	 	 
				
				 
				 if (aux == null) {
					 
					 try {
						 
						 Requerimiento rq = new Requerimiento();
						 
						 rq.setNumero(id);
						 rq.setDescripcion(titulo);
						 rq.setHabilitado(true);
												 
						 requerimientoServicio.agregar(rq);				
						 
						 confirmacion = "Se cargó el requerimiento exitosamente.";
						 
																		 
					 
					 }catch (Exception e) {
						
						 error = "Ocurrió un error al cargar el requerimiento.";
						 mv.addObject("titulo",titulo);
						 mv.addObject("numero",numero);
						 mv.addObject("error",error);
					 }
					 
					
					 
				 }else {
					 error = "El numero de requerimiento ya existe o es un requerimiento antigüo.";
					 mv.addObject("titulo",titulo);
					 mv.addObject("numero",numero);
					 mv.addObject("error",error);
					 
				 }

			 }
			 
		 }
		 

			 mv.addObject("confirmacion",confirmacion); 
			 return mv;
		
		}
	 
	


	@RequestMapping(value = {"/eliminar-{id}"}, method = { RequestMethod.GET })
	 public ModelAndView eliminar(@RequestParam(value = "numero") String id){
		
		 ModelAndView mv = new ModelAndView("rrhh/ListadoRq");
				 
		 String mensaje = "";
		 String error = ""; 
				 
		 long req = Long.parseLong(id);
		 
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>(); 
		 requerimientos = requerimientoServicio.habilitados();	 
		 
		 try {
			 
			 Requerimiento rq = requerimientoServicio.traerPorNumero(req);	
			 
			 rq.setHabilitado(false);
			 
			 requerimientoServicio.modificar(rq);
			 
			 mensaje = "Se eliminó el requerimiento correctamente";
			 
			 requerimientos = requerimientoServicio.habilitados();
			 
			 
		 }catch (Exception e ) {
			 
			 error = "Ocurrio un error al eliminar el requerimiento.";
			 
		 }finally {
			 mv.addObject("requerimientos", requerimientos);	
			 mv.addObject("mensaje", mensaje);
			 mv.addObject("error", error);
		 }
		
		 return mv;
		 
	 }
	
	
	@RequestMapping(value = "/ver-requerimientos", method = { RequestMethod.GET })
	public ModelAndView requerimientosRRHH() {
		
		 ModelAndView mv = new ModelAndView("rrhh/ListadoRq");			
		 
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
		 
		 requerimientos = requerimientoServicio.habilitados();
		 
		 mv.addObject("requerimientos", requerimientos);
		 
	     return mv;
	
	}
	 
	@RequestMapping(value = "/buscar-tareas-rq", method = { RequestMethod.POST })
	public ModelAndView seguimiento(String numero) {
		
		 ModelAndView mv = new ModelAndView("rrhh/SeguimientoRq");	
		 
		 List<Tarea> tareas = new ArrayList<Tarea>();
		 
		 long total = 0;
		 
		 if(Validacion.soloNumero(numero)) {
			 
			 long rq = Long.parseLong(numero);
			 
					 
			 tareas = tareaServicio.tareasPorRQ(rq);		 
			 
			 for (Tarea t : tareas) {
					
				 total = total+t.getHoras();
													
				}
			
			 
		 }else {
			 
			 
			 mv.addObject("error", "Por favor ingrese un número de requerimiento válido");
		 }
		 
		 mv.addObject("tareas", tareas);
		 mv.addObject("numero", numero);
		 mv.addObject("total", total);
	     return mv;
	
	}
	
	@RequestMapping(value = "/buscar-requerimiento", method = { RequestMethod.POST })
	public ModelAndView buscarRq(String numero) {
		
		 ModelAndView mv = new ModelAndView("rrhh/AsignarRequerimiento");	
		 
		 String error = "";
		 
		 List<RqPorEmpleado> requerimientos = new ArrayList<RqPorEmpleado>();
		 
		 if(Validacion.soloNumero(numero)) {
			 
			 long rq = Long.parseLong(numero);
			 
			 Requerimiento requerimiento = new Requerimiento();
			 
			 requerimiento = requerimientoServicio.traerPorNumero(rq);
			 
			 if(requerimiento == null) {
				 
				 error = "El requerimiento indicado no existe o es un requerimiento antigüo";
				 String form2 = "none";
				 mv.addObject("form2", form2);
			 }else {
				 
				 String form2 = "hidden";
				 mv.addObject("form2", form2);
				 
				 long num = Long.parseLong(numero);
				 
				 requerimientos = requerimientoServicio.asignadosPorNumero(num);
				 
			 }
			 
			
			 
		 }else {
			 
			 
			 error = "Por favor ingrese un número de requerimiento válido";
			 String form2 = "none";
			 mv.addObject("form2", form2);
		 }
		 
		 mv.addObject("requerimientos", requerimientos);
		 mv.addObject("numero", numero);
		 mv.addObject("error", error);
	     return mv;
	
	}
	
	
	@RequestMapping(value = "/agregar-empleado", method = { RequestMethod.POST })
	public ModelAndView agregarEmpleado(String dni, String numero) {
		
		 ModelAndView mv = new ModelAndView("rrhh/AsignarRequerimiento");	
		 
		 String form2 = "hidden";
		 mv.addObject("form2", form2);
		 
		 String error = "";
		 String confirmacion = "";
		 
		 List<RqPorEmpleado> requerimientos = new ArrayList<RqPorEmpleado>();		
		 
		 long rq = Long.parseLong(numero);	
		 
		 Empleado empleado = new Empleado();
		 
		 empleado = empleadoServicio.empleadoPorDni(dni);
		 
		 if(empleado==null) {
			 
			 error = "El empleado ingresado no existe.";
		 }else {
			 
			 
			 
			 if(requerimientoServicio.asignadoAEmpleado(rq, dni)==null) {
			 
				 RqPorEmpleado asignacion = new RqPorEmpleado();
				 
				 Requerimiento requerimiento = new Requerimiento();
				 
				 requerimiento = requerimientoServicio.traerPorNumero(rq);
				 
				 asignacion.setEmpleado(empleado);
				 asignacion.setRequerimiento(requerimiento);
				 
				 try {
					 
					 RqPorEmpleadoServicio.agregar(asignacion);
					 
					 confirmacion = "Se asignó el empleado correctamente, para cargar otro vuelva a ingresar un nuevo empleado.";
					 
				 }catch(Exception e) {
					 
					 error = "Ocurrió un error al asignar el empleado.";
					 
				 }
			 
			 }else {
				 
				 error = "El empleado ya tiene asignado el requerimiento indicado";
			 }
			
		 }
		
		 
		
		
		 requerimientos = requerimientoServicio.asignadosPorNumero(rq);
	
		 mv.addObject("requerimientos", requerimientos);
		 mv.addObject("numero", numero);
		 mv.addObject("errorEmpleado", error);
		 mv.addObject("confirmacion", confirmacion);
		 
	     return mv;
	
	}
	

}
