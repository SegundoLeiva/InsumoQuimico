

package com.hochschild.sca.service;

import com.hochschild.sca.domain.OpcionAccionesSCA;
import java.util.List;

public interface OpcionesAccionesSCAService {

    public List<OpcionAccionesSCA> getOpcionesAccionesSCA(String idAplicacion, String idUsuario);

    
}
