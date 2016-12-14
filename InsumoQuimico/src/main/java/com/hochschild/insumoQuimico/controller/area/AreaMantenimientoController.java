package com.hochschild.insumoQuimico.controller.area;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.util.Constantes;

@Controller
@RequestMapping(value = "/area")
public class AreaMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private AreaService areaService;

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
	
	@RequestMapping(value = "/agregarArea.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarArea(AreaParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdArea())){
				areaService.insertarArea(data);
			}else{
				areaService.actualizarArea(data);
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}
		} catch (Exception e) {
			mensaje = Constantes.TRANSACCION_ERROR;
		}		
		return mensaje;
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		Area area = areaService.obtieneAreaPorId(id);
		model.addAttribute("area", area);
		return model;
	}

}
