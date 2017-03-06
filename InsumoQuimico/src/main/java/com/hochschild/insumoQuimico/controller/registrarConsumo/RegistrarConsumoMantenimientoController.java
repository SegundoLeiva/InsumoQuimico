package com.hochschild.insumoQuimico.controller.registrarConsumo;

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
import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle;
import com.hochschild.insumoQuimico.domain.ConsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.ConsumoDetalleService;
import com.hochschild.insumoQuimico.service.ConsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraAlmacenService;
import com.hochschild.insumoQuimico.service.UnidadMineraAreaService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoPresentacionService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/registrarConsumo")
public class RegistrarConsumoMantenimientoController extends BaseMantenimientoController{
	@Autowired
	private UnidadMineraInsumoPresentacionService unidadMineraInsumoPresentacionService;
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
	
	
	
	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoConsumo";
	}
	
	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
        List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
        model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
        List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraAreaVigentes();
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(listaUnidadesMineras));

        return model;
	}
	
	@RequestMapping(value="/guardarConsumo.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarConsumo(HttpSession sesion,ConsumoParametrosEntrada consumoParametrosEntrada) throws IllegalStateException, IOException{
		
    	Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");	
    	consumoParametrosEntrada.setNombreUsuario(usuarioSession.getIdUsuario());
    	String rpta = consumoService.guardarConsumo(consumoParametrosEntrada);
		return rpta;
	}
	
	@Override
	public Model setModificarAttributes(String id,Model model) {
		// TODO Auto-generated method stub
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
		model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		
		List<UnidadMineraAlmacen> listaUnidadMineraAlmacen = unidadMineraAlmacenService.listaUnidadMineraAlmacenPorUnidadMinera(listaUnidadesMineras.get(0).getValorOrganizacional());
		model.addAttribute("listaUnidadMineraAlmacen", listaUnidadMineraAlmacen);
		
		Consumo consumo = consumoService.obtieneConsumoPorId(id);
		model.addAttribute("consumo", consumo);
		model.addAttribute("listaUnidadMineraInsumoPresentacion", this.unidadMineraInsumoPresentacionService.listaUnidadMineraInsumoPresentacionPorUnidadMinera(consumo.getUnidadMinera().getIdUnidadMinera()));
		
		List<UnidadMineraArea> listaUnidadMineraArea = unidadMineraAreaService.listaUnidadMineraAreaPorUnidadMinera(consumo.getUnidadMinera().getIdUnidadMinera());
        model.addAttribute("listaUnidadMineraArea", listaUnidadMineraArea);
        
		List<ConsumoDetalle> listaConsumoDetalle = consumoDetalleService.obtenerConsumoDetallePorIdConsumo(id);
		if(listaConsumoDetalle.size()>0)model.addAttribute("listaConsumoDetalle",listaConsumoDetalle);
		
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
