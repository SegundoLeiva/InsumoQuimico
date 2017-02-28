package com.hochschild.insumoQuimico.controller.reporte;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseReporteController;
import com.hochschild.insumoQuimico.domain.CatalogoDetalle;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.CatalogoDetalleService;
import com.hochschild.insumoQuimico.service.ConsumoDetalleService;
import com.hochschild.insumoQuimico.service.EstablecimientosService;
import com.hochschild.insumoQuimico.service.MercaderiaDetalleService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.FechasUtil;

@Controller
@RequestMapping(value = "/reporte")
public class ReporteController extends BaseReporteController{

	@Autowired
	private MercaderiaDetalleService mercaderiaDetalleService;
	@Autowired
	private CatalogoDetalleService catalogoDetalleService;
	@Autowired
	private ConsumoDetalleService consumoDetalleService;
	@Autowired
	private EstablecimientosService establecimientosService;
	
	@Override
	public String getPaginaReporte() {
		// TODO Auto-generated method stub
		return "verReporte";
	}
	
	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		List<CatalogoDetalle> listRangoAnio = catalogoDetalleService.listaCatalogoDetalleByIdCatalogo(6) ;
		List<ValorOrganizacionalSesion> listaUnidadesMineras = this.usuario.getListaUnidadesMineras();
        model.addAttribute("listaUnidadesMineras", listaUnidadesMineras);
		model.addAttribute("listRangoAnio", listRangoAnio);
		model.addAttribute("anioActual", FechasUtil.getAnioActual());
		model.addAttribute("mesActual", FechasUtil.getMesActual());
		return model;
	}

	@RequestMapping(value = "/generarReporte.htm")
	public void generarReporte(HttpServletRequest req,HttpServletResponse response) throws IOException {
		String mes = req.getParameter("mes");
		String anio = req.getParameter("anio");
		String _idUnidadMinera = req.getParameter("idUnidadMinera");
		String cadena ="";
		List<MercaderiaDetalle> listaMercaderiaDetalle = mercaderiaDetalleService.obtenerMercaderiaDetalleReporte(_idUnidadMinera,anio, mes);
		List<ConsumoDetalle> listaConsumoDetalle = consumoDetalleService.obtenerConsumoDetalleReporte(_idUnidadMinera,anio, mes);
		CatalogoDetalle catalogo = catalogoDetalleService.obtenerCatalogoDetalleById(2, "1");//RUC COMPAÑIA
		String rucCompania = catalogo.getDescripcion();
		
		for (int i = 0; i < listaMercaderiaDetalle.size(); i++) {
			String tipoOperacion = Constantes.TIPO_OPERACION_INGRESO;
			String tipoTransaccion = Constantes.TIPO_TRANSACCION_INGRESO;
			String tipoDocumentoTransaccion = Constantes.TIPO_DOCUMENTO_TRANSACCION_INGRESO;
			String tipoDocumentoDestinatario = Constantes.TIPO_DOCUMENTO_DESTINATARIO;
		    String tipoDocumentoTranferir = Constantes.TIPO_DOCUMENTO_TRANSFERIR;
			String fechaMercaderia = FechasUtil.dateToString(listaMercaderiaDetalle.get(i).getMercaderia().getFechaMercaderia(), "dd/MM/yyyy");
			String rucProveedor = listaMercaderiaDetalle.get(i).getMercaderia().getRucProveedor();
			String cantidadPresentacion = String.valueOf((int)listaMercaderiaDetalle.get(i).getCantidad().doubleValue());
			String codigoPresentacion = listaMercaderiaDetalle.get(i).getUnidadMineraInsumoPresentacion().getPresentacionInsumo().getCodigoPresentacion();
			String guiaRemision = listaMercaderiaDetalle.get(i).getMercaderia().getGuiaRemision();
			String idEstablecimiento = establecimientosService.obtieneEstablecimientosPorIdUnidadMinera(listaMercaderiaDetalle.get(i).getUnidadMineraInsumoPresentacion().getIdUnidadMinera()).getIdEstablecimiento();
			cadena=cadena +tipoOperacion+"|"+idEstablecimiento+"|"+tipoTransaccion+"|"+codigoPresentacion+"|"+cantidadPresentacion+"|"+tipoDocumentoTransaccion+"|"+guiaRemision+"|"+fechaMercaderia+"|"+tipoDocumentoDestinatario+"|"+rucCompania+"|"+tipoDocumentoTranferir+"|"+rucProveedor+"||||||||"+"\r\n";
		}
		
		for (int i = 0; i < listaConsumoDetalle.size(); i++) {
			String tipoOperacion = Constantes.TIPO_OPERACION_CONSUMO;
			String tipoTransaccion = Constantes.TIPO_TRANSACCION_CONSUMO;
			String tipoDocumentoBien = Constantes.TIPO_DOCUMENTO_RELACIONADO_DEL_BIEN;
			String tipoDocumentoTransaccion = Constantes.TIPO_DOCUMENTO_TRANSACCION_CONSUMO;
			String fechaConsumo = FechasUtil.dateToString(listaConsumoDetalle.get(i).getConsumo().getFechaConsumo(), "dd/MM/yyyy");
			String cantidadPresentacion = listaConsumoDetalle.get(i).getCantidadPresentacion().toString();
			String codigoPresentacion = listaConsumoDetalle.get(i).getUnidadMineraInsumoPresentacion().getPresentacionInsumo().getCodigoPresentacion();
			String idEstablecimiento = establecimientosService.obtieneEstablecimientosPorIdUnidadMinera(listaConsumoDetalle.get(i).getUnidadMineraInsumoPresentacion().getIdUnidadMinera()).getIdEstablecimiento();
			cadena=cadena +tipoOperacion+"|"+idEstablecimiento+"|"+tipoTransaccion+"|"+codigoPresentacion+"|"+cantidadPresentacion+"|"+tipoDocumentoTransaccion+"|KARDEX|"+fechaConsumo+"|"+tipoDocumentoBien+"|"+rucCompania+"|||||||||||"+"\r\n";
		}

		descargarArchivoTxt(response, "reporte_"+FechasUtil.obtenerMesDescripcion(mes)+"_"+anio, cadena);
	}

}
