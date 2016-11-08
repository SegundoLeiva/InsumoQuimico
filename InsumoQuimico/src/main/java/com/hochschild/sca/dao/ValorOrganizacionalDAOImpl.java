package com.hochschild.sca.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.sca.domain.ValorOrganizacional;

@Repository
public class ValorOrganizacionalDAOImpl implements ValorOrganizacionalDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateSCA")
    private HibernateTemplate hibernateTemplateSeguridad;

    public List<ValorOrganizacional> getValoresOrganizacionales(int idAplicacion, String idUsuario, String idEstructura) {
         String[] paramNames = {"idAplicacion", "idUsuario","idEstructura"};
         String[] values = {""+idAplicacion,idUsuario,idEstructura};

        List<ValorOrganizacional> valores= hibernateTemplateSeguridad.findByNamedQueryAndNamedParam("getValoresOrganizacionales",paramNames,values);

        return valores;
    }
}
