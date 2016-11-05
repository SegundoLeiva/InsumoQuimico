package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name="proveedor")
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prov")
	private Long id;

	@Column(name="des_prov")
	private String desProv;

	@Column(name="ruc_prov")
	private String rucProv;

	@Column(name="dir_prov")
	private String dirProv;

	private Integer estado;

	public Proveedor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesProv() {
		return desProv;
	}

	public void setDesProv(String desProv) {
		this.desProv = desProv;
	}

	public String getRucProv() {
		return rucProv;
	}

	public void setRucProv(String rucProv) {
		this.rucProv = rucProv;
	}

	public String getDirProv() {
		return dirProv;
	}

	public void setDirProv(String dirProv) {
		this.dirProv = dirProv;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
