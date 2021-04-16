/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.dao;

import br.univates.model.Usuario;
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
public class UsuarioDaoPostgreSQL implements UsuarioDao
{

    private final DataBaseConnectionManager connection;

    public UsuarioDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
    }

    @Override
    public void create(Usuario usuario) throws DataBaseException
    {
        if (usuario != null)
        {
            String sql = "INSERT INTO usuario(nome, sobrenome, login, senha, cpf) VALUES('" + usuario.getNome()
                    + "', '" + usuario.getSobrenome() + "', '" + usuario.getLogin() + "', '" + usuario.getSenha() + "', '" + usuario.getCpf() + "')";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Usuario nulo");
        }
    }

    @Override
    public void edit(Usuario usuario) throws DataBaseException
    {
        if (usuario != null)
        {
            String sql = "UPDATE usuario SET nome = '" + usuario.getNome() + "', sobrenome = '" + usuario.getSobrenome()
                    + "', login = '" + usuario.getLogin() + "', senha = '" + usuario.getSenha() + "', cpf = '" + usuario.getCpf()
                    + "' WHERE id = " + usuario.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Usuario nulo");
        }
    }

    @Override
    public void delete(Usuario usuario) throws DataBaseException
    {
        if (usuario != null)
        {
            String sql = "DELETE FROM usuario WHERE id = " + usuario.getId() + "";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Id nula");
        }
    }

    @Override
    public Usuario read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM usuario WHERE id = " + id + "";
        Usuario usuario = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                rs.next();
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String login = rs.getString("login");
                String cpf = rs.getString("cpf");
                usuario = new Usuario(id, nome, sobrenome, login, cpf);

            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return usuario;
    }

    @Override
    public ArrayList<Usuario> readAll() throws DataBaseException
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM usuario";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String login = rs.getString("login");
                    String cpf = rs.getString("cpf");
                    Usuario usuario = new Usuario(id, nome, sobrenome, login, cpf);
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public Usuario readLoginPassword(Usuario usuario) throws DataBaseException
    {
        String sql = "SELECT * FROM usuario WHERE login = '"+usuario.getLogin()+"' AND senha = '"+usuario.getSenha()+"'";
        usuario = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String login = rs.getString("login");
                    String cpf = rs.getString("cpf");
                    usuario = new Usuario(id, nome, sobrenome, login, cpf);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return usuario;
    }

    @Override
    public ArrayList<Usuario> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario readName(String name) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
