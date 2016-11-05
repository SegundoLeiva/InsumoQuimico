package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	protected final Log logger = LogFactory.getLog(getClass());


	@RequestMapping(value = "/login.htm")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("templatelogin");
	}
	
	
	@RequestMapping(value="/list.htm", method=RequestMethod.GET )
	public String processSubmit() {
		return "redirect:/sistema/listarproductos.htm";
	}
	
	
	@RequestMapping(value = "/accessDenied.htm")
	public ModelAndView accessDenied(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error403");
	}
	
	@RequestMapping(value = "/noFound.htm")
	public ModelAndView noFound(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error404");
	}
	
	
	
	
	
	
	

}
