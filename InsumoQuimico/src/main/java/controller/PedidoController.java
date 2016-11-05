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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.TODO;

import domain.CustomerUser;
import domain.DetPed;
import domain.Pedido;
import domain.NroSeries;
import domain.Producto;
import domain.Proveedor;
import repository.ProductoDao;
import service.PedidoService;
import service.ProveedorService;

@Controller
@RequestMapping(value = "/sistema")
public class PedidoController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private ProductoDao productoDao;
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/pedidopanel.htm")
	public ModelAndView nuevopedido(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("getlistaproveedor", this.proveedorService.getlistaproveedor());
		myModel.put("listacitas", this.productoDao.getlista());
		myModel.put("getlistacategorias", this.productoDao.getlistamaetab(1));
		myModel.put("getlistamarcas", this.productoDao.getlistamaetab(2));

		return new ModelAndView("pedidopanel", "model", myModel);
	}
	
	@RequestMapping(value = "/pedidolista.htm")
	public ModelAndView pedidolista(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("getlistaproveedor", this.proveedorService.getlistaproveedor());
//		myModel.put("listacitas", this.productoDao.getlista());
//		myModel.put("getlistacategorias", this.productoDao.getlistamaetab(1));
//		myModel.put("getlistamarcas", this.productoDao.getlistamaetab(2));

		return new ModelAndView("pedidolista");
//		return new ModelAndView("pedidopanel", "model", myModel);

	}

	@RequestMapping(value = "/registrarpedido.htm")
	public ModelAndView guardarpedido(@RequestParam("contadores") List<String> contadores,
			HttpServletRequest request,Authentication auth) {
		
		int count=contadores.size();
		if(count==0){
			count=1;
		}
		java.util.Date fecharegistro = new java.util.Date();
		Date fecha = new Date();
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		String codUsu = user.getCodUsu();
		String numPed = request.getParameter("pedido0");
		String codProv = request.getParameter("proveedor0");
		Long idprov = (long) proveedorService.getIdbyNombreProveedor(codProv);
		
		Pedido ped = new Pedido();
		ped.setNumPed(numPed);
		ped.setFecReg(new Timestamp(fecharegistro.getTime()));
		ped.setCodProv(idprov);
		ped.setCodUsu(codUsu);
		ped.setFecDate(fecha);
		pedidoService.addPedido(ped);
		

		
		for(int i=0;i<count;i++){
			String pedido = request.getParameter("pedido"+""+i+"");
			String pro = request.getParameter("producto"+""+i+"");
			String serie = request.getParameter("serie"+""+i+"");
			int cantidad = Integer.parseInt(request.getParameter("cantidad"+""+i+""));
			Long idpro = (long) productoDao.getIdbyNombreProducto(pro);
			
				DetPed det = new DetPed();
				det.setNumPed(pedido);
				det.setCantidad(cantidad);
				det.setCodPro(idpro);
				det.setNumSerie(serie);
			
				pedidoService.addDetPed(det);
				
				String[] myserie = serie.split(";");
				for (int j = 0; j < myserie.length; j++) {
					if (myserie[j].trim().length() != 0) {
						NroSeries nro = new NroSeries();
						nro.setIdPro(idpro);
						nro.setNroSer(myserie[j].trim().toUpperCase());
						nro.setDetSer("E");
						productoDao.addNroSeries(nro);
		
					}
				}
				
				Producto produ = productoDao.findByProducto(idpro);
				int x = produ.getStock();
		
				produ.setStock(x+cantidad);
			
				productoDao.editarproducto(produ);
		
		}

		// JOptionPane.showMessageDialog(null, "Se registró exitosamente");
	
		 return new ModelAndView("redirect:/sistema/pedidopanel.htm");

	}

}
