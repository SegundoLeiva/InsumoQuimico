package com.hochschild.sca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraDao;
import com.hochschild.insumoQuimico.domain.UnidadMinera;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.sca.dao.ValorOrganizacionalDAO;
import com.hochschild.sca.domain.ValorOrganizacional;

@Service
public class ValorOrganizacionalServiceImpl implements ValorOrganizacionalService {
    @Autowired
    private ValorOrganizacionalDAO valorOrganizacionalDAO;
    @Autowired
    private UnidadMineraDao unidadMineraDAO;

    public List<ValorOrganizacionalSesion> getValores(String idAplicacion, String idUsuario, String idEstructura) {
        List<ValorOrganizacional> valores = valorOrganizacionalDAO.getValoresOrganizacionales(Integer.parseInt(idAplicacion), idUsuario, idEstructura);
        List<ValorOrganizacionalSesion> resultado = cargaListaValorOrganizacionalSesion(valores, idEstructura);
        return resultado;
    }

    protected List<ValorOrganizacionalSesion> cargaListaValorOrganizacionalSesion(List<ValorOrganizacional> valores, String idEstructura) {
        List<ValorOrganizacionalSesion> resultado = new ArrayList<ValorOrganizacionalSesion>();
        ValorOrganizacionalSesion item = null;
        for (ValorOrganizacional valor : valores) {
            item = new ValorOrganizacionalSesion();
            item.setTipoValorOrganizacional(idEstructura);
            item.setValorOrganizacional(valor.getValor());
            resultado.add(item);
        }
        return resultado;
    }

    public List<ValorOrganizacionalSesion> getValoresDescripcion(List<ValorOrganizacionalSesion> valores) {        
        List<ValorOrganizacionalSesion> listaOrdenada = new ArrayList<ValorOrganizacionalSesion>();
        if (!valores.isEmpty()) {
            listaOrdenada = creaListaValoresOrganizacionalesSesionOrdenada(valores);
        }
        return listaOrdenada;
    }

    protected List<ValorOrganizacionalSesion> creaListaValoresOrganizacionalesSesionOrdenada(List<ValorOrganizacionalSesion> valores) {
        
        List<ValorOrganizacionalSesion> listaOrdenada = new ArrayList<ValorOrganizacionalSesion>();

        String tipoValorOrganizacional = valores.get(0).getTipoValorOrganizacional();

        if (tipoValorIsUnidadMinera(tipoValorOrganizacional)) {

            List<String> idUnidadesMineras = cargaListaId(valores);
            List<UnidadMinera> unidades = unidadMineraDAO.getListaVigentesPorIds(idUnidadesMineras);
            
            if (!unidades.isEmpty()) {
                HashMap<String, ValorOrganizacionalSesion> mapaValores = creaMapaValoresOrganizacionales(valores);
                for (UnidadMinera unidad : unidades) {
                    ValorOrganizacionalSesion item = mapaValores.get(unidad.getIdUnidadMinera());
                    item.setDescripcion(unidad.getAbreviaturaUnidadMinera());
                    listaOrdenada.add(item);
                }
            }
        }
        return listaOrdenada;
    }

    protected List<String> cargaListaId(List<ValorOrganizacionalSesion> valores) {
        List<String> idValores = new ArrayList<String>();
        for (ValorOrganizacionalSesion item : valores) {
            idValores.add(item.getValorOrganizacional());
        }
        return idValores;
    }

    protected boolean tipoValorIsUnidadMinera(String tipoValor) {
        return tipoValor.equals("WERKS");
    }

    protected HashMap<String, ValorOrganizacionalSesion> creaMapaValoresOrganizacionales(List<ValorOrganizacionalSesion> valores) {
        HashMap<String, ValorOrganizacionalSesion> mapaValores = new HashMap<String, ValorOrganizacionalSesion>();
        for (ValorOrganizacionalSesion valor : valores) {
            mapaValores.put(valor.getValorOrganizacional(), valor);
        }
        return mapaValores;
    }
    
    public String getIdUnidadMineraPorDefecto(List<ValorOrganizacionalSesion> valores) {
        if(valores != null && valores.size() > 0){
            return valores.get(0).getValorOrganizacional();
        }else{
            return "";
        }
    }
}
