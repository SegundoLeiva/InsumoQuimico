package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="cod_prov")
	private Long codProv;

	@Column(name="cod_usu")
	private String codUsu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_date")
	private Date fecDate;

	@Column(name="fec_reg")
	private Timestamp fecReg;

	@Column(name="num_ped")
	private String numPed;

	public Pedido() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodProv() {
		return this.codProv;
	}

	public void setCodProv(Long codProv) {
		this.codProv = codProv;
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

	public String getNumPed() {
		return this.numPed;
	}

	public void setNumPed(String numPed) {
		this.numPed = numPed;
	}

}