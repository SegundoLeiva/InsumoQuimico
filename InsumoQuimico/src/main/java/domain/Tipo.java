package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nrotipo;

	private String tipo;

	public Tipo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrotipo() {
		return this.nrotipo;
	}

	public void setNrotipo(String nrotipo) {
		this.nrotipo = nrotipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}