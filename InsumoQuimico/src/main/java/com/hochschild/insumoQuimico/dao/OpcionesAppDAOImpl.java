package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.OpcionApp;

@Repository(value="opcionesAppDAO")
public class OpcionesAppDAOImpl implements OpcionesAppDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    public List<OpcionApp> getOpcionesApp(String idAplicacion, String opciones) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        List<OpcionApp> resultado = null;
        try{
            sessionFactory = hibernateTemplate.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("{call dbo.stpr_GeneraMenuApp(:idAplicacion,:opciones)}").addEntity(OpcionApp.class);
            query.setParameter("idAplicacion", idAplicacion);
            query.setParameter("opciones", opciones);
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
