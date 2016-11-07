package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;

@Controller
@RequestMapping(value = "/area")
public class AreaController {
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@RequestMapping(value = "/verAreas.htm")
	public String verAreas(HttpSession sesion, Model model)
			throws ServletException, IOException {
		model.addAttribute("listaAreas", this.unidadMineraAreaService.listaUnidadMineraArea());
		model.addAttribute("index", "3");
		return "verAreas";
	}

}
