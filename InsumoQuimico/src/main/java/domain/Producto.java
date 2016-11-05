package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproductos")
	private Long id;

	@Column(name = "cod_categoria")
	private Long codCategoria;

	@Column(name = "cod_marca")
	private Long codMarca;

	@Column(name = "codigo_productos")
	private String codigo;

	private Integer estado;

	@Column(name = "fec_reg")
	private Timestamp fecReg;

	@Column(name = "nombre_productos")
	private String nombre;

	private Integer stock;

	@Column(name = "cod_usu")
	private String codUsu;

	public Producto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(Long codCategoria) {
		this.codCategoria = codCategoria;
	}

	public Long getCodMarca() {
		return this.codMarca;
	}

	public void setCodMarca(Long codMarca) {
		this.codMarca = codMarca;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecReg() {
		return this.fecReg;
	}

	public void setFecReg(Timestamp fecReg) {
		this.fecReg = fecReg;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}

}