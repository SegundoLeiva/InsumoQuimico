package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.ConsumoDetalle;

public interface ConsumoDetalleDAO {

	public void insertarConsumoDetalle(ConsumoDetalle data);
	public void eliminarConsumoDetalle(int idConsumoDetalle, String idConsumo);
	public void modificarConsumoDetalle(ConsumoDetalle data);
	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id);
	public ConsumoDetalle obtenerConsumoDetalle(String idSolPed,String idSolPedDetalle);
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(String idUnidadMinera,String anio,String mes);
}
