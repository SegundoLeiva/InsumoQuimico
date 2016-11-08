package com.hochschild.insumoQuimico.ad;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LdapSeguridad{

    public boolean autenticaUsuario(String username, String password,String idUnidadMinera) {
        String[] ipServidoresLdap = new String[10];
        String   ipNom = "";
        try {
        ResourceBundle bundle = ResourceBundle.getBundle("ldap");
        for(int i=1;i<10;i++){
            ipNom = bundle.getString(idUnidadMinera+"_IP_LDAP"+i).trim();
            ipServidoresLdap[i] = ipNom;
        }
        } catch(MissingResourceException e) {
          
        }

        boolean isAutenticacion = false;

        for (String ldapIP : ipServidoresLdap) {
            String ldapURL = "ldap://" + ldapIP;
            LdapConexion ctx = new LdapConexion(ldapURL);
            if (ctx.resulConnect == 0) {
                isAutenticacion = ctx.Autentica("HOCHSCHILD\\" + username, password);
                ctx.close();
                break;
            } else {
                continue;
            }

        }
        return isAutenticacion;
    }
}
