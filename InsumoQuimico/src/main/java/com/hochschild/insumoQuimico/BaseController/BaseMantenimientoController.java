package com.hochschild.insumoQuimico.BaseController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hochschild.insumoQuimico.domain.JsonResult;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.util.Constantes;


public abstract class BaseMantenimientoController {
	
	public Usuario usuario;
	public Object formMantenimiento;
	protected boolean mostrarBotonGuardar = true;
	protected boolean mostrarBotonRegresar = true;
	protected String accion;
	public static final String ACCION_NUEVO = "NUEVO";
	public static final String ACCION_EDITAR= "EDITAR";
	public static final String ACCION_CONSULTAR= "CONSULTAR";
	
	@RequestMapping(value = "/nuevo.htm")
	public String nuevo(Model model,HttpSession sesion) {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		this.accion = ACCION_NUEVO;
		model = mostrarBotones(model);
		model = this.setViewAttributes(model);
		return this.getPaginaMantenimiento();
	}
	
	@RequestMapping(value = "/grabar.htm", method = RequestMethod.POST)
	@ResponseBody
	public String grabar(HttpServletRequest req) throws  JSONException, IllegalAccessException, InvocationTargetException {
		boolean success=true;
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		this.formMantenimiento=getFormMantenimiento();
		BeanUtils.populate(this.formMantenimiento, req.getParameterMap());

		if(this.setGrabarAttributes()){
			if(this.accion.equals(ACCION_EDITAR)){
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}

		}else{
			success=false;
			mensaje = Constantes.TRANSACCION_ERROR;
		}

		return new JsonResult(success,mensaje).getJsonObject();
	}
	
	@RequestMapping(value = { "/modificar.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String modificar(HttpSession sesion,
			@RequestParam String id, Model model) throws IOException {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		this.accion = ACCION_EDITAR;
		model = mostrarBotones(model);
		model = this.setModificarAttributes(id,model);
		model.addAttribute(Constantes.ACCION, this.accion);

		return this.getPaginaMantenimiento();
	}
	
	@RequestMapping(value = { "/consultar.htm" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String consultar(HttpSession sesion,
			@RequestParam String id, Model model) throws IOException {
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.usuario = usuarioSession;
		this.accion = ACCION_CONSULTAR;
		model.addAttribute("mostrarBotonGuardar", false);
		model.addAttribute("mostrarBotonRegresar", this.mostrarBotonRegresar);
		model = this.setModificarAttributes(id,model);
		model.addAttribute(Constantes.ACCION, this.accion);

		return this.getPaginaMantenimiento();
	}
	
	public Model mostrarBotones(Model model){
		model.addAttribute("mostrarBotonGuardar", this.mostrarBotonGuardar);
		model.addAttribute("mostrarBotonRegresar", this.mostrarBotonRegresar);
		return model;
	}
	
	public abstract Object getFormMantenimiento();
	
	public abstract String getPaginaMantenimiento();
	
	public abstract Model setViewAttributes(Model model);
	
	public abstract boolean setGrabarAttributes();
	
	public abstract Model setModificarAttributes(String id,Model model);

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isMostrarBotonGuardar() {
		return mostrarBotonGuardar;
	}

	public void setMostrarBotonGuardar(boolean mostrarBotonGuardar) {
		this.mostrarBotonGuardar = mostrarBotonGuardar;
	}

	public boolean isMostrarBotonRegresar() {
		return mostrarBotonRegresar;
	}

	public void setMostrarBotonRegresar(boolean mostrarBotonRegresar) {
		this.mostrarBotonRegresar = mostrarBotonRegresar;
	}

	public void setFormMantenimiento(Object formMantenimiento) {
		this.formMantenimiento = formMantenimiento;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
}
