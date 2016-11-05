package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/marca")
public class MarcaController {
	protected final Log logger = LogFactory.getLog(getClass());
//	@Autowired
//	private MarcaDao marcaDao;


	@RequestMapping(value = "/verMarcas.htm")
	public String verMarcas(HttpSession sesion, Model model)
			throws ServletException, IOException {
//		model.addAttribute("listaMarcas", this.marcaDao.getlistamaetab(2));
		model.addAttribute("index", "2");
		return "verMarcas";
	}

}
