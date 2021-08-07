package br.univates.system32.db;

import java.util.ArrayList;

public interface IDAO<T> 
{
    public void create( T entity ) throws DataBaseException,DuplicateKeyException;
    public void edit( T entity ) throws DataBaseException;
    public void delete( T entity ) throws DataBaseException;
    public T read( int id ) throws DataBaseException;
    public ArrayList<T> read( Filter filter ) throws DataBaseException;
    public ArrayList<T> readAll() throws DataBaseException;
}
