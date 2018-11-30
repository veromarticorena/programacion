package servicio;

import java.util.List;

public interface Servicio<T> {
	
	public void agregar(T t);
    public void modificar(T t);
    public void eliminar(T t);
    public List<T> listar();
    public T traer(long id);    
}
