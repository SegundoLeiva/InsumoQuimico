package com.hochschild.insumoQuimico.controller.insumo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.service.InsumoService;

@Controller
@RequestMapping(value = "/insumo")
public class InsumoSearchController extends BaseSearchController{

	@Autowired
	private InsumoService insumoService;

	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verInsumos";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.mostrarBotonBuscar=false;
		return this.insumoService.listaInsumo();
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			insumoService.eliminarInsumo(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
