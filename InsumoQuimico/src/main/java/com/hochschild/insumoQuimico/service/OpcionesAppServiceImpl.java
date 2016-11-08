package com.hochschild.insumoQuimico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.OpcionesAppDAO;
import com.hochschild.insumoQuimico.dao.SistemaParametrosDAO;
import com.hochschild.insumoQuimico.domain.OpcionApp;
import com.hochschild.insumoQuimico.domain.SistemaParametros;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.Util;
import com.hochschild.sca.dao.OpcionesAccionesSCADAO;
import com.hochschild.sca.domain.OpcionAccionesSCA;


@Service
public class OpcionesAppServiceImpl implements OpcionesAppService {

    @Autowired
    private OpcionesAppDAO opcionesAppDAO;
    @Autowired
    private OpcionesAccionesSCADAO opcionesAccionesSCADAO;
    
    @Autowired
    private SistemaParametrosDAO sistemaParametrosDAO;

    public List<OpcionApp> listaOpcionesApp(String idAplicacion, String idUsuario){
        
        List<OpcionAccionesSCA> listaOpccionesAccionesSCAT = new ArrayList<OpcionAccionesSCA>();
        
        SistemaParametros sistemaParametrosBA = sistemaParametrosDAO.getSistemaParametroPorId(Constantes.ID_ROL_BASICO);        
        String idRolBasico = sistemaParametrosBA.getValorParametro();
        
        List<OpcionAccionesSCA> listaOpcionesAccionesSCARolBasico = new ArrayList<OpcionAccionesSCA>(); 
                
        if(listaOpcionesAccionesSCARolBasico != null && listaOpcionesAccionesSCARolBasico.size()>0){
            listaOpccionesAccionesSCAT.addAll(listaOpcionesAccionesSCARolBasico);
        }
        
        List<OpcionAccionesSCA> listaOpcionesAccionesSCA = opcionesAccionesSCADAO.getOpcionesAccionesSCA(idAplicacion,idUsuario);
        if(listaOpcionesAccionesSCA != null && listaOpcionesAccionesSCA.size() > 0){
            listaOpccionesAccionesSCAT.addAll(listaOpcionesAccionesSCA);
        }
        
        String opcionesAccioneSCA = Util.concatenaOpcionesAccionesSCA(listaOpccionesAccionesSCAT);
        List<OpcionApp> listaOpcionesApp = opcionesAppDAO.getOpcionesApp(idAplicacion,opcionesAccioneSCA);
        return listaOpcionesApp;
    }

}
