package com.hochschild.insumoQuimico.controller.cerrarPeriodo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaReporteModel;
import com.hochschild.insumoQuimico.service.ConsumoService;

@Controller
@RequestMapping(value = "/cerrarPeriodo")
public class CerrarPeriodoMantenimientoController extends BaseMantenimientoController{

	@Autowired
    private ConsumoService consumoService;
	
	@Override
	public Object getFormMantenimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "consultarCerrarPeriodo";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public boolean setGrabarAttributes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		ConsumoConsultaReporteModel data = new ConsumoConsultaReporteModel();
		data.setIdUnidadMinera(id.split(",")[0]);
		data.setAnio(id.split(",")[1]);
		data.setMes(id.split(",")[2]);
		List<ConsumoConsulta> listaConsumoReporte = consumoService.listaConsumoConsultaReporte(data);
		model.addAttribute("listaConsumoReporte", listaConsumoReporte);
		return model;
	}

}
