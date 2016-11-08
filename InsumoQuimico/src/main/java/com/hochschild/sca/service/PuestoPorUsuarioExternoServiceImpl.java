package com.hochschild.sca.service;

import com.hochschild.sca.domain.PuestoPorUsuarioExterno;
import com.hochschild.sca.dao.PuestoPorUsuarioExternoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoPorUsuarioExternoServiceImpl implements PuestoPorUsuarioExternoService {
    
    @Autowired
    private PuestoPorUsuarioExternoDAO puestoPorUsuarioExternoDAO;

    public PuestoPorUsuarioExterno getPuestoPorUsuarioExterno(String usuario){
        return puestoPorUsuarioExternoDAO.getPuestoPorUsuarioExterno(usuario);
    }

}
