package com.hochschild.sca.service;

import com.hochschild.sca.domain.PuestoPorUsuario;
import com.hochschild.sca.dao.PuestoPorUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoPorUsuarioServiceImpl implements PuestoPorUsuarioService{
    
    @Autowired
    private PuestoPorUsuarioDAO puestoPorUsuarioDAO;

    public PuestoPorUsuario getPuestoPorUsuario(String usuario){        
        return puestoPorUsuarioDAO.getPuestoPorUsuario(usuario);
    }

}
