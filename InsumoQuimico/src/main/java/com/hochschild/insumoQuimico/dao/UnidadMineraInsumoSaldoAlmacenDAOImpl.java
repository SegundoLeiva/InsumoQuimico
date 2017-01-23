package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoAlmacen;

@Repository(value="UnidadMineraInsumoSaldoAlmacenDAO")
public class UnidadMineraInsumoSaldoAlmacenDAOImpl implements UnidadMineraInsumoSaldoAlmacenDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
 
	@SuppressWarnings("unchecked")
	public UnidadMineraInsumoSaldoAlmacen obtienerStockAlmacen(String idUnidadMineraInsumoPresentacion){
		String query = "from UnidadMineraInsumoSaldoAlmacen "
				+ "where idUnidadMineraInsumoPresentacion='"+idUnidadMineraInsumoPresentacion+"'";
    	List<UnidadMineraInsumoSaldoAlmacen> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
    }

}


