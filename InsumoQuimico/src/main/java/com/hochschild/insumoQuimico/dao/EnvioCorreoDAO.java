package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.EnvioCorreo;

public interface EnvioCorreoDAO {


	public void insertarEnvioCorreo(EnvioCorreo data);
	public int obtenerIdPorUnidadMinera(String idUnidadMinera);

}
