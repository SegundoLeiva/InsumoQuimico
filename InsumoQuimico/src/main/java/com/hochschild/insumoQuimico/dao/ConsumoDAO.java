package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;

public interface ConsumoDAO {

	public Consumo obtieneConsumoPorId(String id);
	public void actualizarConsumo(Consumo data);
	public void insertarConsumo(Consumo data);
	public void eliminarConsumo(String idConsumo);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsulta ConsumoConsulta,String fechaInicio,String fechaFin);
	public String obtenerCorrelativoConsumo(String idUnidadMinera);
}
