package com.hochschild.insumoQuimico.controller.unidadMineraArea;

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
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.UnidadMineraAreaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/unidadMineraArea")
public class UnidadMineraAreaMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaUnidadMineraArea";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaAreas", this.areaService.listaArea());
		return model;
	}
	
	@RequestMapping(value = "/agregarUnidadMineraArea.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarArea(UnidadMineraAreaParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
	
		return unidadMineraAreaService.insertarUnidadMineraArea(data);
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		UnidadMineraArea unidadMineraArea = unidadMineraAreaService.obtieneUnidadMineraAreaPorId(id);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraArea", unidadMineraArea);
		model.addAttribute("listaAreas", this.areaService.listaArea());
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
