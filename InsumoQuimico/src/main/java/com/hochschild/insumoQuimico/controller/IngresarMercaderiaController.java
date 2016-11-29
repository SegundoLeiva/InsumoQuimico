package com.hochschild.insumoQuimico.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
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
import com.hochschild.insumoQuimico.util.FechasUtil;
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
		String fechaActual = FechasUtil.getFechaActual();
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
    	
        String idUnidadMinera = valorOrganizacionalService.getIdUnidadMineraPorDefecto(listaUnidadesMineras);      
        MercaderiaConsulta mercaderiaConsulta = new MercaderiaConsulta();
        mercaderiaConsulta.setIdUnidadMinera(idUnidadMinera);
        mercaderiaConsulta.setIdUsuarioCreacion(usuarioSession.getIdUsuario());
        List<MercaderiaConsulta> listaMercaderiaConsulta = mercaderiaService.listaMercaderiaConsulta(mercaderiaConsulta,fechaActual,fechaActual);         
        model.addAttribute("listaMercaderiaConsulta", listaMercaderiaConsulta);
        model.addAttribute("fechaInicio", fechaActual);
		model.addAttribute("fechaFin", fechaActual);
		return "verMercaderias";
	}
	
	@RequestMapping(value = { "/buscarMercaderia.htm" }, method = { RequestMethod.POST })
	public String buscarMercaderia(HttpSession sesion,
			MercaderiaConsulta mercaderiaConsulta, HttpServletRequest req, Model model) {

		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
        sesion.setAttribute("mercaderiaConsulta", mercaderiaConsulta);
        
		String fechaInicio = req.getParameter("fechaInicio");
		String fechaFin = req.getParameter("fechaFin");

        List<MercaderiaConsulta> listaMercaderiaConsulta = mercaderiaService.listaMercaderiaConsulta(mercaderiaConsulta,fechaInicio,fechaFin);         
		model.addAttribute("listaMercaderiaConsulta", listaMercaderiaConsulta);
		model.addAttribute("mercaderiaConsulta", mercaderiaConsulta);
		model.addAttribute("fechaInicio", fechaInicio);
		model.addAttribute("fechaFin", fechaFin);
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
		return this.buscarMercaderia(sesion, (MercaderiaConsulta)sesion.getAttribute("mercaderiaConsulta"),req,model);
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
