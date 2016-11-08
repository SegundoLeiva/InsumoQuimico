package com.hochschild.sca.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;

public interface ValorOrganizacionalService {
    public List<ValorOrganizacionalSesion> getValores(String idAplicacion,String idUsuario, String idEstructura);
    public List<ValorOrganizacionalSesion> getValoresDescripcion(List<ValorOrganizacionalSesion> valores);        
    public String getIdUnidadMineraPorDefecto(List<ValorOrganizacionalSesion> valores);
}
