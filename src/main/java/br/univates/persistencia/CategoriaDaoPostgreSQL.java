package br.univates.persistencia;

import br.univates.negocio.Categoria;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDaoPostgreSQL implements CategoriaDao
{
    private final DataBaseConnectionManager connection;

    public CategoriaDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
    }
    
    @Override
    public Categoria read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM categoria WHERE id = '" + id + "'";
        Categoria categoria = null;

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                rs.next();
                int id_categoria = rs.getInt("id");
                String nome = rs.getString("nome");
                categoria = new Categoria(id_categoria, nome);
            }

        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return categoria;
    }

    @Override
    public ArrayList<Categoria> readAll() throws DataBaseException
    {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM categoria";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    Categoria categoria = new Categoria(id, nome);
                    categorias.add(categoria);
                }
            }

        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return categorias;
    }

    @Override
    public void create(Categoria entity) throws DataBaseException, DuplicateKeyException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Categoria entity) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Categoria entity) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria readName(String name) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
