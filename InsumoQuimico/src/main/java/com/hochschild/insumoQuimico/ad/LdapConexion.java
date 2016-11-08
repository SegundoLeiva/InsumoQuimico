package com.hochschild.insumoQuimico.ad;

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.ldap.*;

public class LdapConexion {

    public Hashtable<String, String> env = null;
    public LdapContext ctx = null;
    public int resulConnect = 0;

    public LdapConexion(String ldapURL) {
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.PROVIDER_URL, ldapURL);

        try {
            ctx = new InitialLdapContext(env, null);
        } catch (CommunicationException e) {
            resulConnect = 1;
            //e.printStackTrace();
        } catch (NamingException e) {
            resulConnect = 2;
            e.printStackTrace();
        }
    }

    public boolean Autentica(String username, String password) {
        try {
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, username);
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
            ctx.reconnect(null);
            return true;
        } catch (AuthenticationException e) {
            //e.printStackTrace();
            return false;
        } catch (NamingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
