package com.hochschild.insumoQuimico.controller.envioCorreo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.service.EnvioCorreoService;

@Controller
@RequestMapping(value="/envioCorreo")
public class EnvioCorreoController {
	
	@Autowired
    private EnvioCorreoService envioCorreoService;



    @RequestMapping(value={"/envioCorreo.htm"}, method={RequestMethod.GET})
    @ResponseBody
    public void envioCorreo(HttpServletRequest req) {
    	String idUnidadMinera = req.getParameter("idUnidadMinera");       		
        envioCorreoService.iniciarEnvioCorreoCierrePeriodo(idUnidadMinera);

    }

  
    
}
