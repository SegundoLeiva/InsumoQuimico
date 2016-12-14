package com.hochschild.insumoQuimico.controller.insumo;

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
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.util.Constantes;

@Controller
@RequestMapping(value = "/insumo")
public class InsumoMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private InsumoService insumoService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoInsumo";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		return model;
	}
	
	@RequestMapping(value = "/agregarInsumo.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarArea(InsumoParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdInsumo())){
				insumoService.insertarInsumo(data);
			}else{
				insumoService.actualizarInsumo(data);
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
		Insumo insumo = insumoService.obtieneInsumoPorId(id);
		model.addAttribute("insumo", insumo);
		return model;
	}

}
