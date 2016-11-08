package com.hochschild.sca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.sca.local.dao.OpcionesPantallaSistemaDAO;
import com.hochschild.sca.local.domain.OpcionPantallaSistema;

@Service
public class OpcionesPantallaSistemaServiceImpl implements OpcionesPantallaSistemaService {
    @Autowired
    private OpcionesPantallaSistemaDAO opcionesPantallaSistemaDAO;

    public void getOpcionesPantalla(String idAplicacion, String idUsuario) {
        opcionesPantallaSistemaDAO.getAccionesInOpciones(idUsuario);
    }

    public List<OpcionPantallaSistema> getListaOpcionesSIO(String opciones){
        return opcionesPantallaSistemaDAO.getAccionesInOpciones(opciones);
    }
}
