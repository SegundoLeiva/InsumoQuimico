package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo;

@Repository(value="UnidadMineraInsumoSaldoDAO")
public class UnidadMineraInsumoSaldoDAOImpl implements UnidadMineraInsumoSaldoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
 
	@SuppressWarnings("unchecked")
	public UnidadMineraInsumoSaldo obtienerStock(String idUnidadMineraInsumo,String idUnidadMineraAlmacen){
		String query = "from UnidadMineraInsumoSaldo where idUnidadMineraInsumo='"+idUnidadMineraInsumo+"' "
				+ "and idUnidadMineraAlmacen='"+idUnidadMineraAlmacen+"'";
    	List<UnidadMineraInsumoSaldo> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
    }

}


