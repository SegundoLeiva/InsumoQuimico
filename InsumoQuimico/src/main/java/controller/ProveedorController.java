package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import service.ProveedorService;
import domain.Proveedor;

@Controller
@RequestMapping(value = "/sistema")
public class ProveedorController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ValidatorProveedor validatorproveedor;

	@Autowired
	private ProveedorService proveedorService;

	@RequestMapping(value = "/listarproveedor.htm")
	public ModelAndView lista_proveedor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		myModel.put("listarproveedor",
				this.proveedorService.getlistaproveedor());
		return new ModelAndView("listarproveedor", "model", myModel);
	}

	@RequestMapping(value = "/nuevoproveedor.htm")
	public ModelAndView nuevoproveedor() {

		return new ModelAndView("nuevoproveedor");
	}

	@ModelAttribute("registrarproveedor")
	public Proveedor registrarproveedor() {
		return new Proveedor();
	}

	@RequestMapping(value = "/registrarproveedor.htm", method = RequestMethod.POST)
	public ModelAndView guardarproveedor(
			@ModelAttribute("registrarproveedor") Proveedor proveedor,
			BindingResult result, SessionStatus status) {

		validatorproveedor.validarProveedor(proveedor, result);
		Map<String, Object> myModel = new HashMap<String, Object>();
		if (result.hasErrors()) {
			myModel.put("mensajeError", "El Proveedor no se pudo registrar");
			return new ModelAndView("nuevoproveedor", "model", myModel);
		} else {
			Proveedor prov = new Proveedor();
			prov.setRucProv(proveedor.getRucProv().trim().toUpperCase());
			prov.setDesProv(proveedor.getDesProv().toUpperCase());
			prov.setDirProv(proveedor.getDirProv().toUpperCase());
			prov.setEstado(proveedor.getEstado());
			proveedorService.addproveedor(prov);

			myModel.put("mensajeOk", "El Proveedor se registro con éxito");
			return new ModelAndView("nuevoproveedor", "model", myModel);
		}
	}

	@RequestMapping(value = "/modificarproveedor.htm")
	public ModelAndView modificarproveedor(
			@RequestParam("idproveedor") Long idproveedor) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Object[] x = proveedorService.datosproveedorbyId(idproveedor);
		myModel.put("datosproveedor", x);
		return new ModelAndView("modificarproveedor", "model", myModel);
	}

	@ModelAttribute("modificarproveedor")
	public Proveedor modificarproveedor() {
		return new Proveedor();
	}

	@RequestMapping(value = "/modificarproveedoraction.htm", method = RequestMethod.POST)
	public ModelAndView editarproveedor(
			@ModelAttribute("modificarproveedor") Proveedor proveedor,
			BindingResult result, SessionStatus status) {

		Proveedor prov = proveedorService.findByProveedor(proveedor.getId());
		prov.setRucProv(proveedor.getRucProv().trim().toUpperCase());
		prov.setDesProv(proveedor.getDesProv().toUpperCase());
		prov.setDirProv(proveedor.getDirProv().toUpperCase());
		prov.setEstado(proveedor.getEstado());
		proveedorService.editarproveedor(prov);

		validatorproveedor.validarProveedor(proveedor, result);
		Map<String, Object> myModel = new HashMap<String, Object>();
		if (result.hasErrors()) {
			myModel.put("mensajeError", "El Proveedor no se pudo modificar");
			return new ModelAndView("modificarproveedor", "model", myModel);
		} else {

			myModel.put("mensajeOk", "El Proveedor se modificó con éxito");
			return new ModelAndView("modificarproveedor", "model", myModel);
		}
	}

}
