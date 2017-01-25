package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaModel;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaReporteModel;

public interface ConsumoDAO {

	public Consumo obtieneConsumoPorId(String id);
	public void actualizarConsumo(Consumo data);
	public void insertarConsumo(Consumo data);
	public void eliminarConsumo(String idConsumo);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel ConsumoConsultaModel);
	public List<ConsumoConsulta> listaConsumoConsultaReporte(ConsumoConsultaReporteModel consumoConsultaReporteModel);
	public String obtenerCorrelativoConsumo(String idUnidadMinera);
}
