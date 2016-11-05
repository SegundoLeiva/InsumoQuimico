package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="cod_usu")
	private String codUsu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_date")
	private Date fecDate;

	@Column(name="fec_reg")
	private Timestamp fecReg;

	@Column(name="num_ven")
	private String numVen;

	public Venta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodUsu() {
		return this.codUsu;
	}

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}

	public Date getFecDate() {
		return this.fecDate;
	}

	public void setFecDate(Date fecDate) {
		this.fecDate = fecDate;
	}

	public Timestamp getFecReg() {
		return this.fecReg;
	}

	public void setFecReg(Timestamp fecReg) {
		this.fecReg = fecReg;
	}

	public String getNumVen() {
		return this.numVen;
	}

	public void setNumVen(String numVen) {
		this.numVen = numVen;
	}

}