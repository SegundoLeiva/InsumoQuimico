package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMinera;

@Repository
public class UnidadMineraDaoImpl implements UnidadMineraDao {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    public List<UnidadMinera> getListaVigentesPorIds(List<String> idUnidadesMineras) {
        String query = "from UnidadMinera where idUnidadMinera in (:idsUnidadesMineras) and vigencia ='S' order by abreviaturaUnidadMinera asc";
        String[] paramNames = {"idsUnidadesMineras"};
        Object[] values = {idUnidadesMineras};
        List<UnidadMinera> registros = hibernateTemplate.findByNamedParam(query, paramNames, values);
        return registros;		
    }

}
