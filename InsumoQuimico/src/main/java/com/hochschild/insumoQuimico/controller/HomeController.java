package com.hochschild.insumoQuimico.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hochschild.insumoQuimico.domain.Usuario;

import service.UsuarioService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UsuarioService usuarioService;

	  @RequestMapping(value = "/configuracion.htm")
	    public ModelAndView cambiarcontra(HttpServletRequest request,
	            HttpServletResponse response, Authentication auth)
	            throws ServletException, IOException {

	      
	        return new ModelAndView("cambiarContra");
	    }
	  
	    @RequestMapping(value = "/cambiar_password.htm", method = RequestMethod.POST)
	    public ModelAndView changePassword(@RequestParam("passwordActual") String passwordActual,
	            @RequestParam("nuevaPassword") String nuevaPassword,
	            Authentication auth) {


//	        String dni = auth.getName();
	    	String cod_usu = "LC019";
	        Boolean resultado = this.usuarioService.validarPassword(passwordActual, cod_usu);
	        if (resultado) {
	            this.usuarioService.cambiarPassword(nuevaPassword, cod_usu);
	            return new ModelAndView("redirect:/sistema/configuracion.htm?success=true");
	        } else {
	            return new ModelAndView("redirect:/sistema/configuracion.htm?error=true");
	        }

	    }
	    
	    @RequestMapping(value = "/bienvenida.htm")
	    public String bienvenida(HttpSession sesion){
	    	 Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
	         if (usuarioSession != null){  
	        	 
	        	 return "panelPrincipal";
	         }else{
	             return "redirect:/logout.htm";
	         }        
	    }
}
