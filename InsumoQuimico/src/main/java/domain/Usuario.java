package domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;

	private String password;

	private String usuario;
	
	@Column(name="cod_usu")
	private String codUsu;

	public Usuario() {
	}

	public Long getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}
	
	

}