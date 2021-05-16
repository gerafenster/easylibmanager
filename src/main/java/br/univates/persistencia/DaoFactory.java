package br.univates.persistencia;

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

    public static CategoriaDao newCategoriaDao() throws DataBaseException
    {
        return new CategoriaDaoPostgreSQL();
    }

    public static EmprestimoDao newEmprestimoDao() throws DataBaseException
    {
        return new EmprestimoDaoPostgreSQL();
    }
    
    public static DefinicoesDao newDefinicoesDao() throws DataBaseException
    {
        return new DefinicoesDaoPostgreSQL();
    }

}
