package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaModel;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaReporteModel;
import com.hochschild.insumoQuimico.domain.ConsumoParametrosEntrada;

public interface ConsumoService {

	public void actualizarConsumo(Consumo Consumo);
	public String guardarConsumo(ConsumoParametrosEntrada Consumo);
	public void eliminarConsumo(String idConsumo);
	public Consumo obtieneConsumoPorId(String id);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel);
	public List<ConsumoConsulta> listaConsumoConsultaReporte(ConsumoConsultaReporteModel consumoConsultaReporteModel);
}
