package com.hochschild.insumoQuimico.controller.ajax;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hochschild.insumoQuimico.sap.FuncionesSAPService;
import com.hochschild.insumoQuimico.service.ConsumoDetalleServiceImpl;
import com.hochschild.insumoQuimico.service.PresentacionInsumoService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoSaldoAlmacenService;
import com.hochschild.insumoQuimico.service.UnidadMineraInsumoSaldoService;
import com.hochschild.insumoQuimico.util.Constantes;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

	@Autowired
	private FuncionesSAPService funcionesSAPService;
	@Autowired
	private UnidadMineraInsumoSaldoService unidadMineraInsumoSaldoService;
	@Autowired
	private UnidadMineraInsumoSaldoAlmacenService unidadMineraInsumoSaldoAlmacenService;
	@Autowired
	private PresentacionInsumoService presentacionInsumoService;
	@Autowired
	private ConsumoDetalleServiceImpl consumoDetalleServiceImpl;
	
	
	@RequestMapping(value="/getProveedorDescripcion.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String getProveedorDescripcion(@RequestParam("rucProveedor") String rucProveedor) {
		
		String resultado = funcionesSAPService.getProveedorDescripcion(rucProveedor, Constantes.SOCIEDAD_PROVEEDOR);

		return resultado;

	}
	
	@RequestMapping(value="/listaPresentacionInsumoPorInsumo.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String listaPresentacionInsumoPorInsumo(@RequestParam("idInsumo") String idInsumo) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writer().writeValueAsString(presentacionInsumoService.listaPresentacionInsumoPorInsumo(Integer.valueOf(idInsumo)));
		} catch (Exception e) {
			return "";
		}

	}
	
	@RequestMapping(value="/obtienerStockAlmacen.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String obtobtienerStockAlmacenienerStock(@RequestParam("idUnidadMineraInsumoPresentacion") String idUnidadMineraInsumoPresentacion) {
		String resultado = "0";
		try {
			resultado = String.valueOf(unidadMineraInsumoSaldoAlmacenService.obtienerStockAlmacen(idUnidadMineraInsumoPresentacion).getStock());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultado;

	}
	
	@RequestMapping(value="/obtenerStockPorArea.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String obtenerStockPorArea(@RequestParam("idUnidadMineraArea") String idUnidadMineraArea,
			@RequestParam("idUnidadMineraInsumoPresentacion") String idUnidadMineraInsumoPresentacion) {
		String resultado = "0";
		try {
			resultado = String.valueOf(unidadMineraInsumoSaldoService.obtenerStockPorArea(idUnidadMineraArea,idUnidadMineraInsumoPresentacion).getStock());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultado;

	}
	
	@RequestMapping(value="/obtenerConsumoDetallePorIdConsumo.htm", method = RequestMethod.POST)
	@ResponseBody
	public String obtenerConsumoDetallePorIdConsumo(@RequestParam("idConsumo") String idConsumo) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writer().writeValueAsString(consumoDetalleServiceImpl.obtenerConsumoDetallePorIdConsumo(idConsumo));
		} catch (Exception e) {
			return "";
		}

	}
	
}
