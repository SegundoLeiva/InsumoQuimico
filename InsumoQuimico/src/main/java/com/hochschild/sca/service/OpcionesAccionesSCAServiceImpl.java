package com.hochschild.sca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.sca.dao.OpcionesAccionesSCADAO;
import com.hochschild.sca.domain.OpcionAccionesSCA;

@Service
public class OpcionesAccionesSCAServiceImpl implements OpcionesAccionesSCAService {
    @Autowired
    private OpcionesAccionesSCADAO opcionesAccionesSCADAO;

	public List<OpcionAccionesSCA> getOpcionesAccionesSCA(String idAplicacion,
			String idUsuario) {
		// TODO Auto-generated method stub
		return opcionesAccionesSCADAO.getOpcionesAccionesSCA(idAplicacion, idUsuario);
	}
}
