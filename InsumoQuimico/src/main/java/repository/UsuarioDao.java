package repository;

import domain.Usuario;


public interface UsuarioDao {

	public Usuario getUser(String login);
	public String getPassword(String username);
	public void cambiarPassword(Usuario usuario);
}

