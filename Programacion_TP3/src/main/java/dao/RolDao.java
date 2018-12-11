package dao;

import entidad.Rol;

public interface RolDao extends Dao<Rol> {

	Rol traer(long id);

}
