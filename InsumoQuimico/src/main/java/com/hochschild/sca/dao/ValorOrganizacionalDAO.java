package com.hochschild.sca.dao;

import com.hochschild.sca.domain.ValorOrganizacional;
import java.util.List;

public interface ValorOrganizacionalDAO {

    public List<ValorOrganizacional> getValoresOrganizacionales(int idAplicacion,String idUsuario, String idEstructura);
}
