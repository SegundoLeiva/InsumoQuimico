package com.hochschild.insumoQuimico.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hochschild.insumoQuimico.ad.LdapSeguridad;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.DivisionesCIA;
import com.hochschild.insumoQuimico.domain.OpcionApp;
import com.hochschild.insumoQuimico.domain.Usuario;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;
import com.hochschild.insumoQuimico.service.CalendarioGestionService;
import com.hochschild.insumoQuimico.service.DivisionesCIAService;
import com.hochschild.insumoQuimico.service.OpcionesAppService;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.sca.domain.PuestoPorUsuario;
import com.hochschild.sca.service.PuestoPorUsuarioService;
import com.hochschild.sca.service.ValorOrganizacionalService;

@Controller
public class LoginController {
    
    private LdapSeguridad ldapSeguridad = new LdapSeguridad();
    

    @Autowired
    private OpcionesAppService opcionesAppService;
    @Autowired
    private PuestoPorUsuarioService puestoPorUsuarioService;
    @Autowired
    private ValorOrganizacionalService valorOrganizacionalService;
    @Autowired
    private DivisionesCIAService divisionesCIAService; 
    @Autowired
	public CalendarioGestionService calendarioGestionService;
    
    
    @RequestMapping(value="/login.htm", method=RequestMethod.POST)
    public ModelAndView login(HttpServletRequest req) {  
    	ModelAndView model = new ModelAndView();
    	String idUsuario = req.getParameter("idUsuario");
        String clave = req.getParameter("clave");
    	String mensaje = "";
        if(idUsuario != null){
            try{
                Integer resultado = -1;
                Usuario usuario = new Usuario();
                usuario.setIdAmbienteUnidadMinera("1303");

                ResourceBundle bundle = ResourceBundle.getBundle("aplicacion");
                String idAplicacion = bundle.getString("aplicacion.idAplicacion");
                String seguridadAutentica = bundle.getString("aplicacion.usarAutenticacionLDAP");
                String idUnidadMinera = bundle.getString("idUnidadMinera.aplicacion.central");

                req.setAttribute("idUnidadMinera", idUnidadMinera);
                req.setAttribute("versionBD", "1.0");

                if(seguridadAutentica.equals("1")){
                    resultado = ldapSeguridad.autenticaUsuario(idUsuario, clave, idUnidadMinera) ? 1 : 2;
                }else{
                    resultado = 1;
                }

                switch (resultado) {
                    case 1:
                        HttpSession session = req.getSession();              
                        
                        List<OpcionApp> listaOpcionesApp = opcionesAppService.listaOpcionesApp(idAplicacion, idUsuario);                        
                                                
                        if(listaOpcionesApp != null && listaOpcionesApp.size()>0){
                            PuestoPorUsuario puestoPorUsuario = puestoPorUsuarioService.getPuestoPorUsuario(idUsuario);
                            if(puestoPorUsuario != null){
                                usuario.setIdUsuario(idUsuario);
                                usuario.setNombre(puestoPorUsuario.getNombreUsuario()!=null?puestoPorUsuario.getNombreUsuario():"");
                                usuario.setSociedadUsuario(puestoPorUsuario.getSociedadUsuario()!=null?puestoPorUsuario.getSociedadUsuario():"");
                                usuario.setDivisionUsuario(puestoPorUsuario.getDivisionUsuario()!=null?puestoPorUsuario.getDivisionUsuario():"");
                                usuario.setEsUsuarioLogistica(esUsuarioLogistica(listaOpcionesApp));
                                usuario.setLst_opciones(listaOpcionesApp);
                                cargaValoresOrganizacionales(idAplicacion,usuario,idUnidadMinera);                                                             
                                session.setAttribute("puestoPorUsuario", puestoPorUsuario);                                
                                session.setAttribute("session_usuario", usuario);
//                                obtenerFlagCierreMes(session, usuario);
            					
                                return new ModelAndView("redirect:/home/bienvenida.htm");
                            }else{
                                mensaje = "Ud. no tiene acceso al sistema."; 
                            }
                        }else{
                            mensaje = "Ud. no tiene acceso al sistema."; 
                        }
                        break;
                    case 2:
                        mensaje = "Verifique usuario y password.";
                        break;
                    case 0:
                        mensaje = "Fallo la conexion con LDAP, contacte a mesa de ayuda.";
                        break;
                    case 3:
                        mensaje = "No se encontro su email en el LDAP, contacte a mesa de ayuda.";
                        break;
                    default:
                        mensaje = "Error en el vector de  servidores LDAP.";
                        break;
                }
                if(!mensaje.equals("")){
                	  model.setViewName("templatelogin");
                      model.addObject("mensajeError", "Credenciales incorrectos, intente nuevamente.");
                }
            }catch(Exception e){
            	model.addObject("mensajeError", "Credenciales incorrectos, intente nuevamente.");
                e.printStackTrace();
            }
        }else{
        	 model.setViewName("templatelogin");
        }
        return model;
    }
    
    @RequestMapping(value = "/login.htm")
	public String login() {

		return "templatelogin";
	}
    
    private boolean esUsuarioLogistica(List<OpcionApp> listaOpcionesApp){
        for(OpcionApp opcionApp : listaOpcionesApp){
            if( opcionApp.getIdOpcion().intValue()== Constantes.ID_OPCION_LOGISTICA.intValue() 
            	&& !"#".equals(opcionApp.getLinkOpcion() )
            	){
                return true;
            }
        }
        return false;
    }
    
    private void cargaValoresOrganizacionales(String idAplicacion, Usuario usuario, String idUnidadMinera){
        List<ValorOrganizacionalSesion> listaValoresOrganizaciones = new ArrayList<ValorOrganizacionalSesion>();
        List<ValorOrganizacionalSesion> listaUnidadesMineras = valorOrganizacionalService.getValores(idAplicacion, usuario.getIdUsuario(), "WERKS");
        if (listaUnidadesMineras != null && listaUnidadesMineras.size() > 0) {            
            for(ValorOrganizacionalSesion vos : listaUnidadesMineras){
//                if(vos.getValorOrganizacional().equals(idUnidadMinera)){
                    listaValoresOrganizaciones.add(vos);
//                }
            }            
        }else{
            DivisionesCIA divisionesCIA =  divisionesCIAService.obtenerDivisionesCIAPorId(usuario.getSociedadUsuario(), usuario.getDivisionUsuario());
            if(divisionesCIA != null){
                ValorOrganizacionalSesion valorOrganizacionalSesion = new ValorOrganizacionalSesion();
                valorOrganizacionalSesion.setValorOrganizacional(divisionesCIA.getIdUnidadMinera());
                valorOrganizacionalSesion.setDescripcion(divisionesCIA.getDivision());
                valorOrganizacionalSesion.setTipoValorOrganizacional("WERKS");
                listaValoresOrganizaciones.add(valorOrganizacionalSesion);
            }
        }        
        usuario.setLst_valoresOrganizacionales(listaValoresOrganizaciones);
        List<ValorOrganizacionalSesion> listaUnidadesMinerasGetValoresDescripcion = valorOrganizacionalService.getValoresDescripcion(usuario.getLst_valoresOrganizacionales());
        usuario.setListaUnidadesMineras(listaUnidadesMinerasGetValoresDescripcion);
        usuario.setIdUnidadMineraPorDefecto(valorOrganizacionalService.getIdUnidadMineraPorDefecto(listaUnidadesMinerasGetValoresDescripcion));
    }
	
	
	@RequestMapping(value = "/accessDenied.htm")
	public ModelAndView accessDenied(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error403");
	}
	
	@RequestMapping(value = "/noFound.htm")
	public ModelAndView noFound(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error404");
	}
	
	@RequestMapping(value="/logout.htm", method={RequestMethod.GET})
    public String logout(HttpServletRequest req, HttpServletResponse res) {
    	HttpSession session = req.getSession();
    	session.invalidate();
    	return "templatelogin";
    }
	
	@RequestMapping(value="/expirarSession.htm", method={RequestMethod.GET})
    public String expirarSession(HttpServletRequest req, HttpServletResponse res) {
    	HttpSession session = req.getSession();
    	session.invalidate();
    	req.setAttribute("expiro", "true");
    	return "templatelogin";
    }
	
	public void obtenerFlagCierreMes(HttpSession session, Usuario usuario){
		   CalendarioGestion calendario = calendarioGestionService.obtieneCalendarioGestionPorIdUnidadMinera(usuario.getIdUnidadMineraPorDefecto());
           Date date = new Date();
           
           Calendar cal = Calendar.getInstance(); 
           cal.setTime(calendario.getFechaFin()); 
           cal.add(Calendar.DATE, calendario.getDiasTolerancia());
           
			if(!(date.after(calendario.getFechaInicio()) && date.before(cal.getTime()) && calendario.getAperturado().equals("S"))){
				session.setAttribute("flagCierreMes", "C");
			}
	}
    
}
