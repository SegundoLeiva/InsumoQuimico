package com.hochschild.insumoQuimico.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.ConsumoDetalleService;
import com.hochschild.insumoQuimico.service.ConsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraAlmacenService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.FechasUtil;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/registrarConsumo")
public class RegistrarConsumoController {
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	@Autowired
    private UnidadMineraAlmacenService unidadMineraAlmacenService;
	@Autowired
    private UnidadMineraAreaService unidadMineraAreaService;
	@Autowired
    private ConsumoService consumoService;
	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	
	@RequestMapping(value = "/verConsumos.htm")
	public String verConsumos(Model model,HttpSession sesion,HttpServletRequest req) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		String fechaActual = FechasUtil.getFechaActual();
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
        List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraArea();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
        
        String idUnidadMinera = valorOrganizacionalService.getIdUnidadMineraPorDefecto(listaUnidadesMineras);      
        ConsumoConsulta consumoConsulta = new ConsumoConsulta(idUnidadMinera);
        consumoConsulta.setIdUsuarioCreacion(usuarioSession.getIdUsuario());
        List<ConsumoConsulta> listaConsumoConsulta = consumoService.listaConsumoConsulta(consumoConsulta,fechaActual,fechaActual);         
        model.addAttribute("listaConsumoConsulta", listaConsumoConsulta);
        model.addAttribute("fechaInicio", fechaActual);
		model.addAttribute("fechaFin", fechaActual);
		
		return "verConsumos";
	}
	
	@RequestMapping(value = { "/buscarConsumo.htm" }, method = { RequestMethod.POST })
	public String buscarConsumo(HttpSession sesion,
			ConsumoConsulta consumoConsulta, HttpServletRequest req,
			HttpServletResponse res, Model model) {

		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
        List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraArea();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
        
		String fechaInicio = req.getParameter("fechaInicio");
		String fechaFin = req.getParameter("fechaFin");

        List<ConsumoConsulta> listaConsumoConsulta = consumoService.listaConsumoConsulta(consumoConsulta,fechaInicio,fechaFin);         
		model.addAttribute("listaConsumoConsulta", listaConsumoConsulta);
		model.addAttribute("consumoConsulta", consumoConsulta);
		model.addAttribute("fechaInicio", fechaInicio);
		model.addAttribute("fechaFin", fechaFin);
		return "verConsumos";
	}
	
	@RequestMapping(value = "/nuevoConsumo.htm")
	public String nuevoConsumo(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
        model.addAttribute("listaUnidadMineraInsumo", this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
        List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraArea();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
		return "nuevoConsumo";
	}
	
	@RequestMapping(value="/guardarConsumo.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarConsumo(HttpSession sesion,ConsumoParametrosEntrada consumoParametrosEntrada) throws IllegalStateException, IOException{
		
    	Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");	
    	consumoParametrosEntrada.setNombreUsuario(usuarioSession.getIdUsuario());
    	String rpta = consumoService.guardarConsumo(consumoParametrosEntrada);
		return rpta;
	}
	
	@RequestMapping(value = "/eliminarConsumo.htm", method = RequestMethod.POST)
	public String eliminarConsumo(Model model,HttpServletRequest req,HttpSession sesion,
			@RequestParam("idConsumo") String idConsumo) throws ServletException, IOException {
		consumoService.eliminarConsumo(idConsumo);
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		return this.verConsumos(model,sesion,req);
	}
	
	@RequestMapping(value = { "/modificarConsumo.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String modificarConsumo(HttpSession sesion,
			@RequestParam String idConsumo, Model model) throws IOException {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
		model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
		model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		
		List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraArea();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
        
		Consumo consumo = consumoService.obtieneConsumoPorId(idConsumo);
		model.addAttribute("consumo", consumo);
		model.addAttribute("flagEditar", Constantes.FLAG_EDITAR);
		model.addAttribute("listaUnidadMineraInsumo",this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		
		List<ConsumoDetalle> listaConsumoDetalle = consumoDetalleService.obtenerConsumoDetallePorIdConsumo(idConsumo);
		if(listaConsumoDetalle.size()>0)model.addAttribute("listaConsumoDetalle",listaConsumoDetalle);

		return "nuevaConsumo";
	}
}
