package servicio;

import entidad.Rol;

public interface RolServicio  extends Servicio<Rol> {
	
	Rol traer(long id);

}
