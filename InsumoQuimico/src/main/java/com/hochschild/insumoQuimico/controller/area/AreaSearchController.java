package com.hochschild.insumoQuimico.controller.area;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/area")
public class AreaSearchController extends BaseSearchController{
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	

	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verAreas";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.mostrarBotonBuscar=false;
		return this.unidadMineraAreaService.listaUnidadMineraArea();
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			unidadMineraAreaService.eliminarUnidadMineraArea(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
