package com.hochschild.sca.dao;

import com.hochschild.sca.domain.OpcionAcciones;
import com.hochschild.sca.domain.OpcionMenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OpcionesDAOImpl implements OpcionesDAO {

    @Autowired
    @Qualifier(value="hibernateTemplateSCA")
    private HibernateTemplate hibernateTemplateSeguridad;
    
    public List<String> getOpciones(String idAplicacion, String idUsuario) {

        String[] paramNames = {"idAplicacion", "idUsuario"};
         String[] values = {idAplicacion, idUsuario};

        List<OpcionMenu> opciones= hibernateTemplateSeguridad.findByNamedQueryAndNamedParam("getOpciones", paramNames, values);

        List<String> resultado = new ArrayList<String>();

        for( OpcionMenu opcion : opciones){
            resultado.add(String.valueOf(opcion.getIdOpcion()));
        }

        return resultado;
    }

    public List<OpcionAcciones> getOpcionesAcciones(String idAplicacion, String idUsuario) {        
         String[] paramNames = {"idAplicacion", "idUsuario"};
         String[] values = {idAplicacion,idUsuario};

        List<OpcionAcciones> opciones= hibernateTemplateSeguridad.findByNamedQueryAndNamedParam("getOpcionesAcciones",paramNames,values);

        return opciones;
    }
}
