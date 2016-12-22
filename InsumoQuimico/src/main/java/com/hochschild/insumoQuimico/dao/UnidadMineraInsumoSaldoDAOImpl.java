package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoArea;

@Repository(value="UnidadMineraInsumoSaldoDAO")
public class UnidadMineraInsumoSaldoDAOImpl implements UnidadMineraInsumoSaldoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
 
	@SuppressWarnings("unchecked")
	public UnidadMineraInsumoSaldoArea obtenerStockPorArea(String idUnidadMineraArea,String idUnidadMineraInsumo,String idPresentacionInsumo){
		String query = "from UnidadMineraInsumoSaldo where "
				+ "idUnidadMineraArea='"+idUnidadMineraArea+"' "
				+ "and idUnidadMineraInsumo='"+idUnidadMineraInsumo+"' "
				+ "and idPresentacionInsumo='"+idPresentacionInsumo+"'";
    	List<UnidadMineraInsumoSaldoArea> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
    }

}


