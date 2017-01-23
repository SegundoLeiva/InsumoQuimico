package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.InsumoPresentacion;

public interface PresentacionInsumoService {

	public List<InsumoPresentacion> listaPresentacionInsumoPorInsumo(int idInsumo);
}
