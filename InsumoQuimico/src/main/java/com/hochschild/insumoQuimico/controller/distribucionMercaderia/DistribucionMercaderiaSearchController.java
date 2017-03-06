package com.hochschild.insumoQuimico.controller.distribucionMercaderia;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.DistribucionMercaderiaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoPresentacionService;

@Controller
@RequestMapping(value = "/distribucionMercaderia")
public class DistribucionMercaderiaSearchController extends BaseSearchController{

	@Autowired
	private UnidadMineraInsumoPresentacionService unidadMineraInsumoPresentacionService;
	@Autowired
    private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
    private DistribucionMercaderiaService distribucionMercaderiaService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		DistribucionMercaderiaConsultaModel form = new DistribucionMercaderiaConsultaModel();
		form.setIdUnidadMinera(this.usuario.getIdUnidadMineraPorDefecto());
		return form;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verDistribucionMercaderia";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        model.addAttribute("listaUnidadMineraArea", unidadMineraAreaService.listaUnidadMineraAreaVigentes());
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(this.usuario.getListaUnidadesMineras()));
		return distribucionMercaderiaService.listaDistribucionMercaderiaConsulta((DistribucionMercaderiaConsultaModel)this.formBusqueda);
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
