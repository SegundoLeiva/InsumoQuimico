package com.hochschild.insumoQuimico.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.DataBaseVersion;

@Repository(value="dataBaseDAO")
public class DataBaseDAOImpl implements DataBaseDAO{
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    public HibernateTemplate hibernateTemplate;

    public String getDataBaseVersion(){
        return  ((DataBaseVersion) hibernateTemplate.findByNamedQuery("getDataBaseVersion").get(0)).getVersion();
    }
}
