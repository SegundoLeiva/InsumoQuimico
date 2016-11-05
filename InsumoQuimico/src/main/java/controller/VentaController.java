package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.TODO;

import domain.CustomerUser;
import domain.DetVen;
import domain.NroSeries;
import domain.Producto;
import domain.Proveedor;
import domain.Venta;
import repository.ProductoDao;
import service.ProveedorService;
import service.VentaService;

@Controller
@RequestMapping(value = "/sistema")
public class VentaController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private ProductoDao productoDao;
	@Autowired
	private VentaService ventaService;

	@RequestMapping(value = "/ventapanel.htm")
	public ModelAndView nuevoventa() {

		Long a = (long) 230;
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("getlistaproveedor",
				this.proveedorService.getlistaproveedor());
		myModel.put("listacitas", this.productoDao.getlista());
		myModel.put("listaserie", this.productoDao.getSerie());

		return new ModelAndView("ventapanel", "model", myModel);
	}

	@RequestMapping(value = "/registrarventa.htm")
	public ModelAndView guardarventa(
			@RequestParam("contadores") List<String> contadores,
			HttpServletRequest request, Authentication auth) {

		int count=contadores.size();
		if(count==0){
			count=1;
		}
		
		java.util.Date fecharegistro = new java.util.Date();
		Date fecha = new Date();
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		String codUsu = user.getCodUsu();
		String numVen = request.getParameter("venta0");
		// Long idprov = (long)
		// proveedorService.getIdbyNombreProveedor(codProv);

		Venta ven = new Venta();
		ven.setNumVen(numVen);
		ven.setFecReg(new Timestamp(fecharegistro.getTime()));
		ven.setCodUsu(codUsu);
		ven.setFecDate(fecha);
		ventaService.addVenta(ven);

		for (int i = 0; i < count; i++) {
			String venta = request.getParameter("venta" + "" + i + "");
			String pro = request.getParameter("producto" + "" + i + "");
			String serie = request.getParameter("serie" + "" + i + "");
			int cantidad = Integer.parseInt(request.getParameter("cantidad"
					+ "" + i + ""));
			Long idpro = (long) productoDao.getIdbyNombreProducto(pro);

			DetVen det = new DetVen();
			det.setNumVen(venta);
			det.setCantidad(cantidad);
			det.setCodPro(idpro);
			det.setNumSerie(serie);

			ventaService.addDetVen(det);

			String[] myserie = serie.split(";");
			for (int j = 0; j < myserie.length; j++) {
				if (myserie[j].trim().length() != 0) {

					NroSeries nro = productoDao.findByNroSerie(myserie[j]
							.trim().toUpperCase());
					nro.setDetSer("S");
					productoDao.editarNroserie(nro);
				}
			}

			Producto produ = productoDao.findByProducto(idpro);
			int x = produ.getStock();

			produ.setStock(x - cantidad);

			productoDao.editarproducto(produ);

		}

		// JOptionPane.showMessageDialog(null, "Se registró exitosamente");

		return new ModelAndView("redirect:/sistema/ventapanel.htm");

	}

}