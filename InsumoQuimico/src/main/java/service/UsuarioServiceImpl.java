
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import domain.Usuario;
import repository.UsuarioDao;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDao usuarioDao;
	
	 public Usuario getUser(String login) {
         return usuarioDao.getUser(login);
     }


	public Boolean validarPassword(String password, String username) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String passwordEncoder = encoder.encodePassword(password, null);
		String passwordUser = this.usuarioDao.getPassword(username);
		if (passwordEncoder.equals(passwordUser)) {
			return true;
		} else {
			return false;
		}

	}



	public void cambiarPassword(String password, String username) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String passwordEncoder = encoder.encodePassword(password, null);
		
		Usuario user = this.usuarioDao.getUser(username);
		user.setPassword(passwordEncoder);
		this.usuarioDao.cambiarPassword(user);
		
	}

	
}

