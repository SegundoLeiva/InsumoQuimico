package com.hochschild.insumoQuimico.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/registrarConsumo")
public class RegistrarConsumoController extends BaseController{
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	
	@RequestMapping(value = "/verConsumos.htm")
	public String verConsumos(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        model.addAttribute("index", Constantes.REGISTRAR_CONSUMO);
		return "verConsumos";
	}
	
	@RequestMapping(value = "/nuevoConsumo.htm")
	public String nuevoConsumo(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        model.addAttribute("index", Constantes.REGISTRAR_CONSUMO);
		model.addAttribute("listaUnidadMineraInsumo", this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		return "nuevoConsumo";
	}
}
