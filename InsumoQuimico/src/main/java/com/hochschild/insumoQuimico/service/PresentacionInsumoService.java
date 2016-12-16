package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.PresentacionInsumo;

public interface PresentacionInsumoService {

	public List<PresentacionInsumo> listaPresentacionInsumoPorInsumo(int idInsumo);
}
