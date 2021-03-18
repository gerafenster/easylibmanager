package br.univates.dao;

import br.univates.model.Usuario;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao
{

    private final Connection connection;

    public UsuarioDao(Connection connection)
    {
        this.connection = connection;
    }

    public Usuario insert(Usuario usuario) throws SQLException
    {
        String sql = "INSERT INTO usuario(nome, sobrenome, login, senha, cpf) "
                + "VALUES(?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSobrenome());
        statement.setString(3, usuario.getLogin());
        statement.setString(4, usuario.getSenha());
        statement.setString(5, usuario.getCpf());

        statement.execute();
        
        ResultSet resultSet = statement.getGeneratedKeys();
        
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            usuario.setId(id);
        }
        return usuario;
    }

    public void update(Usuario usuario) throws SQLException
    {
        String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, login = ?, "
                + "senha = ?, cpf = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSobrenome());
        statement.setString(3, usuario.getLogin());
        statement.setString(4, usuario.getSenha());
        statement.setString(5, usuario.getCpf());

        statement.execute();
    }

    public void delete(int id) throws SQLException
    {
        String sql = "DELETE FROM usuario WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String sobrenome = resultSet.getString("sobrenome");
            String login = resultSet.getString("login");
            String cpf = resultSet.getString("cpf");

            Usuario usuario = new Usuario(id, nome, sobrenome, login, cpf);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public ArrayList<Usuario> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM usuario";

        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    public Usuario selectPorId(int id) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, id);

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoLoginESenha(Usuario usuario) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());

        statement.execute();

//      Armazena resultado da query e verifica se existe uma próxima linha
//      com o next(). Se existe uma nova linha ele retorna True.
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
}
