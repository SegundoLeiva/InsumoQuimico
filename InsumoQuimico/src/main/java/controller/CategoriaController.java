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
public class CategoriaController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MarcaDao marcaDao;


	@RequestMapping(value = "/listacategoria.htm")
	public ModelAndView lista_categoria(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		myModel.put("listacategoria", this.marcaDao.getlistamaetab(1));
		return new ModelAndView("listacategoria", "model", myModel);
	}

	@RequestMapping(value = "/nuevacategoria.htm")
	public ModelAndView nuevacategoria() {

		return new ModelAndView("nuevacategoria");
	}


	
	@RequestMapping(value = "/registrarcategoria.htm", method = RequestMethod.POST)
	public @ResponseBody
	String registrarcategoria(@RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Integer estado) {


		String error="error";
		if(descripcion.trim().length()==0){
			
			return error;
		}else{
			MaeTab mae = new MaeTab();

			mae.setDescripcion(descripcion.trim().toUpperCase());
			mae.setEstado(estado);
			mae.setCodOpc(1);
			marcaDao.addMarca(mae);

			String result = descripcion.toString();

			return result;
		}
		
	
	}

	@RequestMapping(value = "/modificarcategoria.htm")
	public ModelAndView modificarproducto(
			@RequestParam("idcategoria") Long idcategoria) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Object[] x = marcaDao.datosmarcasbyId(idcategoria);
		myModel.put("datoscategoria", x);
		return new ModelAndView("modificarcategoria", "model", myModel);
	}


	
	@RequestMapping(value = "/modificarcategoriaaction.htm", method = RequestMethod.POST)
	public @ResponseBody
	String modificarcategoriaaction(
			@RequestParam("idcategoria") Long idcategoria,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Integer estado) {

		
		String error="error";
		if(descripcion.trim().length()==0){
			
			return error;
		}else{
			MaeTab mae = marcaDao.findByMarca(idcategoria);
			mae.setDescripcion(descripcion.trim().toUpperCase());
			mae.setEstado(estado);
			marcaDao.editarmarca(mae);

			String nombre = descripcion.toString();

			return nombre;
		}

	}
	
	@RequestMapping(value = "/eliminarcategoria.htm", method = RequestMethod.POST)
	public ModelAndView eliminarcategoria(
			@RequestParam("idcategoria") Long idcategoria) {

		MaeTab mae = marcaDao.findByMarca(idcategoria);
		mae.setEstado(0);
		marcaDao.editarmarca(mae);

		return new ModelAndView("redirect:/sistema/listacategoria.htm");
	}

}
