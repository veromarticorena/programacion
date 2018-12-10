package Clases;


public class CierreMensual {
	
	protected Long legajo;
	protected String nombre;
	protected String apellido;
	protected long horas_licencia;
	protected long horas_trabajadas;
	protected long total_horas;
	protected float valor_total_horas;
	
	
	public Long getLegajo() {
		return legajo;
	}
	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getHoras_licencia() {
		return horas_licencia;
	}
	public void setHoras_licencia(long horas_licencia) {
		this.horas_licencia = horas_licencia;
	}
	public long getHoras_trabajadas() {
		return horas_trabajadas;
	}
	public void setHoras_trabajadas(long horas_trabajadas) {
		this.horas_trabajadas = horas_trabajadas;
	}
	public long getTotal_horas() {
		return total_horas;
	}
	public void setTotal_horas(long total_horas) {
		this.total_horas = total_horas;
	}
	public float getValor_total_horas() {
		return valor_total_horas;
	}
	public void setValor_total_horas(float valor_total_horas) {
		this.valor_total_horas = valor_total_horas;
	}
	
	
}
