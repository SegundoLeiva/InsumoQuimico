

package com.hochschild.sca.service;

import com.hochschild.sca.domain.OpcionAcciones;
import java.util.List;

/**
 *
 * @author Edson
 */
public interface OpcionesService {

    public List<OpcionAcciones> getOpciones(String idAplicacion, String idUsuario);

    
}
