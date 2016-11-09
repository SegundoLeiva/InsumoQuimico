package controller;

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

import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.service.InsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
@RequestMapping(value = "/insumo")
public class InsumoController extends BaseController{
	
	@Autowired
	private UnidadMineraInsumoService unidadMineraInsumoService;
	@Autowired
	private InsumoService insumoService;
	@Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
	
	@RequestMapping(value = "/verInsumos.htm")
	public String verInsumos(Model model,HttpServletRequest req) {
		model.addAttribute("listaUnidadMineraInsumo", this.unidadMineraInsumoService.listaUnidadMineraInsumo());
		model.addAttribute(Constantes.FLAG_TRANSACCION, req.getAttribute(Constantes.FLAG_TRANSACCION));
		model.addAttribute("index", "5");
		return "verInsumos";
	}
	
	@RequestMapping(value = "/agregarInsumo.htm", method = RequestMethod.POST)
	@ResponseBody
	public String agregarInsumo(InsumoParametrosEntrada data,Model model,HttpServletRequest req) throws ServletException, IOException {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdUnidadMineraInsumo())){
				unidadMineraInsumoService.insertarUnidadMineraInsumo(data);
			}else{
				unidadMineraInsumoService.actualizarUnidadMineraInsumo(data);
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}
		} catch (Exception e) {
			mensaje = Constantes.TRANSACCION_ERROR;
		}		
		req.setAttribute(Constantes.FLAG_TRANSACCION, mensaje);
		return mensaje;
	}
	
	@RequestMapping(value = "/nuevoInsumo.htm")
	public String nuevoInsumo(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		model.addAttribute("index", "5");
		return "nuevoInsumo";
	}

	@RequestMapping(value = "/eliminarUnidadMineraInsumo.htm", method = RequestMethod.POST)
	public String eliminarUnidadMineraInsumo(Model model,HttpServletRequest req,
			@RequestParam("idUnidadMineraInsumo") String idUnidadMineraInsumo) throws ServletException, IOException {

		unidadMineraInsumoService.eliminarUnidadMineraInsumo(idUnidadMineraInsumo);
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		return this.verInsumos(model,req);
	}
	
	@RequestMapping(value = "/modificarInsumo.htm")
	public String modificarInsumo(Model model,HttpSession sesion ,@RequestParam("idUnidadMineraInsumo") String idUnidadMineraInsumo) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		UnidadMineraInsumo unidadMineraInsumo = unidadMineraInsumoService.obtieneUnidadMineraInsumoPorId(idUnidadMineraInsumo);
		List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValoresDescripcion(usuarioSession.getLst_valoresOrganizacionales());
	    model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("unidadMineraInsumo", unidadMineraInsumo);
		model.addAttribute("listaInsumos", this.insumoService.listaInsumo());
		model.addAttribute("index", "5");
		return "nuevoInsumo";
	}

}
