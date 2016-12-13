package com.hochschild.insumoQuimico.controller.insumo;

import java.io.IOException;
import java.util.List;

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
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/insumo")
public class InsumoMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
	private InsumoService insumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoInsumo";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		return model;
	}
	
	@RequestMapping(value = "/agregarInsumo.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarInsumo(InsumoParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdUnidadMineraInsumo())){
				unidadMineraInsumoService.insertarUnidadMineraInsumo(data);
			}else{
				unidadMineraInsumoService.actualizarUnidadMineraInsumo(data);
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
		UnidadMineraInsumo unidadMineraInsumo = unidadMineraInsumoService.obtieneUnidadMineraInsumoPorId(id);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraInsumo", unidadMineraInsumo);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		return model;
	}

}
