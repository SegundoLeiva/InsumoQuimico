package com.hochschild.insumoQuimico.controller.unidadMineraInsumo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/unidadMineraInsumo")
public class UnidadMineraInsumoMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
	private InsumoService insumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoUnidadMineraInsumo";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		return model;
	}
	
	@RequestMapping(value = "/agregarUnidadMineraInsumo.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarInsumo(UnidadMineraInsumoParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
	
		return unidadMineraInsumoService.insertarUnidadMineraInsumo(data);
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		UnidadMineraInsumo unidadMineraInsumo = unidadMineraInsumoService.obtieneUnidadMineraInsumoPorId(id);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraInsumo", unidadMineraInsumo);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		return model;
	}

	@Override
	public Object getFormMantenimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setGrabarAttributes() {
		// TODO Auto-generated method stub
		return false;
	}

}
