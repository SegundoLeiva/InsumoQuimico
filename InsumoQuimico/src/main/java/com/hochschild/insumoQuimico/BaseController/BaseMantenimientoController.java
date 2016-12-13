package com.hochschild.insumoQuimico.BaseController;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.util.Constantes;


public abstract class BaseMantenimientoController {
	
	public Usuario usuario;
	
	@RequestMapping(value = "/nuevo.htm")
	public String nuevo(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		model = this.setViewAttributes(model);
		return this.getPaginaMantenimiento();
	}
	
	@RequestMapping(value = { "/modificar.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String modificar(HttpSession sesion,
			@RequestParam String id, Model model) throws IOException {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		model = this.setModificarAttributes(id,model);
		model.addAttribute("flagEditar", Constantes.FLAG_EDITAR);

		return this.getPaginaMantenimiento();
	}
	
	public abstract String getPaginaMantenimiento();
	
	public abstract Model setViewAttributes(Model model);
	
	public abstract Model setModificarAttributes(String id,Model model);

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
