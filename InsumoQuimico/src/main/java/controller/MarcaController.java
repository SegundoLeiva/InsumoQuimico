package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/marca")
public class MarcaController {

	@RequestMapping(value = "/verMarcas.htm")
	public String verMarcas(HttpSession sesion, Model model)
			throws ServletException, IOException {
		model.addAttribute("index", "2");
		return "verMarcas";
	}

}
