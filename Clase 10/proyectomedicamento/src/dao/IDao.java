package dao;

import java.util.List;

public interface IDao<T>{
    T guardar(T t);
    T buscarPorNombre(String nombre);
    List<T> buscarTodos();
}
