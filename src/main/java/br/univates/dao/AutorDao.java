package br.univates.dao;

import br.univates.model.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutorDao
{

    private final Connection connection;

    public AutorDao(Connection connection)
    {
        this.connection = connection;
    }

    public Autor insert(Autor autor) throws SQLException
    {
        String sql = "INSERT INTO autor (nome_completo) VALUES (?)";

        PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, autor.getNomeCompleto());

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            autor.setId(id);
        }
        return autor;
    }

    public void update(Autor autor) throws SQLException
    {
        String sql = "UPDATE autor SET nome_completo = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, autor.getNomeCompleto());
        statement.setInt(2, autor.getId());

        statement.execute();
    }

    public void delete(int id) throws SQLException
    {
        String sql = "DELETE FROM autor WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();
    }

    private ArrayList<Autor> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<Autor> autores = new ArrayList<>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nomeCompleto = resultSet.getString("nome_completo");

            Autor autor = new Autor(id, nomeCompleto);

            autores.add(autor);
        }
        return autores;
    }

    public ArrayList<Autor> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM autor";

        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    public Autor selectPorId(int id) throws SQLException
    {
        String sql = "SELECT * FROM autor WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoId(int id) throws SQLException
    {

        String sql = "SELECT * FROM autor WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();

//      Armazena resultado da query e verifica se existe uma próxima linha
//      com o next(). Se existe uma nova linha ele retorna True.
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

    public Autor selectPorNomeCompleto(String nomeCompleto) throws SQLException
    {
        String sql = "SELECT * FROM autor WHERE nome_completo = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, nomeCompleto);

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoNomeCompleto(String nomeCompleto) throws SQLException
    {

        String sql = "SELECT * FROM autor WHERE nome_completo = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, nomeCompleto);

        statement.execute();

//      Armazena resultado da query e verifica se existe uma próxima linha
//      com o next(). Se existe uma nova linha ele retorna True.
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

}
