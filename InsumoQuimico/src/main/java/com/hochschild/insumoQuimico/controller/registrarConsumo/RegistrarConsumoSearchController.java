package com.hochschild.insumoQuimico.controller.registrarConsumo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaModel;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.ConsumoDetalleService;
import com.hochschild.insumoQuimico.service.ConsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/registrarConsumo")
public class RegistrarConsumoSearchController extends BaseSearchController{
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	@Autowired
    private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
    private ConsumoService consumoService;
	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		ConsumoConsultaModel consumoConsultaModel = new ConsumoConsultaModel(this.usuario);
		return consumoConsultaModel;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verConsumos";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){

        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraAreaVigentes();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
        return consumoService.listaConsumoConsulta((ConsumoConsultaModel)this.formBusqueda);  
       
	}
	
	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			consumoService.eliminarConsumo(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
