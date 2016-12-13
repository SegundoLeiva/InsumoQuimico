package com.hochschild.insumoQuimico.BaseController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.Util;

public abstract class BaseSearchController {
	
	public Object formBusqueda;
	public Usuario usuario;
	
	@RequestMapping(value = { "/buscarConsulta.htm" }, method = { RequestMethod.POST })
	public String buscarConsulta(HttpSession sesion, HttpServletRequest req, Model model) {
		req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_CONSULTAR);
		return this.listar(model, req, sesion);
	}
	
	public Object obtenerConsulta(HttpServletRequest req,HttpSession sesion){
		 this.formBusqueda=getFormBusqueda();

	        if((req.getParameter("cod")!=null) || Util.validFlagTransaccion(req,Constantes.TRANSACCION_ELIMINAR)){
	        	this.formBusqueda = (Object) sesion.getAttribute("beanConsulta");
	        }else if(Util.validFlagTransaccion(req,Constantes.TRANSACCION_CONSULTAR)){
	        	try {
					BeanUtils.populate(this.formBusqueda, req.getParameterMap());
				} catch (Exception e) {} 
	        }
	        return  this.formBusqueda;
	}
	
	public String listar(Model model,HttpServletRequest req,HttpSession sesion){
		
		 this.formBusqueda = obtenerConsulta(req, sesion);
		 List listBusqueda = this.listarConsulta(model, sesion, req);

		 model.addAttribute("listaConsulta", listBusqueda);
		 sesion.setAttribute("beanConsulta", this.formBusqueda);
		 return this.getPaginaSearch();
	}
	
	@RequestMapping(value = "/listar.htm")
	public String setView(Model model,HttpSession sesion,HttpServletRequest req) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		return listar(model, req, sesion);
	}
	
	@RequestMapping(value = "/eliminar.htm", method = RequestMethod.POST)
	public String eliminar(Model model,HttpServletRequest req,HttpSession sesion,
			@RequestParam("id") String id) throws ServletException, IOException {
		if(this.setDeleteAttributes(id)){
			req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ELIMINAR);
		}else{
			req.setAttribute(Constantes.FLAG_TRANSACCION, Constantes.TRANSACCION_ERROR);
		}
		return listar(model, req, sesion);
	}
	
	public abstract Object getFormBusqueda();
	
	public abstract String getPaginaSearch();
	
	public abstract List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req);

	public abstract boolean setDeleteAttributes(String id);
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
