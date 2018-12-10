package controladores;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entidad.Empleado;
import entidad.Licencia;
import entidad.Tarea;
import entidad.TipoLicencia;
import servicio.EmpleadoServicio;
import servicio.LicenciaServicio;
import servicio.TareaServicio;
import servicio.TipoLicenciaServicio;

@Controller
public class LicenciaControlador {
	
	@Autowired
		LicenciaServicio licenciaServicio;
	@Autowired
		EmpleadoServicio empleadoServicio;
	@Autowired 
		TareaServicio tareaServicio;
	@Autowired 
		TipoLicenciaServicio tipoLicenciaServicio;		
	@Autowired
		JavaMailSender mailSender;
	
	
	//Busco el empleado y habilito el formulario para que cargue una licencia
	
	@RequestMapping(value = "/buscar-empleado", method = { RequestMethod.POST })
	 public ModelAndView buscarMes(@RequestParam(value = "dni") String dni){
		
		 ModelAndView mv = new ModelAndView("rrhh/Licencias");
				 
		 Empleado ingresado = new Empleado();
		 
		 ingresado = empleadoServicio.empleadoPorDni(dni);
		 
		 if(ingresado == null) {
			 mv.addObject("form2", "none");
			 mv.addObject("errorDni", "El DNI ingresado no existe o no es correcto");
			 
		 }else {
			 mv.addObject("form2", "hidden");
			 List<Licencia> licencias = new ArrayList<Licencia>();
			 licencias = licenciaServicio.licenciaPorEmpleado(dni); 
			 
			 List<TipoLicencia> tipoLicencias = new ArrayList<TipoLicencia>();
			 tipoLicencias = tipoLicenciaServicio.listar();
			 
			 mv.addObject("licencias",licencias);
			 mv.addObject("tipoLicencias",tipoLicencias);
			 mv.addObject("ingresado",ingresado);
			 
			 
		 }
		 
		 mv.addObject("dni",dni);
		 			      
	 
	     return mv;
		 
	 }
	
	
	//Guardo la licencia	
	
	@RequestMapping(value = "/guardar-licencia", method = { RequestMethod.POST })
	 public ModelAndView guardarTarea(@RequestParam(value = "fechaInicio") String fecha1,@RequestParam(value = "fechaFin") String fecha2, @RequestParam(value = "dni") String dni,
			 @RequestParam(value = "tipo") Long tipo, 
			 @RequestParam(value = "dias") Integer dias) throws ParseException{
		
		ModelAndView mv = new ModelAndView("rrhh/Licencias");
		 String form2 = "hidden";
		 mv.addObject("form2", form2);
		 String error = "";
		 String mensaje = "";
		 
		 	 
		 List<Licencia> licencias = licenciaServicio.licenciaPorEmpleado(dni);
		 
		 List<TipoLicencia> tipoLicencias = new ArrayList<TipoLicencia>();
		 tipoLicencias = tipoLicenciaServicio.listar();
		 
		 Empleado empleado = new Empleado();
		 Licencia licencia = new Licencia();
		 Licencia aux1 = new Licencia();
		 Licencia aux2 = new Licencia();
		 
		 List<Tarea> tareas = new ArrayList<Tarea>();
		 TipoLicencia tipoLicencia = new TipoLicencia();
		 
		 
		 empleado = empleadoServicio.empleadoPorDni(dni);
		 tipoLicencia = tipoLicenciaServicio.traer(tipo);
		 
		 mv.addObject("idTipo", tipo); 
		 mv.addObject("fechaFin", fecha2);
		 mv.addObject("fechaInicio", fecha1);
		 mv.addObject("idTipo", tipo);
		 mv.addObject("licencias", licencias);
		 mv.addObject("tipoLicencias", tipoLicencias);
		 mv.addObject("dni", dni);
		 
		 
		 mv.addObject("ingresado", empleado);
		 
		 
		 
		 
		 if(fecha1 == null || fecha2 == null || dias == null) {
			 
			 error = "Todos los campos son obligatorios";
			 mv.addObject("error", error);
		 }else {
			 
			 
			
			 
			 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date f1 = null;
				f1  = formatter.parse(fecha1);		
				java.sql.Date fechaInicio = new java.sql.Date(f1.getTime());
				
				java.util.Date  f2 = null;
				f2  = formatter.parse(fecha2);		
				java.sql.Date fechaFin = new java.sql.Date(f2.getTime());
			 
			 if(fechaFin.after(fechaInicio)||fechaFin.equals(fechaInicio)) {
				 
				 aux1 = licenciaServicio.licenciaPorEmpleadoYFecha(dni, fechaInicio);
				 
				 aux2 = licenciaServicio.licenciaPorEmpleadoYFecha(dni, fechaFin);
				 
				 tareas = tareaServicio.tareasPorRango(dni, fechaInicio,fechaFin);
				 
				 
				 if (aux1!=null || aux2!=null || !tareas.isEmpty()) {
					 
					 error = "El empleado tiene una licencia o una tarea asignada en el rango de las fechas indicadas.";
					 
					 
				 }else {
					  
					 
					 	try {		 
							
						 
						 if(tipoLicencia.getDescripcion().toUpperCase().equals("VACACIONES")) {
							 
							
							 
							 if(dias<=empleado.getSaldoVacaciones()) {
								 
								 licencia.setCantidadDias(dias);
								 licencia.setEmpleado(empleado);
								 licencia.setFechaFin(fechaFin);
								 licencia.setFechaInicio(fechaInicio);
								 licencia.setTipoLicencia(tipoLicencia);
								 
								 licenciaServicio.agregar(licencia);
								 empleado.setSaldoVacaciones(empleado.getSaldoVacaciones()-dias);
								 empleadoServicio.modificar(empleado);
								 
								 mensaje = "La licencia se guardó correctamente";
								 
								 this.enviarNotificacion(empleado, licencia);
								
								 
							 }else {
								 
								 error = "El empleado no tiene disponible la cantidad de días solicitados."; 
								
							 }
						 }else if(tipoLicencia.getDescripcion().toUpperCase().equals("DIA DE ESTUDIO")) {
							 
							 
							
							 
							 if(dias<=empleado.getSaldoExamen()) {
								 licencia.setCantidadDias(dias);
								 licencia.setEmpleado(empleado);
								 licencia.setFechaFin(fechaFin);
								 licencia.setFechaInicio(fechaInicio);
								 licencia.setTipoLicencia(tipoLicencia);
								 
								 licenciaServicio.agregar(licencia);
								 empleado.setSaldoExamen(empleado.getSaldoExamen()-dias);
								 empleadoServicio.modificar(empleado);
								 
								 mensaje = "La licencia se guardó correctamente";
								
								 this.enviarNotificacion(empleado, licencia);
								 
							 }else {
								 
								 error = "El empleado no tiene disponible la cantidad de días solicitados."; 
								 
							 }
							 
						 }else {
							 
							 licencia.setCantidadDias(dias);
							 licencia.setEmpleado(empleado);
							 licencia.setFechaFin(fechaFin);
							 licencia.setFechaInicio(fechaInicio);
							 licencia.setTipoLicencia(tipoLicencia);
							 
							 licenciaServicio.agregar(licencia);
							 
							 mensaje = "La licencia se guardó correctamente";
							 this.enviarNotificacion(empleado, licencia);
							 
						 }
					 
					 }catch(Exception e) {
						 
						 error = "Ocurrió un eror al agregar la licencia.";
						
					 }
					 
				 }
				 
			 }else {
				 
				 error = "La fecha de fin no puede ser anterior a la fecha de inicio.";
				
			 }
				 
			 
			
			 
		 }
		 
		 
		 mv.addObject("mensaje", mensaje);
		 mv.addObject("error", error);
		 
		 licencias = licenciaServicio.licenciaPorEmpleado(dni);
		 mv.addObject("licencias",licencias);	 
		
	     return mv;
		 
	 }
	
	//envio el mail
	
	
	public void enviarNotificacion(Empleado empleado, Licencia licencia) {
		
		
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(empleado.getEmail());
		message.setSubject("Nueva licencia cargada: " + licencia.getTipoLicencia().getDescripcion());
		message.setText("Estimado/a empleado/a: Se cargó una nueva licencia por "+licencia.getTipoLicencia().getDescripcion()+". Fecha de inicio:"+licencia.getFechaInicio()+
				". Fecha de fin: "+licencia.getFechaFin()+". Cantidad de días: "+licencia.getCantidadDias()+". Por cualquier duda, por favor contactarse con RRHH. Gracias.");
		mailSender.send(message);
	}
	
	
	@RequestMapping(value = {"/eliminar-licencia"}, method = { RequestMethod.GET })
	 public ModelAndView eliminarRRHH(HttpServletRequest request, 
			 @RequestParam(value = "fechaInicio") String fecha1,
			 @RequestParam(value = "fechaFin") String fecha2, 
			 @RequestParam(value = "dni") String dni) throws ParseException{
		
		 ModelAndView mv = new ModelAndView("rrhh/Licencias");
				 
		 String mensaje = "";
		 String error = ""; 
		 
		 Empleado empleado = new Empleado();
		 empleado = empleadoServicio.empleadoPorDni(dni);
		
				
		 List<Licencia> licencias = new ArrayList<Licencia>();
		 Licencia licencia = new Licencia();
	
		 
		 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date f1 = null;
			f1  = formatter.parse(fecha1);		
			java.sql.Date fechaInicio = new java.sql.Date(f1.getTime());
			
						
		 
		 try {		 
			 
			 licencia = licenciaServicio.licenciaPorEmpleadoYFecha(dni, fechaInicio);
			 
			 String tipo = licencia.getTipoLicencia().getDescripcion().toUpperCase();
			 
			 
			 licenciaServicio.eliminar(licencia);
			 
			 if(tipo.equals("VACACIONES")) {
				 
				 empleado.setSaldoVacaciones(empleado.getSaldoVacaciones()+licencia.getCantidadDias());
				 
			 }
			 
			if(tipo.equals("DIA DE ESTUDIO")) {
				 
				 empleado.setSaldoExamen(empleado.getSaldoExamen()+licencia.getCantidadDias());
				 
			 }		  			 
			 
			 empleadoServicio.modificar(empleado);
			 
			 mensaje = "Se eliminó la licencia asignada correctamente."; 
			 
			 
			 
		 }catch (Exception e ) {
			 
			 error = "Ocurrio un error al eliminar la licencia asignada.";
			 
		 }finally {
			
			 mv.addObject("mensaje", mensaje);
			 mv.addObject("error", error);
			
		 }
		 
		 licencias = licenciaServicio.licenciaPorEmpleado(dni);
		 
		 mv.addObject("licencias",licencias);
		 
		 return mv;
		 
	 }

}
