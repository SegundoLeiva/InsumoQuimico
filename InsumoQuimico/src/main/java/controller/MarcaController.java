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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import domain.MaeTab;
import repository.MarcaDao;

@Controller
@RequestMapping(value = "/sistema")
public class MarcaController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MarcaDao marcaDao;


	@RequestMapping(value = "/listarmarcas.htm")
	public ModelAndView lista_marcas(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		myModel.put("listarmarcas", this.marcaDao.getlistamaetab(2));
		return new ModelAndView("listarmarcas", "model", myModel);
	}

	@RequestMapping(value = "/nuevamarca.htm")
	public ModelAndView nuevamarca() {

		return new ModelAndView("nuevamarca");
	}


	
	@RequestMapping(value = "/registrarmarca.htm", method = RequestMethod.POST)
	public @ResponseBody
	String registrarmarcas(@RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Integer estado) {


		String error="error";
		if(descripcion.trim().length()==0){
			
			return error;
		}else{
			MaeTab mae = new MaeTab();

			mae.setDescripcion(descripcion.trim().toUpperCase());
			mae.setEstado(estado);
			mae.setCodOpc(2);
			marcaDao.addMarca(mae);

			String result = descripcion.toString();

			return result;
		}
		
	
	}

	@RequestMapping(value = "/modificarmarca.htm")
	public ModelAndView modificarproducto(
			@RequestParam("idmarca") Long idmarca) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Object[] x = marcaDao.datosmarcasbyId(idmarca);
		myModel.put("datosmarcas", x);
		return new ModelAndView("modificarmarca", "model", myModel);
	}


	
	@RequestMapping(value = "/modificarmarcaaction.htm", method = RequestMethod.POST)
	public @ResponseBody
	String modificarmarcasaction(
			@RequestParam("idmarca") Long idmarca,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Integer estado) {

		
		String error="error";
		if(descripcion.trim().length()==0){
			
			return error;
		}else{
			MaeTab mae = marcaDao.findByMarca(idmarca);
			mae.setDescripcion(descripcion.trim().toUpperCase());
			mae.setEstado(estado);
			marcaDao.editarmarca(mae);

			String nombre = descripcion.toString();

			return nombre;
		}

	}
	
	@RequestMapping(value = "/eliminarmarca.htm", method = RequestMethod.POST)
	public ModelAndView eliminarmarca(
			@RequestParam("idmarca") Long idmarca) {

		MaeTab mae = marcaDao.findByMarca(idmarca);
		mae.setEstado(0);
		marcaDao.editarmarca(mae);

		return new ModelAndView("redirect:/sistema/listarmarcas.htm");
	}

}
