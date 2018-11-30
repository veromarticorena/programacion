package dao;

import java.util.List;

public interface Dao<T> {
	
	public void agregar(T t);
    public void modificar(T t);
    public void eliminar(T t);
    public T traer(Long id);
    public List<T> listar();
	
}
