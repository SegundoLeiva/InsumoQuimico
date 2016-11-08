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

import com.hochschild.insumoQuimico.domain.SistemaParametros;

@Repository(value = "sistemaParametrosDAO")
public class SistemaParametrosDAOImpl implements SistemaParametrosDAO{

    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    public SistemaParametros getSistemaParametroPorId(String idParametro){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        List<SistemaParametros> registros = null;
        try {
            sessionFactory = hibernateTemplate.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select * from SistemaParametros where idParametro=:idParametro").addEntity(SistemaParametros.class);
            query.setParameter("idParametro", idParametro);
            registros = query.list();
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){transaction.rollback();}
        }finally{
            if(session != null){session.close();}
        }
        if(registros.isEmpty()){
            return null;
        }
        return registros.get(0);
    }
}
