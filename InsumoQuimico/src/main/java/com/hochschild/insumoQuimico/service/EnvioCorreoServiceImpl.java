package com.hochschild.insumoQuimico.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.CalendarioGestionDAO;
import com.hochschild.insumoQuimico.dao.CatalogoDetalleDAO;
import com.hochschild.insumoQuimico.dao.EnvioCorreoDAO;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CatalogoDetalle;
import com.hochschild.insumoQuimico.domain.EnvioCorreo;
import com.hochschild.insumoQuimico.domain.EnvioCorreo.IdEnvioCorreo;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.MailUtil;

@Service
public class EnvioCorreoServiceImpl implements EnvioCorreoService {

	public static final int CORREO_ENCARGADO_CIERRE = 7;
	public static final int RESPONSABLE_SUNAT = 8;
	
	@Autowired
	public CalendarioGestionDAO calendarioGestionDAO;
	@Autowired
	public CatalogoDetalleDAO catalogoDetalleDAO;
	@Autowired
	public EnvioCorreoDAO envioCorreoDAO;
	
    public void iniciarEnvioCorreoCierrePeriodo(String idUnidadMinera){
    	
		CalendarioGestion calendario = calendarioGestionDAO.obtieneCalendarioGestionPorIdUnidadMinera(idUnidadMinera);
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(calendario.getFechaFin());
		cal.add(Calendar.DATE, calendario.getDiasTolerancia());

		if (date.after(cal.getTime()) && calendario.getAperturado().equals("S")) {
			String cuerpoCorreo = "Estimado Usuario necesita cerrar el periodo enero, por favor ingresar al aplicativo.";
			String titulo = "Notificacion de Cierre de Periodo";
			
			List<CatalogoDetalle> listEncargado = catalogoDetalleDAO.listaCatalogoDetalleByIdCatalogo(CORREO_ENCARGADO_CIERRE);
			List<CatalogoDetalle> listResponsableSunat = catalogoDetalleDAO.listaCatalogoDetalleByIdCatalogo(RESPONSABLE_SUNAT);
			String correosEncargados="";
			String correosCopias="";
			for (int i = 0; i < listEncargado.size(); i++) {
				if(listEncargado.get(i).getId().getIdCatalogoDetalle().split("-")[0].equals(idUnidadMinera)){
					correosEncargados = correosEncargados+listEncargado.get(i).getDescripcion()+",";
				}
			}
			
			for (int i = 0; i < listResponsableSunat.size(); i++) {
				correosCopias = correosCopias+listResponsableSunat.get(i).getDescripcion()+",";
			}
			
			
			
			String estadoCorreo = MailUtil.enviarEmail(Constantes.MAIL_HOST, Constantes.MAIL_REMITENTE
						, correosEncargados,correosCopias, titulo, cuerpoCorreo);
			
			EnvioCorreo envioCorreo = new EnvioCorreo();
			IdEnvioCorreo id = new IdEnvioCorreo();
			id.setIdEnvioCorreo(envioCorreoDAO.obtenerIdPorUnidadMinera(idUnidadMinera));
			id.setIdUnidadMinera(idUnidadMinera);
			envioCorreo.setId(id);
			envioCorreo.setTextoCorreo(cuerpoCorreo);
			envioCorreo.setToCorreo(correosEncargados);
			envioCorreo.setCcCorreo(correosCopias);
			envioCorreo.setEstadoCorreo(estadoCorreo);
			envioCorreo.setFechaEnvioCorreo(new Date());
			envioCorreoDAO.insertarEnvioCorreo(envioCorreo);
		}
			
    	
	}

   
}

