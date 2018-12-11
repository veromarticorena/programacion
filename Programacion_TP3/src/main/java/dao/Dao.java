package dao;

public interface Dao<T> {
	
	public void agregar(T t);
    public void modificar(T t);
    public void eliminar(T t);

	
}
