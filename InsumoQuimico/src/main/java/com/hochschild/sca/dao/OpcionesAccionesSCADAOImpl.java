package com.hochschild.sca.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.sca.domain.OpcionAccionesSCA;

@Repository
public class OpcionesAccionesSCADAOImpl implements OpcionesAccionesSCADAO {

    @Autowired
    @Qualifier(value="hibernateTemplateSCA")
    private HibernateTemplate hibernateTemplateSeguridad;
    
    /*public List<String> getOpciones(String idAplicacion, String idUsuario) {

        String[] paramNames = {"idAplicacion", "idUsuario"};
         String[] values = {idAplicacion, idUsuario};

        List<OpcionMenu> opciones= hibernateTemplateSeguridad.findByNamedQueryAndNamedParam("getOpciones", paramNames, values);

        List<String> resultado = new ArrayList<String>();

        for( OpcionMenu opcion : opciones){
            resultado.add(String.valueOf(opcion.getIdOpcion()));
        }

        return resultado;
    }*/

    public List<OpcionAccionesSCA> getOpcionesAccionesSCA(String idAplicacion, String idUsuario) {        
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        List<OpcionAccionesSCA> resultado = null;
        try{
            sessionFactory = hibernateTemplateSeguridad.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("{call dbo.stpr_ObtenerOpcionesAccionesSeguridad(:idAplicacion,:idUsuario)}").addEntity(OpcionAccionesSCA.class);
            query.setParameter("idAplicacion", idAplicacion);
            query.setParameter("idUsuario", idUsuario);
            resultado = query.list();
            transaction.commit();            
        }catch(Exception e){            
            if(transaction != null){transaction.rollback();}            
        }finally{
            if(session != null){session.close();}
        }
        return resultado;
    }
  
}
