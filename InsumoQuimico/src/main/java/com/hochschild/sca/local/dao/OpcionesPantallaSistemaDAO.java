package com.hochschild.sca.local.dao;

import com.hochschild.sca.local.domain.OpcionPantallaSistema;
import java.util.List;

public interface OpcionesPantallaSistemaDAO {

   OpcionPantallaSistema getById(int idOpcion);
   public List<OpcionPantallaSistema> getAccionesInOpciones(String opciones);
}
