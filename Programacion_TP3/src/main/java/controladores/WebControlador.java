package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebControlador {
	
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
}
