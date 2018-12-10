package controladores;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import entidad.Legajo;
import entidad.Rol;
import error.ErrorEmpleado;
import servicio.EmpleadoServicio;
import servicio.RolServicio;
import validacion.ValidarEmpleado;


@Controller
public class EmpleadoControlador {
	
	@Autowired
	EmpleadoServicio empleadoServicio;
	
	@Autowired
	RolServicio rolServicio;
	

	@RequestMapping(value = "/guardar-empleado", method = { RequestMethod.POST })
	 public ModelAndView guardarEmpleado(String dni, String nombre, String apellido, String email, String telefono, String fechaNac, String fechaIng, 
			 String contrasenia,  @RequestParam(value = "rol") Long rol){
		
		
			Empleado empleado = new Empleado();
			Legajo legajo = new Legajo();
			Rol rolObj = new Rol();
			rolObj = rolServicio.traer(rol);
						
			ErrorEmpleado validacion = new ErrorEmpleado();
		
			ModelAndView mv = new ModelAndView("rrhh/AltaDesarrollador");
		
			
			
			if(!nombre.isEmpty()&&!apellido.isEmpty()&&!dni.isEmpty()&&!email.isEmpty()&&!fechaIng.isEmpty()&&!fechaNac.isEmpty()&&!telefono.isEmpty()&&!contrasenia.isEmpty()) {
				
				validacion = ValidarEmpleado.datos(dni, nombre, apellido, telefono, email);
				
				if(validacion.getOk()) {
					
					Empleado existeUsuario = new Empleado();
					
					existeUsuario = empleadoServicio.empleadoPorDni(dni);
										
					if(existeUsuario == null ) {
					
						try {
							
							
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date date = null;
							java.util.Date dateIng = null;
							date  = formatter.parse(fechaNac);	
							dateIng  = formatter.parse(fechaIng);
							java.sql.Date nacimiento = new java.sql.Date(date.getTime());
							java.sql.Date ingreso = new java.sql.Date(dateIng.getTime());
							
							legajo.setContrasenia(contrasenia);
							legajo.setRol(rolObj);
							legajo.setHabilitado(true);
							empleado.setApellido(apellido);
						    empleado.setDni(dni);
							empleado.setEmail(email);
							empleado.setFechaNac(nacimiento);
							empleado.setFechaIngreso(ingreso);
							empleado.setNombre(nombre);
							empleado.setTelefono(telefono);
							empleado.setHabilitado(true);	
							empleado.setSaldoExamen(28);
							empleado.setSaldoVacaciones(15);
							empleado.setLegajo(legajo);
							
							empleadoServicio.agregar(empleado);
							
							mv.addObject("mensaje", "Se registró el nuevo empleado.");
							
							mv.addObject("dni", dni);
							mv.addObject("nombre", nombre);
							mv.addObject("apellido", apellido);
							mv.addObject("email", email);
							mv.addObject("fechaNac", fechaNac);
							mv.addObject("fechaIng", fechaIng);
							mv.addObject("telefono", telefono);
							mv.addObject("contrasenia", contrasenia);
						
						} catch(Exception ex) {
							
							mv.addObject("dni", dni);
							mv.addObject("nombre", nombre);
							mv.addObject("apellido", apellido);
							mv.addObject("email", email);
							mv.addObject("fechaNac", fechaNac);
							mv.addObject("fechaIng", fechaIng);
							mv.addObject("telefono", telefono);
							mv.addObject("contrasenia", contrasenia);
							
							mv.addObject("error", "No se ha podido registrar el nuevo cliente.");
						}
						
					}else {
						
						mv.addObject("error", "El documento ingresado ya existe en el sistema.");
					}
					
				}else {
					
					mv.addObject("dni", dni);
					mv.addObject("nombre", nombre);
					mv.addObject("apellido", apellido);					
					mv.addObject("email", email);
					mv.addObject("fechaNac", fechaNac);
					mv.addObject("fechaIng", fechaIng);
					mv.addObject("telefono", telefono);
					mv.addObject("contrasenia", contrasenia);					
					mv.addObject("validacion", validacion);			
					
				}
			
			}else {
				
				validacion.setCamposObligatorios("*Todos los campos son obligatorios");
				mv.addObject("validacion", validacion);	
			}
			
		
		 return mv;
	 }

}
