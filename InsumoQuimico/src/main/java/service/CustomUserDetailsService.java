

package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.UsuarioDao;
import domain.CustomerUser;
import domain.Usuario;





@Service
@Transactional (readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UsuarioDao userDAO;
	
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String login)
	            throws UsernameNotFoundException {	 
	       Usuario domainUser = userDAO.getUser(login);
//	       SecurityRolUser domainPerfil = userDAO.getPerfil(domainUser.getId());
	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	        return new CustomerUser(
	                domainUser.getUsuario(),
	                domainUser.getPassword(),
	                enabled,
	                accountNonExpired,
	                credentialsNonExpired,
	                accountNonLocked,
	                getAuthorities(domainUser.getCodUsu()),
	                		domainUser.getCodUsu(),domainUser.getUsuario() 
	        );
	    }
	
	
	@SuppressWarnings("rawtypes")
	public List getAuthorities(String role) {
		        List authList = getGrantedAuthorities(role);
		        return authList;
		    }
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getGrantedAuthorities(String roles) {
    List authorities = new ArrayList();
    
    
    	            authorities.add(new SimpleGrantedAuthority(roles));
    	        

   
    return authorities;
    }




	
	
	

}
