/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.dao;

import br.univates.model.Autor;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class AutorDaoPostgreSQL implements AutorDao
{
    private DataBaseConnectionManager connection;
    
    public AutorDaoPostgreSQL () throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
    }
    
    @Override
    public void create(Autor autor) throws DataBaseException
    {
        if (autor != null)
        {
            String sql = "INSERT INTO autor (nome_completo) VALUES ('"+autor.getNomeCompleto()+"')";

            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Autor nulo");
        }
    }

    @Override
    public void edit(Autor autor) throws DataBaseException
    {
        if (autor != null)
        {
            String sql = "UPDATE autor SET nome_completo = '"+autor.getNomeCompleto()+"' WHERE id = '"+autor.getId()+"'";

            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Autor nulo");
        }
    }

    @Override
    public void delete(Autor autor) throws DataBaseException
    {
        if (autor != null)
        {
            String sql = "DELETE FROM autor WHERE id = '"+autor.getId()+"'";

            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Id nula");
        }
    }

    @Override
    public Autor read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM autor WHERE id = "+id+"";
        Autor autor = null;

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                rs.next();
                String nomeCompleto = rs.getString("nome_completo");
                autor = new Autor(id, nomeCompleto);
            }

        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return autor;
    }

    @Override
    public Autor readName(String nomeCompleto) throws DataBaseException
    {
        String sql = "SELECT * FROM autor WHERE nome = '"+nomeCompleto+"'";
        Autor autor = null;

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                rs.next();
                int id_autor = rs.getInt("id");
                autor = new Autor(id_autor, nomeCompleto);
            }

        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return autor;
    }

    @Override
    public ArrayList<Autor> readAll() throws DataBaseException
    {
        ArrayList<Autor> autores = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM autor";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nomeCompleto = rs.getString("nome_completo");

                    Autor autor = new Autor(id, nomeCompleto);

                    autores.add(autor);
                }
            }

        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return autores;
    }

    @Override
    public ArrayList<Autor> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
