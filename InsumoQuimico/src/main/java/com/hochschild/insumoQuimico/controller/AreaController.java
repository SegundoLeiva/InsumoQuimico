package com.hochschild.insumoQuimico.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/area")
public class AreaController {
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	
	@RequestMapping(value = "/verAreas.htm")
	public String verAreas(Model model,HttpServletRequest req) {
		model.addAttribute("listaUnidadMineraArea", this.unidadMineraAreaService.listaUnidadMineraArea());
		model.addAttribute(Constantes.FLAG_TRANSACCION, req.getAttribute(Constantes.FLAG_TRANSACCION));
		return "verAreas";
	}
	
	@RequestMapping(value = "/agregarArea.htm", method = RequestMethod.POST)
	@ResponseBody
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
		return mensaje;
	}
	
	@RequestMapping(value = "/nuevaArea.htm")
	public String nuevaArea(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaAreas", this.areaService.listaArea());
		return "nuevoArea";
	}

	@RequestMapping(value = "/eliminarUnidadMineraArea.htm", method = RequestMethod.POST)
	public String eliminarUnidadMineraArea(Model model,HttpServletRequest req,
			@RequestParam("idUnidadMineraArea") String idUnidadMineraArea) throws ServletException, IOException {
		try {
			unidadMineraAreaService.eliminarUnidadMineraArea(idUnidadMineraArea);
			req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		} catch (Exception e) {
			req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ERROR);
		}
		
		return this.verAreas(model,req);
	}
	
	@RequestMapping(value = "/modificarArea.htm")
	public String modificarArea(Model model,HttpSession sesion ,@RequestParam("idUnidadMineraArea") String idUnidadMineraArea) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		UnidadMineraArea unidadMineraArea = unidadMineraAreaService.obtieneUnidadMineraAreaPorId(idUnidadMineraArea);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraArea", unidadMineraArea);
		model.addAttribute("listaAreas", this.areaService.listaArea());
		return "nuevoArea";
	}

}
