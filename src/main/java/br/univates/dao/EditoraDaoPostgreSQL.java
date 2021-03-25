package br.univates.dao;

import br.univates.model.Editora;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditoraDaoPostgreSQL implements EditoraDao
{
    private DataBaseConnectionManager connection;

    public EditoraDaoPostgreSQL () throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
    }

    @Override
    public void create(Editora editora) throws DataBaseException
    {
        if (editora != null)
        {
            String sql = "INSERT INTO editora (nome) VALUES ('" + editora.getNome() + "')";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Editora nula");
        }
    }

    @Override
    public void edit(Editora editora) throws DataBaseException
    {
        if (editora != null)
        {
            String sql = "UPDATE editora SET nome = '" + editora.getNome() + "' WHERE id = " + editora.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Editora nula");
        }
    }

    @Override
    public void delete(Editora editora) throws DataBaseException
    {
        if (editora != null)
        {
            String sql = "DELETE FROM editora WHERE id = " + editora.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Id nula");
        }
    }

    @Override
    public Editora read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM editora WHERE id = " + id + "";
        Editora editora = null;

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                rs.next();
                int id_editora = rs.getInt("id");
                String nome = rs.getString("nome");
                editora = new Editora(id_editora, nome);
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return editora;
    }

    @Override
    public Editora readName(String nome) throws DataBaseException
    {
        String sql = "SELECT * FROM editora WHERE nome = '" + nome + "'";
        Editora editora = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                rs.next();
                int id_editora = rs.getInt("id");
                editora = new Editora(id_editora, nome);
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return editora;
    }

    @Override
    public ArrayList<Editora> readAll() throws DataBaseException
    {
        ArrayList<Editora> editoras = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM editora";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    Editora editora = new Editora(id, nome);
                    editoras.add(editora);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return editoras;
    }

    @Override
    public ArrayList<Editora> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
