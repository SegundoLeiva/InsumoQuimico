package domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class CustomerUser extends User {

	private String codUsu;
	private String usuario;


	public CustomerUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean CredentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,String codUsu,String usuario) {
		super(username, password, enabled, accountNonExpired,
				CredentialsNonExpired, accountNonLocked, authorities);
		this.codUsu = codUsu;
		this.usuario = usuario;
	}

	public CustomerUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities,String codUsu,String usuario) {
		this(username, password, true, true, true, true, authorities,codUsu,usuario);
	}

	public String getCodUsu() {
		return codUsu;
	}
	public String getusuario() {
		return usuario;
	}
	



}
