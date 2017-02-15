package com.hochschild.insumoQuimico.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CatalogoDetalle;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.MailUtil;

@Service
public class EnvioCorreoServiceImpl implements EnvioCorreoService {

	public static final int CORREO_ENCARGADO_CIERRE = 7;
	public static final int RESPONSABLE_SUNAT = 8;
	
	@Autowired
	public CalendarioGestionService calendarioGestionService;
	@Autowired
	public CatalogoDetalleService catalogoDetalleService;
	
    public void iniciarEnvioCorreoCierrePeriodo(String idUnidadMinera){
    	
		CalendarioGestion calendario = calendarioGestionService.obtieneCalendarioGestionPorIdUnidadMinera(idUnidadMinera);
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(calendario.getFechaFin());
		cal.add(Calendar.DATE, calendario.getDiasTolerancia());

		if (date.after(cal.getTime()) && calendario.getAperturado().equals("S")) {
			String cuerpoCorreo = "Estimado Usuario necesita cerrar el periodo enero, por favor ingresar al aplicativo.";
			String titulo = "Notificacion de Cierre de Periodo";
			
			List<CatalogoDetalle> listEncargado = catalogoDetalleService.listaCatalogoDetalleByIdCatalogo(CORREO_ENCARGADO_CIERRE);
			List<CatalogoDetalle> listResponsableSunat = catalogoDetalleService.listaCatalogoDetalleByIdCatalogo(RESPONSABLE_SUNAT);
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
			
			MailUtil.enviarEmail(Constantes.MAIL_HOST, Constantes.MAIL_REMITENTE
						, correosEncargados,correosCopias, titulo, cuerpoCorreo);
		}
			
    	
	}

   
}

