package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaController extends BaseController{
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	
	@RequestMapping(value = "/verMercaderias.htm")
	public String verMercaderias(Model model,HttpServletRequest req) {
		model.addAttribute("index", "4");
		return "verMercaderias";
	}
	
	@RequestMapping(value = "/nuevaMercaderia.htm")
	public String nuevaMercaderia(Model model,HttpSession sesion) {
		model.addAttribute("index", "4");
		model.addAttribute("listaUnidadMineraInsumo", this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		return "nuevaMercaderia";
	}
}
