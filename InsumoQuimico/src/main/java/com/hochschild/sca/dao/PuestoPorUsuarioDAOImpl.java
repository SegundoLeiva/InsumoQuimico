package com.hochschild.sca.dao;

import com.hochschild.sca.domain.PuestoPorUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PuestoPorUsuarioDAOImpl implements PuestoPorUsuarioDAO {

    @Autowired
    @Qualifier(value="hibernateTemplateSCA")
    private HibernateTemplate hibernateTemplateSeguridad;

    public PuestoPorUsuario getPuestoPorUsuario(String usuario){
        String hql = "from PuestoPorUsuario p where p.idUsuario ='"+usuario+"'";
        List resultado = hibernateTemplateSeguridad.find(hql);
        if(resultado != null && resultado.size() > 0){
            return (PuestoPorUsuario)resultado.get(0);
        }else{
            return null;
        }
    }
}
