package com.hochschild.insumoQuimico.controller.distribucionMercaderia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseMantenimientoController;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderia;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.service.DistribucionMercaderiaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoPresentacionService;

@Controller
@RequestMapping(value = "/distribucionMercaderia")
public class DistribucionMercaderiaMantenimientoController extends BaseMantenimientoController{

	@Autowired
	private UnidadMineraInsumoPresentacionService unidadMineraInsumoPresentacionService;
	@Autowired
    private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
    private DistribucionMercaderiaService distribucionMercaderiaService;
	
	@Override
	public Object getFormMantenimiento() {
		// TODO Auto-generated method stub
		DistribucionMercaderiaParametrosEntrada form = new DistribucionMercaderiaParametrosEntrada();
		form.setIdUsuarioCreacion(this.usuario.getIdUsuario());
		return form;
	}

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaDistribucionMercaderia";
	}

	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
        model.addAttribute("listaUnidadesMineras", this.usuario.getListaUnidadesMineras());
        model.addAttribute("listaUnidadMineraArea", unidadMineraAreaService.listaUnidadMineraAreaVigentes());
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(this.usuario.getListaUnidadesMineras()));

		return model;
	}

	@Override
	public boolean setGrabarAttributes() {
		// TODO Auto-generated method stub
		try {
			distribucionMercaderiaService.insertarDistribucionMercaderia((DistribucionMercaderiaParametrosEntrada)this.formMantenimiento);		
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Model setModificarAttributes(String id, Model model) {
		// TODO Auto-generated method stub
		DistribucionMercaderia data = distribucionMercaderiaService.obtieneDistribucionMercaderiaPorId(id);
		model.addAttribute("listaUnidadesMineras", this.usuario.getListaUnidadesMineras());
        model.addAttribute("listaUnidadMineraArea", unidadMineraAreaService.listaUnidadMineraAreaPorUnidadMinera(data.getUnidadMineraArea().getIdUnidadMinera()));
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(data.getUnidadMineraArea().getIdUnidadMinera()));
		model.addAttribute("distribucionMercaderia", data);
		return model;
	}

}
