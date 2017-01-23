package com.hochschild.insumoQuimico.controller.insumo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.InsumoPresentacion;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.PresentacionInsumoService;
import com.hochschild.insumoQuimico.service.UnidadMedidaService;
import com.hochschild.insumoQuimico.util.Constantes;

@Controller
@RequestMapping(value = "/insumo")
public class InsumoMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private InsumoService insumoService;
	@Autowired
	private UnidadMedidaService unidadMedidaService;
	@Autowired
	private PresentacionInsumoService presentacionInsumoService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoInsumo";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listaUnidadMedida", unidadMedidaService.listaUnidadMedida());
		return model;
	}
	
	@RequestMapping(value="/guardarInsumo.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarMercaderia(HttpSession sesion,InsumoParametrosEntrada insumoParametrosEntrada) throws IllegalStateException, IOException{
		
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			insumoService.insertarInsumo(insumoParametrosEntrada);

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
		model.addAttribute("listaUnidadMedida", unidadMedidaService.listaUnidadMedida());
		List<InsumoPresentacion> listaPresentacionInsumo = presentacionInsumoService.listaPresentacionInsumoPorInsumo(Integer.parseInt(id));
		if(listaPresentacionInsumo.size()>0)model.addAttribute("listaPresentacionInsumo",listaPresentacionInsumo);
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
