package br.univates.dao;

import br.univates.model.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EditoraDao
{

    private final Connection connection;

    public EditoraDao(Connection connection)
    {
        this.connection = connection;
    }

    public Editora insert(Editora editora) throws SQLException
    {
        String sql = "INSERT INTO editora (nome) VALUES (?)";

        PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, editora.getNome());

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next())
        {
            int id = resultSet.getInt("id");
            editora.setId(id);
        }
        return editora;
    }

    public void update(Editora editora) throws SQLException
    {
        String sql = "UPDATE editora SET nome = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, editora.getNome());
        statement.setInt(2, editora.getId());

        statement.execute();
    }

    public void delete(int id) throws SQLException
    {
        String sql = "DELETE FROM editora WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();
    }

    private ArrayList<Editora> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<Editora> editoras = new ArrayList<>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");

            Editora editora = new Editora(id, nome);

            editoras.add(editora);
        }
        return editoras;
    }

    public ArrayList<Editora> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM editora";

        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    public Editora selectPorId(int id) throws SQLException
    {
        String sql = "SELECT * FROM editora WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoId(int id) throws SQLException
    {

        String sql = "SELECT * FROM editora WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();

//      Armazena resultado da query e verifica se existe uma próxima linha
//      com o next(). Se existe uma nova linha ele retorna True.
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

    public Editora selectPorNome(String nome) throws SQLException
    {
        String sql = "SELECT * FROM editora WHERE nome = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, nome);

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoNome(String nome) throws SQLException
    {

        String sql = "SELECT * FROM editora WHERE nome = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, nome);

        statement.execute();

//      Armazena resultado da query e verifica se existe uma próxima linha
//      com o next(). Se existe uma nova linha ele retorna True.
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

}
