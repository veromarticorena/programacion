package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import Clases.CierreMensual;
import entidad.Empleado;
import entidad.Licencia;
import entidad.Tarea;
import servicio.EmpleadoServicio;
import servicio.LicenciaServicio;
import servicio.TareaServicio;
import validacion.Validacion;


@Controller
public class CierreMensualControlador {
	
	
	@Autowired 
		TareaServicio tareaServicio;	
	@Autowired
		LicenciaServicio licenciaServicio;
	@Autowired
		EmpleadoServicio empleadoServicio;
	
	String MESES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

	
	@RequestMapping(value = "/buscar-cierre-mes", method = { RequestMethod.POST })
	 public ModelAndView buscarMes(HttpServletRequest request, Integer mes, Integer anio){
		
		ModelAndView mv = new ModelAndView("rrhh/CierreMensual");     
		 
		 
		 List<Empleado> empleados = new ArrayList<Empleado>();
		 
		 empleados = empleadoServicio.empleadosPorRol(1);
		 
		 List<CierreMensual> lista = new ArrayList<CierreMensual>();
		 
		 Calendar fecha = Calendar.getInstance();
	     Integer anioencurso = fecha.get(Calendar.YEAR);
	     
	     String form2 = "hidden";
		 mv.addObject("form2", form2);
	     
	     String nombreMes = MESES[mes-1].toUpperCase();
		 

		 HttpSession misession = request.getSession(true);
		 	
		 
		 if(anio==null) {
			 
			 mv.addObject("erroranio", "Ingrese un año.");
			 
		 }else {
			 
						 
			 for (Empleado e : empleados) {
				 
					List<Licencia> licencias = new ArrayList<Licencia>();
				    List<Tarea> tareas = new ArrayList<Tarea>();	
				    
				    CierreMensual cierre = new CierreMensual();
				    
				 	cierre.setLegajo(e.getLegajo().getIdLegajo());
				 	cierre.setNombre(e.getNombre());
				 	cierre.setApellido(e.getApellido());
				 	
				 	
				 	tareas = tareaServicio.tareasPorEmpleadoYMes(e.getDni(), mes, anio);
				 	
				 	long acumuladorT = 0;
				 	
				 	for (Tarea t : tareas) {
				 		
				 		acumuladorT = acumuladorT+t.getHoras();
														
					}
				 	
				 	cierre.setHoras_trabajadas(acumuladorT);
				 	
				 	//////////////////////////////
				 	
				 	licencias = licenciaServicio.licenciaPorEmpleadoYMes(e.getDni(), mes, anio);
				 	
				 	long acumuladorL = 0;
				 	
				 	for (Licencia l : licencias) {
				 		
				 		acumuladorL = acumuladorL+(l.getCantidadDias()*8);
														
					}
				 	
				 	cierre.setHoras_licencia(acumuladorL);
				 	
				 	cierre.setTotal_horas(cierre.getHoras_licencia()+cierre.getHoras_trabajadas());
				 	
				 	cierre.setValor_total_horas(0);
				 	
				 	lista.add(cierre);
													
				}
			 
			 			
			 
			 
			 misession.setAttribute("cierre", lista);
			
			 
		 }	 
		 
		 misession.setAttribute("anioencurso", anioencurso);
		 misession.setAttribute("anio", anio);
		 misession.setAttribute("nombreMes", nombreMes);
		 mv.addObject("form2", form2);
		 return mv;
		 
	 }
	
	

			
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value = "/calcular", method = { RequestMethod.POST })
			 public ModelAndView calcular(HttpServletRequest request, String valor){
				
				ModelAndView mv = new ModelAndView("rrhh/CierreMensual");   			 
				 
						
				 List<CierreMensual> lista = new ArrayList<CierreMensual>();
				 List<CierreMensual> aux = new ArrayList<CierreMensual>();
				 
					 
			     String form2 = "hidden";
				 mv.addObject("form2", form2);
			     
				 HttpSession misession = request.getSession(true);
				 
				 lista = (List<CierreMensual>) misession.getAttribute("cierre");
				 	
				 
				 if(valor.isEmpty()||!Validacion.soloNumero(valor)) {
					 
					 mv.addObject("errorValor", "Ingrese un valor para calcular sin decimales.");
					 
				 }else {
					 
					 float valorHora = Float.parseFloat(valor);
					 
								 
					 for (CierreMensual c : lista) {
						 
						 float total = c.getTotal_horas()*valorHora;
						 
							c.setValor_total_horas(total);
							
							aux.add(c);
															
						}			 			
					 
					 
					 misession.setAttribute("cierre", aux);
					
					 
				 }	 
				 
				
				 mv.addObject("form2", form2);
				 mv.addObject("valor", valor);
				 
			     return mv;
				 
			 }
			
			
			@SuppressWarnings("unchecked")
			@RequestMapping(value = "/descargar", method = { RequestMethod.GET })
			 public void descargar(HttpServletResponse response,HttpServletRequest request, Integer anio) throws IOException{
				
				 HttpSession misession = request.getSession(true);
				 String nombreMes = (String) misession.getAttribute("nombreMes");
			     String csvFileName = "cierre"+nombreMes+anio+".csv";
			     
			     List<CierreMensual> lista = new ArrayList<CierreMensual>();	        
			     lista = (List<CierreMensual>) misession.getAttribute("cierre");
			     
			     
			     response.setContentType("text/csv");
			 
			        // creates mock data
			        String headerKey = "Content-Disposition";
			        String headerValue = String.format("attachment; filename=\"%s\"",
			                csvFileName);
			        response.setHeader(headerKey, headerValue);
			 
			       			        
			        
			        // uses the Super CSV API to generate CSV data from the model data
			        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			                CsvPreference.STANDARD_PREFERENCE);
			 
			        String[] header = { "legajo", "nombre", "apellido", "horas_licencia", "horas_trabajadas",
			                "valor_total_horas" };
			 
			        csvWriter.writeHeader(header);
			 
			        for (CierreMensual c : lista) {
			            csvWriter.write(c, header);
			        }
			 
			        csvWriter.close();
				
				return;
				
				
			}
			

}
