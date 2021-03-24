package br.univates.dao;

import br.univates.system32.db.DataBaseException;

public class DaoFactory
{

    public static ClienteDao newClienteDao() throws DataBaseException
    {
        return new ClienteDaoPostgreSQL();
    }

    public static LivroDao newLivroDao() throws DataBaseException
    {
        return new LivroDaoPostgreSQL();
    }
    
    public static AutorDao newAutorDao() throws DataBaseException
    {
        return new AutorDaoPostgreSQL();
    }

    public static EditoraDao newEditoraDao() throws DataBaseException
    {
        return new EditoraDaoPostgreSQL();
    }    
    
    public static UsuarioDao newUsuarioDao() throws DataBaseException
    {
        return new UsuarioDaoPostgreSQL();
    }
}
