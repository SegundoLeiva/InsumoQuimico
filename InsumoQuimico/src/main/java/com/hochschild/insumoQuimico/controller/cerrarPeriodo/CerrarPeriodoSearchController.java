package com.hochschild.insumoQuimico.controller.cerrarPeriodo;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CalendarioGestionModel;
import com.hochschild.insumoQuimico.domain.CatalogoDetalle;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.CalendarioGestionService;
import com.hochschild.insumoQuimico.service.CatalogoDetalleService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/cerrarPeriodo")
public class CerrarPeriodoSearchController extends BaseSearchController{
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	@Autowired
	private CatalogoDetalleService catalogoDetalleService;
	@Autowired
	private CalendarioGestionService calendarioGestionService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		CalendarioGestionModel form = new CalendarioGestionModel(this.usuario);
		return form;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verCerrarPeriodo";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){

        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<CatalogoDetalle> listRangoAnio = catalogoDetalleService.listaCatalogoDetalleByIdCatalogo(6) ;
		model.addAttribute("listRangoAnio", listRangoAnio);
		this.mostrarBotonNuevo=false;
        return calendarioGestionService.listCalendarioGestionPorAnio((CalendarioGestionModel)this.formBusqueda);  
       
	}
	
	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@RequestMapping(value = { "/cambiarApertura.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String cambiarApertura(Model model,HttpServletRequest req,HttpSession sesion,
			@RequestParam("mes") String mes) throws ServletException {
		
		CalendarioGestionModel calendarioGestionModel = (CalendarioGestionModel)this.formBusqueda;
		calendarioGestionModel.setMes(mes);
		CalendarioGestion data = calendarioGestionService.obtieneCalendarioGestion(calendarioGestionModel);
		if(data.getAperturado().equals("N")){
			data.setAperturado("S");
			calendarioGestionService.actualizarCalendarioGestion(data);
		}else{
			data.setAperturado("N");
			calendarioGestionService.actualizarCalendarioGestion(data);
		}
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_CAMBIAR_APERTURA);

		model=mostrarBotones(model);
		return listar(model, req, sesion);
	}

}
