package com.hochschild.insumoQuimico.controller.ingresarMercaderia;

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
import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;
import com.hochschild.insumoQuimico.domain.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.MercaderiaDetalleService;
import com.hochschild.insumoQuimico.service.MercaderiaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAlmacenService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoPresentacionService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaMantenimientoController extends BaseMantenimientoController{
	@Autowired
	private UnidadMineraInsumoPresentacionService unidadMineraInsumoPresentacionService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	@Autowired
    private UnidadMineraAlmacenService unidadMineraAlmacenService;
	@Autowired
    private MercaderiaService mercaderiaService;
	@Autowired
    private MercaderiaDetalleService mercaderiaDetalleService;	


	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaMercaderia";
	}
	
	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(listaUnidadesMineras));
		return model;
	}
	
	@RequestMapping(value="/guardarMercaderia.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarMercaderia(HttpSession sesion,MercaderiaParametrosEntrada mercaderiaParametrosEntrada) throws IllegalStateException, IOException{
		
    	mercaderiaParametrosEntrada.setNombreUsuario(this.usuario.getIdUsuario());
    	String rpta = mercaderiaService.guardarMercaderia(mercaderiaParametrosEntrada);
		return rpta;
	}
	
	@Override
	public Model setModificarAttributes(String id,Model model) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
		model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
		model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		Mercaderia mercaderia = mercaderiaService.obtieneMercaderiaPorId(id);
		model.addAttribute("mercaderia", mercaderia);
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(mercaderia.getUnidadMinera().getIdUnidadMinera()));
		List<MercaderiaDetalle> listaMercaderiaDetalle = mercaderiaDetalleService.obtenerMercaderiaDetallePorIdMercaderia(id);
		if(listaMercaderiaDetalle.size()>0)model.addAttribute("listaMercaderiaDetalle",listaMercaderiaDetalle);
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
