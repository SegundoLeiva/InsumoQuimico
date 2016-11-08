package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;

@Controller
@RequestMapping(value = "/area")
public class AreaController extends BaseController{
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/verAreas.htm")
	public String verAreas(Model model,HttpServletRequest req) {
		model.addAttribute("listaUnidadMineraArea", this.unidadMineraAreaService.listaUnidadMineraArea());
		model.addAttribute("listaAreas", this.areaService.listaArea());
		model.addAttribute(Constantes.FLAG_TRANSACCION, req.getAttribute(Constantes.FLAG_TRANSACCION));
		model.addAttribute("index", "3");
		return "verAreas";
	}
	
	@RequestMapping(value = "/agregarArea.htm", method = RequestMethod.POST)
	public String agregarArea(AreaParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdUnidadMineraArea())){
				unidadMineraAreaService.insertarUnidadMineraArea(data);
			}else{
				unidadMineraAreaService.actualizarUnidadMineraArea(data);
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}
		} catch (Exception e) {
			mensaje = Constantes.TRANSACCION_ERROR;
		}		
		req.setAttribute(Constantes.FLAG_TRANSACCION, mensaje);
		return this.verAreas(model,req);
	}

	@RequestMapping(value = "/eliminarUnidadMineraArea.htm", method = RequestMethod.POST)
	public String eliminarUnidadMineraArea(Model model,HttpServletRequest req,
			@RequestParam("idUnidadMineraArea") String idUnidadMineraArea) throws ServletException, IOException {

		unidadMineraAreaService.eliminarUnidadMineraArea(idUnidadMineraArea);
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		return this.verAreas(model,req);
	}
	
	@RequestMapping(value = "/obtenerUnidadMineraArea.htm", method = RequestMethod.POST)
	public @ResponseBody String obtenerUnidadMineraArea(
			@RequestParam("idUnidadMineraArea") String idUnidadMineraArea) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String resultado = objectMapper.writeValueAsString(unidadMineraAreaService.obtieneUnidadMineraAreaPorId(idUnidadMineraArea));

		return resultado;
	}

}
