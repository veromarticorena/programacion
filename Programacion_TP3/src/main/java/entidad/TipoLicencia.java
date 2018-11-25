package entidad;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table (name = "TIPO_LICENCIAS")

public class TipoLicencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)	
	protected Integer idTipoLicencia;
	
	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;


	public TipoLicencia(Integer idTipoLicencia, String descripcion) {
		super();
		this.idTipoLicencia = idTipoLicencia;
		this.descripcion = descripcion;
	}


	public TipoLicencia() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdTipoLicencia() {
		return idTipoLicencia;
	}


	public void setIdTipoLicencia(Integer idTipoLicencia) {
		this.idTipoLicencia = idTipoLicencia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
