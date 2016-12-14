package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.UnidadMineraMovimientosInsumos;

@Repository(value="UnidadMineraMovimientosInsumosDAO")
public class UnidadMineraMovimientosInsumosDAOImpl implements UnidadMineraMovimientosInsumosDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void actualizarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data){
		hibernateTemplate.update(data);
    }

	@SuppressWarnings("unchecked")
	public UnidadMineraMovimientosInsumos obtienerUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data){
		String query = "from UnidadMineraMovimientosInsumos where codigoSolicitud='"+data.getCodigoSolicitud()+"'"
				+ "and tipoMovimiento='"+data.getTipoMovimiento()+"' and idUnidadMineraInsumo='"+data.getIdUnidadMineraInsumo()+"'";
    	List<UnidadMineraMovimientosInsumos> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
    }
	
    @Transactional
	public void insertarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data){
		hibernateTemplate.persist(data);
    }

	public void eliminarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE UnidadMineraMovimientosInsumos where "
    			+ "codigoSolicitud=? and tipoMovimiento=? and idUnidadMineraInsumo=?", data.getCodigoSolicitud(),
    			data.getTipoMovimiento(),data.getIdUnidadMineraInsumo());
	}

}



