package service;

import java.io.Serializable;

import domain.Usuario;


public interface UsuarioService extends Serializable {

	public Usuario getUser(String login);

	public Boolean validarPassword(String password, String username);

	public void cambiarPassword(String password, String username);

}
