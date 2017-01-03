package com.hochschild.insumoQuimico.controller.unidadMineraInsumo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/unidadMineraInsumo")
public class UnidadMineraInsumoSearchController extends BaseSearchController{
	
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
	private InsumoService insumoService;
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
		return "verUnidadMineraInsumos";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.mostrarBotonBuscar=false;
		return this.unidadMineraInsumoService.listaUnidadMineraInsumoPorUnidadMinera(this.usuario.getIdUnidadMineraPorDefecto());
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			unidadMineraInsumoService.eliminarUnidadMineraInsumo(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
