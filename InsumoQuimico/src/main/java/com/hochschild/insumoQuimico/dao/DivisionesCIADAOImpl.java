package com.hochschild.insumoQuimico.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.DivisionesCIA;

@Repository(value="DivisionesCIADAO")
public class DivisionesCIADAOImpl implements DivisionesCIADAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
	
    @SuppressWarnings("unchecked")
    public DivisionesCIA obtenerDivisionesCIAPorId(String idSociedad, String idDivision){
        List<DivisionesCIA> resultado = new ArrayList<DivisionesCIA>();
        try {
            String sql = "from DivisionesCIA WHERE idSociedad = '" + idSociedad + "' and idDivision='" + idDivision + "'";
            resultado = hibernateTemplate.find(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if(resultado != null && resultado.size() > 0){
            return resultado.get(0);
        }else{
            return null;
        }
    }

}



