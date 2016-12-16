package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.json.JSONException;

import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;

public interface InsumoService {

	List<Insumo> listaInsumo();
	public Insumo obtieneInsumoPorId(String id);
	public void insertarInsumo(InsumoParametrosEntrada data) throws JSONException;
	public void eliminarInsumo(String idInsumo);
}
