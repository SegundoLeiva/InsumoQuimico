package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import repository.ProductoDao;
import domain.CustomerUser;
import domain.Producto;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	private ProductoDao productoDao;

	@RequestMapping(value = "/verProductos.htm")
	public String verProductos(HttpSession sesion, Model model)
			throws ServletException, IOException {

		model.addAttribute("listaProductos", this.productoDao.getlista());
		model.addAttribute("index", "1");
		return "verProductos";
	}

	@RequestMapping(value = "/nuevoProducto.htm")
	public String nuevoProducto(Model model) {
		model.addAttribute("getlistacategorias",
				this.productoDao.getlistamaetab(1));
		model.addAttribute("getlistamarcas", this.productoDao.getlistamaetab(2));
		model.addAttribute("index", "1");
		return "nuevoProducto";
	}

	@RequestMapping(value = "/registrarProducto.htm", method = RequestMethod.POST)
	public @ResponseBody
	String registrarProducto(Producto producto, Authentication auth) {

		CustomerUser user = (CustomerUser) auth.getPrincipal();
		String codUsu = user.getCodUsu();
		producto.setCodUsu(codUsu);
		
		if(StringUtils.isEmpty(producto.getId())){
			productoDao.agregarProducto(producto);
		}else{
			Producto prod = productoDao.productoById(producto.getId());
			prod.setNombre(producto.getNombre());
			prod.setCodCategoria(producto.getCodCategoria());
			prod.setCodMarca(producto.getCodMarca());
			productoDao.editarProducto(prod);
		}
		return "";
	}
	
	@RequestMapping(value = "/eliminarProducto.htm", method = RequestMethod.POST)
	public ModelAndView eliminarProducto(
			@RequestParam("idProducto") Long idProducto) {

		productoDao.eliminarProducto(idProducto);

		return new ModelAndView("redirect:/producto/verProductos.htm");
	}
	
	@RequestMapping(value = "/modificarProducto.htm")
	public String modificarProducto(Model model,@RequestParam("idProducto") Long idProducto) {

		Producto producto = productoDao.productoById(idProducto);
		model.addAttribute("getlistacategorias", this.productoDao.getlistamaetab(1));
		model.addAttribute("getlistamarcas", this.productoDao.getlistamaetab(2));
		model.addAttribute("producto", producto);
		model.addAttribute("index", "1");
		return "nuevoProducto";
	}
}
