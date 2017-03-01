package com.hochschild.insumoQuimico.controller.unidadMineraArea;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.domain.UnidadMineraAreaConsultaModel;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.AreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/unidadMineraArea")
public class UnidadMineraAreaSearchController extends BaseSearchController{
	
	@Autowired
	private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
	private AreaService areaService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	

	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		UnidadMineraAreaConsultaModel unidadMineraAreaConsultaModel = new UnidadMineraAreaConsultaModel();
		unidadMineraAreaConsultaModel.setIdUnidadMinera(usuario.getIdUnidadMineraPorDefecto());
		return unidadMineraAreaConsultaModel;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verUnidadMineraAreas";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		return this.unidadMineraAreaService.listaUnidadMineraAreaPorUnidadMinera(((UnidadMineraAreaConsultaModel)this.formBusqueda).getIdUnidadMinera());
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			unidadMineraAreaService.eliminarUnidadMineraArea(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
