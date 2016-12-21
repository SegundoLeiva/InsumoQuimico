package com.hochschild.insumoQuimico.controller.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;
import com.hochschild.insumoQuimico.service.AreaService;

@Controller
@RequestMapping(value = "/area")
public class AreaMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private AreaService areaService;

	@Override
	public Object getFormMantenimiento() {
		// TODO Auto-generated method stub
		AreaParametrosEntrada form = new AreaParametrosEntrada();
		return form;
	}
	
	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaArea";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		return model;
	}
	
	@Override
	public boolean setGrabarAttributes() {
		// TODO Auto-generated method stub
		try {
			areaService.insertarArea((AreaParametrosEntrada)this.formMantenimiento);			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		Area area = areaService.obtieneAreaPorId(id);
		model.addAttribute("area", area);
		return model;
	}

}
