package com.hochschild.insumoQuimico.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;
import com.hochschild.insumoQuimico.domain.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.sap.FuncionesSAPService;
import com.hochschild.insumoQuimico.service.MercaderiaDetalleService;
import com.hochschild.insumoQuimico.service.MercaderiaService;
import com.hochschild.insumoQuimico.service.UnidadMineraAlmacenService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaController {
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	@Autowired
    private UnidadMineraAlmacenService unidadMineraAlmacenService;
	@Autowired
    private MercaderiaService mercaderiaService;
	@Autowired
    private MercaderiaDetalleService mercaderiaDetalleService;
	@Autowired
	private FuncionesSAPService funcionesSAPService;
	
	@RequestMapping(value = "/verMercaderias.htm")
	public String verMercaderias(Model model,HttpSession sesion,HttpServletRequest req) {

		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
    	
        String idUnidadMinera = valorOrganizacionalService.getIdUnidadMineraPorDefecto(listaUnidadesMineras);      
        MercaderiaConsultaModel mercaderiaConsultaModel = new MercaderiaConsultaModel(sesion,idUnidadMinera);
        if(!StringUtils.isEmpty(req.getParameter("cod"))){
        	mercaderiaConsultaModel = (MercaderiaConsultaModel) sesion.getAttribute("mercaderiaConsulta");
        }
        List<MercaderiaConsulta> listaMercaderiaConsulta = mercaderiaService.listaMercaderiaConsulta(mercaderiaConsultaModel);         
        model.addAttribute("listaMercaderiaConsulta", listaMercaderiaConsulta);
		sesion.setAttribute("mercaderiaConsulta", mercaderiaConsultaModel);
		return "verMercaderias";
	}
	
	@RequestMapping(value = { "/buscarConsulta.htm" }, method = { RequestMethod.POST })
	public String buscarConsulta(HttpSession sesion,
			MercaderiaConsultaModel mercaderiaConsultaModel, HttpServletRequest req, Model model) {

		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);

        List<MercaderiaConsulta> listaMercaderiaConsulta = mercaderiaService.listaMercaderiaConsulta(mercaderiaConsultaModel);         
		model.addAttribute("listaMercaderiaConsulta", listaMercaderiaConsulta);
		sesion.setAttribute("mercaderiaConsulta", mercaderiaConsultaModel);
		return "verMercaderias";
	}
	
	@RequestMapping(value = "/nuevaMercaderia.htm")
	public String nuevaMercaderia(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		model.addAttribute("listaUnidadMineraInsumo", this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		return "nuevaMercaderia";
	}
	
	@RequestMapping(value="/guardarMercaderia.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarMercaderia(HttpSession sesion,MercaderiaParametrosEntrada mercaderiaParametrosEntrada) throws IllegalStateException, IOException{
		
    	Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");	
    	mercaderiaParametrosEntrada.setNombreUsuario(usuarioSession.getIdUsuario());
    	String rpta = mercaderiaService.guardarMercaderia(mercaderiaParametrosEntrada);
		return rpta;
	}
	
	@RequestMapping(value = "/eliminarMercaderia.htm", method = RequestMethod.POST)
	public String eliminarMercaderia(Model model,HttpServletRequest req,HttpSession sesion,
			@RequestParam("idMercaderia") String idMercaderia) throws ServletException, IOException {
		mercaderiaService.eliminarMercaderia(idMercaderia);
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		return this.buscarConsulta(sesion, (MercaderiaConsultaModel)sesion.getAttribute("mercaderiaConsulta"),req,model);
	}
	
	@RequestMapping(value = { "/modificarMercaderia.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String modificarMercaderia(HttpSession sesion,
			@RequestParam String idMercaderia, Model model) throws IOException {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
		model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
		model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		Mercaderia mercaderia = mercaderiaService.obtieneMercaderiaPorId(idMercaderia);
		model.addAttribute("mercaderia", mercaderia);
		model.addAttribute("flagEditar", Constantes.FLAG_EDITAR);
		model.addAttribute("listaUnidadMineraInsumo",this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		
		List<MercaderiaDetalle> listaMercaderiaDetalle = mercaderiaDetalleService.obtenerMercaderiaDetallePorIdMercaderia(idMercaderia);
		if(listaMercaderiaDetalle.size()>0)model.addAttribute("listaMercaderiaDetalle",listaMercaderiaDetalle);

		return "nuevaMercaderia";
	}
	
	@RequestMapping(value="/getProveedorDescripcion.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String getProveedorDescripcion(@RequestParam("rucProveedor") String rucProveedor) {
		
		String resultado = funcionesSAPService.getProveedorDescripcion(rucProveedor, Constantes.SOCIEDAD_PROVEEDOR);

		return resultado;

	}

}
