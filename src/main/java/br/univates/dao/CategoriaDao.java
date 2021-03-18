package br.univates.dao;

import br.univates.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDao
{

    private final Connection connection;

    public CategoriaDao(Connection connection)
    {
        this.connection = connection;
    }

    private ArrayList<Categoria> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<Categoria> categorias = new ArrayList<>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");

            Categoria categoria = new Categoria(id, nome);

            categorias.add(categoria);
        }
        return categorias;
    }

    public ArrayList<Categoria> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM categoria";

        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    public Categoria selectPorId(int id) throws SQLException
    {
        String sql = "SELECT * FROM categoria WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        return pesquisa(statement).get(0);
    }

}
