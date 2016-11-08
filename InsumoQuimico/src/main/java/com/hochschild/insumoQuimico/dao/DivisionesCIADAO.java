package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.DivisionesCIA;

public interface DivisionesCIADAO {

	public DivisionesCIA obtenerDivisionesCIAPorId(
			String idSociedad,String idDivision);
}
