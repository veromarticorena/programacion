package error;

public class ErrorEmpleado {
	
	protected String dniError;
	protected String nombreError;
	protected String apellidoError;
	protected String emailError;
	protected String telefonoError;
	protected Boolean ok;
	protected String camposObligatorios;
	
	public ErrorEmpleado() {}
	
	public String getCamposObligatorios() {
		return camposObligatorios;
	}
	public void setCamposObligatorios(String camposObligatorios) {
		this.camposObligatorios = camposObligatorios;
	}	
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getDniError() {
		return dniError;
	}	
	public void setDniError(String dniError) {
		this.dniError = dniError;
	}
	public String getNombreError() {
		return nombreError;
	}
	public void setNombreError(String nombreError) {
		this.nombreError = nombreError;
	}
	public String getApellidoError() {
		return apellidoError;
	}
	public void setApellidoError(String apellidoError) {
		this.apellidoError = apellidoError;
	}
	
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getTelefonoError() {
		return telefonoError;
	}
	public void setTelefonoError(String telefonoError) {
		this.telefonoError = telefonoError;
	}
	
}
