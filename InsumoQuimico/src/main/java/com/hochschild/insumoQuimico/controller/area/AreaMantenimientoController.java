package com.hochschild.insumoQuimico.controller.area;

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
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/area")
public class AreaMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaArea";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaAreas", this.areaService.listaArea());
		return model;
	}
	
	@RequestMapping(value = "/agregarArea.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarArea(AreaParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdUnidadMineraArea())){
				unidadMineraAreaService.insertarUnidadMineraArea(data);
			}else{
				unidadMineraAreaService.actualizarUnidadMineraArea(data);
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
		UnidadMineraArea unidadMineraArea = unidadMineraAreaService.obtieneUnidadMineraAreaPorId(id);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraArea", unidadMineraArea);
		model.addAttribute("listaAreas", this.areaService.listaArea());
		return model;
	}

}
