package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaController extends BaseController{
	
	
	@RequestMapping(value = "/verMercaderias.htm")
	public String verMercaderias(Model model,HttpServletRequest req) {
		model.addAttribute("index", "4");
		return "verMercaderias";
	}
	


}
