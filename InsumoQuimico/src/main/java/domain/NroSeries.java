package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nroSeries database table.
 * 
 */
@Entity
@Table(name="nro_series")
@NamedQuery(name="NroSeries.findAll", query="SELECT n FROM NroSeries n")
public class NroSeries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ser")
	private Long ID;

	@Column(name="id_pro")
	private Long idPro;

	@Column(name="nro_ser")
	private String nroSer;

	@Column(name="det_ser")
	private String detSer;


	public NroSeries() {
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getIdPro() {
		return idPro;
	}

	public void setIdPro(Long idPro) {
		this.idPro = idPro;
	}

	public String getNroSer() {
		return nroSer;
	}

	public void setNroSer(String nroSer) {
		this.nroSer = nroSer;
	}

	public String getDetSer() {
		return detSer;
	}

	public void setDetSer(String detSer) {
		this.detSer = detSer;
	}



}
