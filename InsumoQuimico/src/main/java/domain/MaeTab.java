package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mae_tab database table.
 * 
 */
@Entity
@Table(name="mae_tab")
@NamedQuery(name="MaeTab.findAll", query="SELECT m FROM MaeTab m")
public class MaeTab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mae")
	private Long id;

	@Column(name="cod_des")
	private String codDes;

	@Column(name="cod_opc")
	private Integer codOpc;

	private String descripcion;

	private Integer estado;

	public MaeTab() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodDes() {
		return this.codDes;
	}

	public void setCodDes(String codDes) {
		this.codDes = codDes;
	}

	public Integer getCodOpc() {
		return this.codOpc;
	}

	public void setCodOpc(Integer codOpc) {
		this.codOpc = codOpc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}