package com.hochschild.insumoQuimico.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.CorrelativoBD;
import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;

@Repository(value="MercaderiaDAO")
public class MercaderiaDAOImpl implements MercaderiaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void actualizarMercaderia(Mercaderia data){
		hibernateTemplate.update(data);
    }

	public Mercaderia obtieneMercaderiaPorId(String id){
        return hibernateTemplate.get(Mercaderia.class, id);
    }
	
    @Transactional
	public void insertarMercaderia(Mercaderia data){
		hibernateTemplate.persist(data);
    }

    @SuppressWarnings("unchecked")
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaModel){	
    	List<MercaderiaConsulta> listaMercaderiaConsulta =  new ArrayList<MercaderiaConsulta>();
    	try {
    		MercaderiaConsulta mercaderiaConsulta = new MercaderiaConsulta();
        	BeanUtils.copyProperties(mercaderiaConsulta, mercaderiaConsultaModel);
            String[] paramNames = {"idUnidadMinera","idMercaderia","idUnidadMineraAlmacen","rucProveedor","guiaRemision","fechaInicio","fechaFin","idUsuarioCreacion"};        
            String[] values = {mercaderiaConsulta.getIdUnidadMinera(),mercaderiaConsulta.getIdMercaderia(),
            		mercaderiaConsulta.getIdUnidadMineraAlmacen(),mercaderiaConsulta.getRucProveedor(),
            		mercaderiaConsulta.getGuiaRemision(),mercaderiaConsultaModel.getFechaInicio(),mercaderiaConsultaModel.getFechaFin(), mercaderiaConsulta.getIdUsuarioCreacion()};
            listaMercaderiaConsulta = hibernateTemplate.findByNamedQueryAndNamedParam("listaMercaderia",paramNames,values);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return listaMercaderiaConsulta;
    }
    
	
	@Transactional
	public void eliminarMercaderia(String idMercaderia) {
		// TODO Auto-generated method stub
    	
    	//EliminarDetalle
    	hibernateTemplate.bulkUpdate("DELETE MercaderiaDetalle where "
    			+ "idMercaderia=? ", idMercaderia);
    	
    	//EliminarMercaderia
    	hibernateTemplate.bulkUpdate("DELETE Mercaderia where "
    			+ "idMercaderia=? ", idMercaderia);
	}
	
	@SuppressWarnings("unchecked")
	public String obtenerCorrelativoMercaderia(String idUnidadMinera) {
		String namedQuery = "correlativoMercaderia";
        String[] nameParams = {"idUnidadMinera"};
        Object[] paramValues = {idUnidadMinera};

        List<CorrelativoBD> idGenerado = hibernateTemplate.findByNamedQueryAndNamedParam(namedQuery,nameParams,paramValues);

        if(idGenerado.isEmpty()){
            return "";
        }else{
            return idGenerado.get(0).getCorrelativo();
        }
	}
}



