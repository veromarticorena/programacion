package controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import entidad.Licencia;
import entidad.Requerimiento;
import entidad.Tarea;
import servicio.EmpleadoServicio;
import servicio.LicenciaServicio;
import servicio.RequerimientoServicio;
import servicio.TareaServicio;

@Controller
public class TareaControlador {
	
	
	@Autowired 
		TareaServicio tareaServicio;	
	@Autowired
		LicenciaServicio licenciaServicio;
	@Autowired
		EmpleadoServicio empleadoServicio;
	@Autowired
		RequerimientoServicio requerimientoServicio;
	
	String MESES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};


	
	//Busco tareas y licencias por mes y año indicado
	
	@RequestMapping(value = "/buscar-por-mes", method = { RequestMethod.POST })
	 public ModelAndView buscarMes(HttpServletRequest request, @RequestParam(value = "dni") String dni, Integer mes, Integer anio){
		
		ModelAndView mv = new ModelAndView("desarrollador/Tareas");
		 String form2 = "none";
		 mv.addObject("form2", form2);	 
	      
		 List<Licencia> licencias = new ArrayList<Licencia>();
		 List<Tarea> tareas = new ArrayList<Tarea>();
		 
		 HttpSession misession = request.getSession(true);
		 
		 if(anio==null) {
			 
			 mv.addObject("erroranio", "Ingrese un año.");
			 
		 }else {
			 
			 tareas = tareaServicio.tareasPorEmpleadoYMes(dni, mes, anio);
			 licencias = licenciaServicio.licenciaPorEmpleadoYMes(dni,mes,anio);
			 
			
			 misession.removeAttribute("SessionLicencias");			
			 misession.removeAttribute("SessionTareas");
			
			 
			 misession.setAttribute("SessionLicencias", licencias);			
			 misession.setAttribute("SessionTareas", tareas);
			 
		 }	 
		 
		 
	     return mv;
		 
	 }
	
	
	
	//busco tareas y licencias por fecha especifica
	
	@RequestMapping(value = "/buscar-por-fecha", method = { RequestMethod.POST })
	 public ModelAndView buscarFecha(@RequestParam(value = "fecha") Date fecha,@RequestParam(value = "dni") String dni, HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("desarrollador/Tareas");
		 String form2 = "hidden";
		 mv.addObject("form2", form2); 
	     
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
		 
		 requerimientos =  requerimientoServicio.habilitadosPorEmpleado(dni);
		 
		 HttpSession session = request.getSession(true);
		
		 
		 List<Licencia> licencias = new ArrayList<Licencia>();
		 List<Tarea> tareas = new ArrayList<Tarea>();
		 Licencia lic = new Licencia();
		 lic = licenciaServicio.licenciaPorEmpleadoYFecha(dni, fecha);
		 
		 tareas = tareaServicio.tareasPorEmpleadoYFecha(dni, fecha);
		 
		 if (lic!=null) {
			 
			 licencias.add(lic);
			 System.out.println("guarda");
		 }
		 
		 session.removeAttribute("SessionTareas");
		 session.removeAttribute("SessionLicencias");
		 
		 session.setAttribute("SessionTareas", tareas);
		 session.setAttribute("SessionLicencias", licencias);
		 
		 mv.addObject("fecha", fecha);
		 mv.addObject("requerimientos", requerimientos);
	     return mv;
		 
	 }
	 
	
	//elimino tarea
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = {"/eliminar-tarea"}, method = { RequestMethod.GET })
	 public ModelAndView eliminar(HttpServletRequest request, 
			 @RequestParam(value = "fecha") String fecha,
			 @RequestParam(value = "id") Long id, 
			 @RequestParam(value = "dni") String dni) throws ParseException{
		
		 ModelAndView mv = new ModelAndView("desarrollador/Tareas");
				 
		 String mensaje = "";
		 String error = ""; 
		
		 HttpSession session = request.getSession(true);
			
		 List<Tarea> tareas = new ArrayList<Tarea>();	 
		 
		 tareas = (List<Tarea>) session.getAttribute("SessionTareas");	
		 
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
		 
		 requerimientos =  requerimientoServicio.habilitadosPorEmpleado(dni);
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			date  = formatter.parse(fecha);		
			java.sql.Date ingresada = new java.sql.Date(date.getTime());
			
			Tarea tarea = new Tarea();
		 
		 try {		 
			 
			 tarea = tareaServicio.traer(ingresada, id, dni);	
			 
			 tareaServicio.eliminar(tarea); 			 
			 
			 
			 mensaje = "Se eliminó la tarea asignada correctamente."; 
			 
			 
			 
		 }catch (Exception e ) {
			 
			 error = "Ocurrio un error al eliminar la tarea asignada.";
			 
		 }finally {
			
			 mv.addObject("mensaje", mensaje);
			 mv.addObject("error", error);
			 mv.addObject("requerimientos", requerimientos);
			 mv.addObject("fecha", fecha);
		 }
		 
		 List<Tarea> aux = new ArrayList<Tarea>();	
		 
		 for (Tarea t : tareas) {
				
				
				if(!(t.getRequerimiento().getIdRequerimiento()==tarea.getRequerimiento().getIdRequerimiento()&&t.getFecha().equals(tarea.getFecha())&&t.getEmpleado().getDni().equals(dni))) {
					
					aux.add(t);
					
				}
							
			}
		
					
		
		 session.removeAttribute("SessionTareas");
		 session.setAttribute("SessionTareas", aux);
		 return mv;
		 
	 }
	
	
	//guardo tarea
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/guardar-tarea", method = { RequestMethod.POST })
	 public ModelAndView guardarTarea(@RequestParam(value = "fecha") Date fecha,@RequestParam(value = "dni") String dni,
			 @RequestParam(value = "rq") Long id, 
			 @RequestParam(value = "horas") Integer horas, 
			 HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("desarrollador/Tareas");
		 String form2 = "hidden";
		 mv.addObject("form2", form2);
		 String error = "";
		 String mensaje = "";
		 
		 HttpSession session = request.getSession(true);
		
		 List<Tarea> tareas = new ArrayList<Tarea>();	 
		 
		 tareas = (List<Tarea>) session.getAttribute("SessionTareas");	
		 
		 	 
		 Licencia licencia = licenciaServicio.licenciaPorEmpleadoYFecha(dni,fecha);
		 
		 Tarea aux = tareaServicio.traer(fecha, id, dni);
		 
		 List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
		 
		 requerimientos =  requerimientoServicio.habilitadosPorEmpleado(dni);
		 
		 if (licencia!=null||aux!=null) {
			 
			 error = "En la fecha seleccionada hay cargada una licencia o ya está cargado el mismo requermiento."; 
			 mv.addObject("requerimientos", requerimientos);
			 mv.addObject("form2", form2);
			 mv.addObject("error", error);
			 mv.addObject("fecha", fecha);
			 mv.addObject("idRequerimiento", id);
			 
		 }else {
			 
			 
			 
			Integer sumahoras = tareaServicio.horasPorFecha(fecha, dni);		
			 
			 if(sumahoras+horas>12) {
				 
				 error = "No se puede cargar la cantidad de horas ya que supera las 12 horas de trabajo.";
				 mv.addObject("form2", form2);
				 mv.addObject("error", error);
				 mv.addObject("fecha", fecha);
				 mv.addObject("idRequerimiento", id);
				 mv.addObject("requerimientos", requerimientos);
				 
			 }else {
				 
				 Requerimiento requerimiento = new Requerimiento();
				 requerimiento = requerimientoServicio.traer(id);
				 
				 Empleado empleado = new Empleado();
				 empleado = empleadoServicio.empleadoPorDni(dni);
				 
				 Tarea tarea = new Tarea();
				 
				 
				 tarea.setEmpleado(empleado);
				 tarea.setRequerimiento(requerimiento);
				 tarea.setFecha(fecha);
				 tarea.setHoras(horas);
				 
				 try {
					 
					 tareaServicio.agregar(tarea);
					 mensaje = "Se agregó la tarea correctamente. Se podrá visualizar en la planilla";
					 tareas.add(tarea);
					 session.removeAttribute("SessionTareas");
					 session.setAttribute("SessionTareas", tareas);
					 
				 }catch (Exception e) {
					 
					error = "Ocurrio un error al guardar la tarea, por favor intente más tarde."; 
				 }finally {
					 
					 mv.addObject("form2", form2); 
					 mv.addObject("error", error);
					 mv.addObject("mensaje", mensaje);
					 mv.addObject("fecha", fecha);
					 mv.addObject("idRequerimiento", id);
					 mv.addObject("requerimientos", requerimientos);				 
					 
				 }
			 }
		 }
		   
		
		 
		
	     return mv;
		 
	 }
	
	//**********************************************************************
	// CONTROLADOR DE TAREAS PARA LA PARTE DE RRHH
	//**********************************************************************
	
	//busco solo las tareas por mes
	
	
	@RequestMapping(value = "/buscar-solo-tareas-por-mes", method = { RequestMethod.POST })
	 public ModelAndView buscarTareasPorMes(@RequestParam(value = "dni") String dni, Integer mes, Integer anio, HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("rrhh/Tareas");
		 String form2 = "none";
		 mv.addObject("form2", form2);	 
	      
		 HttpSession session = request.getSession(true);
		 
		 List<Tarea> tareas = new ArrayList<Tarea>();
		 
		 String nombreMes = MESES[mes-1];
		 
		 if(anio==null) {
			 
			 mv.addObject("erroranio", "Ingrese un año.");
			 
		 }else {
			 
			 tareas = tareaServicio.tareasPorEmpleadoYMes(dni, mes, anio);		 
				
			 session.setAttribute("sTareas", tareas);			
						 
		 }	 
		 
		 mv.addObject("mes", mes);
		 mv.addObject("anio", anio);
		 mv.addObject("nombreMes", nombreMes);
	     return mv;
		 
	 }
	
	
	//busco el empleado y traigo las tareas del mes en curso
	
	@RequestMapping(value = "/buscar-empleado-tareas", method = { RequestMethod.POST })
	 public ModelAndView buscarEmpleado(@RequestParam(value = "dni") String dni, HttpServletRequest request){
		
		 ModelAndView mv = new ModelAndView("rrhh/Tareas");
				 
		 Empleado ingresado = new Empleado();
		 
		 HttpSession session = request.getSession(true);
		 
		 Calendar fecha = Calendar.getInstance();
	     Integer anioencurso = fecha.get(Calendar.YEAR);
	     Integer mes = fecha.get(Calendar.MONTH) + 1;  
	     
	     String nombreMes = MESES[mes-1].toUpperCase();
	     
	     List<Tarea> tareas = new ArrayList<Tarea>();
		 
		 ingresado = empleadoServicio.empleadoPorDni(dni);
		 
		 if(ingresado == null) {
			 mv.addObject("form2", "none");
			 mv.addObject("errorDni", "El DNI ingresado no existe o no es correcto");
			 
		 }else {
			 mv.addObject("form2", "hidden");			 
			 mv.addObject("ingresado",ingresado);	
			 
			 tareas = tareaServicio.tareasPorEmpleadoYMes(dni, mes, anioencurso);
		 }
		 
		 mv.addObject("dni",dni);
		 session.setAttribute("sTareas", tareas);			
		 mv.addObject("mes",mes);
		 mv.addObject("anioencurso",anioencurso);
		 mv.addObject("nombreMes",nombreMes);
		 
		 			      
	 
	     return mv;
		 
	 }
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = {"/eliminar-tarea-rrhh"}, method = { RequestMethod.GET })
	 public ModelAndView eliminarRRHH(HttpServletRequest request, 
			 @RequestParam(value = "fecha") String fecha,
			 @RequestParam(value = "id") Long id, 
			 @RequestParam(value = "dni") String dni) throws ParseException{
		
		 ModelAndView mv = new ModelAndView("rrhh/Tareas");
				 
		 String mensaje = "";
		 String error = ""; 
		
		 HttpSession session = request.getSession(true);
			
		 List<Tarea> tareas = new ArrayList<Tarea>();	 
		 
		 tareas = (List<Tarea>) session.getAttribute("sTareas");	
		 
		 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			date  = formatter.parse(fecha);		
			java.sql.Date ingresada = new java.sql.Date(date.getTime());
			
			Tarea tarea = new Tarea();
		 
		 try {		 
			 
			 tarea = tareaServicio.traer(ingresada, id, dni);	
			 
			 tareaServicio.eliminar(tarea); 			 
			 
			 
			 mensaje = "Se eliminó la tarea asignada correctamente."; 
			 
			 
			 
		 }catch (Exception e ) {
			 
			 error = "Ocurrio un error al eliminar la tarea asignada.";
			 
		 }finally {
			
			 mv.addObject("mensaje", mensaje);
			 mv.addObject("error", error);
			 mv.addObject("fecha", fecha);
		 }
		 
		 List<Tarea> aux = new ArrayList<Tarea>();	
		 
		 for (Tarea t : tareas) {				
				
				if(!(t.getRequerimiento().getIdRequerimiento()==tarea.getRequerimiento().getIdRequerimiento()&&t.getFecha().equals(tarea.getFecha())&&t.getEmpleado().getDni().equals(dni))) {
					
					aux.add(t);
					
				}
							
			}
		
					
		
		 session.removeAttribute("sTareas");
		 session.setAttribute("sTareas", aux);
		 return mv;
		 
	 }
	 

}
