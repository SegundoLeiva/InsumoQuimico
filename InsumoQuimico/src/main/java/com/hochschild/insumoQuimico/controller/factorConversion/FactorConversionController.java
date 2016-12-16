package com.hochschild.insumoQuimico.controller.factorConversion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.service.FactorConversionMedidaService;

@Controller
@RequestMapping(value = "/factorConversion")
public class FactorConversionController extends BaseSearchController{

	@Autowired
	private FactorConversionMedidaService factorConversionMedidaService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verFactorConversion";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.mostrarBotonBuscar=false;
		this.mostrarBotonNuevo=false;
		return this.factorConversionMedidaService.listaFactorConversionMedida();
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
