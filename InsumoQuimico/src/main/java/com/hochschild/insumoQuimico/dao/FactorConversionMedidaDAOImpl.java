package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.FactorConversionMedida;

@Repository(value="FactorConversionMedidaDAO")
public class FactorConversionMedidaDAOImpl implements FactorConversionMedidaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<FactorConversionMedida> listaFactorConversionMedida() {
    	String query = "from FactorConversionMedida where idUnidadMedidaA='KG'";
    	List<FactorConversionMedida> resultado = hibernateTemplate.find(query);
        return  resultado;
    }

}


