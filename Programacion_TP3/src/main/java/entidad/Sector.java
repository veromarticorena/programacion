package entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "SECTORES")

public class Sector implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_SECTOR",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)	
	protected Integer idSector;
	
	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;
	

	public Sector() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdSector() {
		return idSector;
	}


	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Sector(Integer idSector, String descripcion) {
		super();
		this.idSector = idSector;
		this.descripcion = descripcion;
	}

	
	
}
