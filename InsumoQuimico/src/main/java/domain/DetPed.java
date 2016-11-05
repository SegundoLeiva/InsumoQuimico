package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the det_ped database table.
 * 
 */
@Entity
@Table(name="det_ped")
@NamedQuery(name="DetDoc.findAll", query="SELECT d FROM DetPed d")
public class DetPed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Integer cantidad;

	@Column(name="cod_pro")
	private Long codPro;

	@Column(name="num_ped")
	private String numPed;

	@Column(name="num_serie")
	private String numSerie;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	public DetPed() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getCodPro() {
		return this.codPro;
	}

	public void setCodPro(Long codPro) {
		this.codPro = codPro;
	}

	public String getNumPed() {
		return this.numPed;
	}

	public void setNumPed(String numPed) {
		this.numPed = numPed;
	}

	public String getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}