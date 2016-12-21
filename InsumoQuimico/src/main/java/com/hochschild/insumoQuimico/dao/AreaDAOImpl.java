package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.util.Constantes;

@Repository(value="AreaDAO")
public class AreaDAOImpl implements AreaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<Area> listaArea() {
    	String query = "from Area where vigencia!='E'";
    	List<Area> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public Area obtieneAreaPorId(String id){
        return hibernateTemplate.get(Area.class, new Long(id));
    }

	public void insertarArea(Area data) {
		hibernateTemplate.persist(data);
		
	}

	public void actualizarArea(Area data) {
		hibernateTemplate.update(data);
		
	}

	public void eliminarArea(String idArea) {
		Area area = new Area();
		area = hibernateTemplate.get(Area.class, new Long(idArea));
		area.setVigencia(Constantes.ESTADO_ELIMINADO);
		hibernateTemplate.update(area);
		
	}
}


