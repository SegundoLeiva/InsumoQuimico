package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import domain.CustomerUser;
import domain.NroSeries;
import domain.Producto;
import repository.ProductoDao;

@Controller
@RequestMapping(value = "/sistema")
public class ProductoController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ProductoDao productoDao;
	Integer rpta = 0;

	@RequestMapping(value = "/listarproductos.htm")
	public ModelAndView listarproductos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		myModel.put("listacitas", this.productoDao.getlista());

		return new ModelAndView("listarproductos", "model", myModel);
	}

	@RequestMapping(value = "/nuevoproducto.htm")
	public ModelAndView nuevoproducto(Integer a) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("getlistacategorias", this.productoDao.getlistamaetab(1));
		myModel.put("getlistamarcas", this.productoDao.getlistamaetab(2));
		myModel.put("mensaje", a);
		return new ModelAndView("nuevoproducto", "model", myModel);
	}


	@RequestMapping(value = "/registrarproducto.htm", method = RequestMethod.POST)
	public @ResponseBody
	String guardarProductos(@RequestParam("nombre") String nombre,
			@RequestParam("categoria") Long categoria,
			@RequestParam("marca") Long marca,
			@RequestParam("estado") Integer estado, Authentication auth) {

		CustomerUser user = (CustomerUser) auth.getPrincipal();
		String codUsu = user.getCodUsu();
		String error="error";
		if(nombre.trim().length()==0){
			
			return error;
		}else{
			Producto pro = new Producto();

			java.util.Date fecharegistro = new java.util.Date();

			pro.setNombre(nombre.trim().toUpperCase());
			pro.setCodCategoria(categoria);
			pro.setEstado(estado);
			pro.setCodMarca(marca);
			pro.setStock(0);
			pro.setFecReg(new Timestamp(fecharegistro.getTime()));
			pro.setCodUsu(codUsu);

			productoDao.addProducto(pro);

			String categoriaActual = nombre.toString();

			return categoriaActual;
		}
		
	

	}

	@RequestMapping(value = "/modificarproducto.htm")
	public ModelAndView modificarproducto(
			@RequestParam("idproducto") Long idproducto) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Object[] x = productoDao.datosproductosbyId(idproducto);
		myModel.put("getlistacategorias", this.productoDao.getlistamaetab(1));
		myModel.put("getlistamarcas", this.productoDao.getlistamaetab(2));
		myModel.put("datosproducto", x);
		return new ModelAndView("modificarproducto", "model", myModel);
	}


	@RequestMapping(value = "/modificarproductoaction.htm", method = RequestMethod.POST)
	public @ResponseBody
	String modificarProductos(
			@RequestParam("idproducto") Long idproducto,
			@RequestParam("nombre") String nombre,
			@RequestParam("estado") Integer estado,
			@RequestParam("marca") Long marca,
			@RequestParam("categoria") Long categoria) {

		
		String error="error";
		if(nombre.trim().length()==0){
			
			return error;
		}else{
			Producto pro = productoDao.findByProducto(idproducto);
			pro.setNombre(nombre.trim().toUpperCase());
			pro.setCodCategoria(categoria);
			pro.setEstado(estado);
			pro.setCodMarca(marca);
			productoDao.editarproducto(pro);

			String categoriaActual = nombre.toString();

			return categoriaActual;
		}

	}

}
