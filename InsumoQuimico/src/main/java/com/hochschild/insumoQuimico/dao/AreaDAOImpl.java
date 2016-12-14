package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Area;

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
        return hibernateTemplate.get(Area.class, id);
    }

	public void insertarArea(Area data) {
		hibernateTemplate.persist(data);
		
	}

	public void actualizarArea(Area data) {
		hibernateTemplate.update(data);
		
	}

	public void eliminarArea(String idArea) {
		Area area = new Area();
		area = hibernateTemplate.get(Area.class, idArea);
		area.setVigencia("E");
		hibernateTemplate.update(area);
		
	}
	
	@SuppressWarnings("unchecked")
	public int obtenerId() {
		try {
			String query = "from Area order by idArea desc";
	    	List<Area> resultado = hibernateTemplate.find(query);
	        return  Integer.parseInt(resultado.get(0).getIdArea())+1;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
    	
    }
}


