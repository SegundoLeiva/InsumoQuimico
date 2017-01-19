package com.hochschild.insumoQuimico.session;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoDAO;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.OpcionApp;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.service.CalendarioGestionService;
import com.hochschild.insumoQuimico.util.FechasUtil;

public class ApplicationSessionInterceptor implements HandlerInterceptor {

	@Autowired
	public CalendarioGestionService calendarioGestionService;
	 
	public void sessionCreated(HttpSessionEvent event) {
	   System.out.println("Session Created");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	    System.out.println("Session Destroyed");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session = request.getSession(true);
		Usuario usuarioSession = (Usuario) session.getAttribute("session_usuario");
		if(usuarioSession==null){
			response.sendRedirect("../expirarSession.htm");
			return false;
		}else{
			String controller = request.getRequestURI().split("/")[2];
			
			//Metodo para enviar un flag si hay un cierre del mes
			session.setAttribute("cierreMes", null);
			if(controller.equals("ingresarMercaderia") || controller.equals("distribucionMercaderia") || controller.equals("registrarConsumo")){
				session.setAttribute("cierreMes", (String)session.getAttribute("flagCierreMes"));
			}
			//--------------------------------------------------
			
			List<OpcionApp> opciones = usuarioSession.getLst_opciones();
			for (OpcionApp opcionApp : opciones) {
				if(opcionApp.getIdPadre()>0){
					if(controller.equals(opcionApp.getLinkOpcion().split("/")[1]))session.setAttribute("index", opcionApp.getOrden());
					if(controller.equals("home"))session.setAttribute("index", null);
				}			
			}
		}	
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {	
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object arg2, Exception arg3) throws Exception {
		HttpSession session = request.getSession(true);
		Usuario usuarioSession = (Usuario) session.getAttribute("session_usuario");
		if(usuarioSession==null){
			response.sendRedirect("../expirarSession.htm");
		}	
	}
 }