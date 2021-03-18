package br.univates.dao;

import br.univates.model.Cliente;
import br.univates.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivroDao
{

    private final Connection connection;

    public LivroDao(Connection connection)
    {
        this.connection = connection;
    }

    public Livro insert(Livro livro) throws SQLException
    {
        String sql = "INSERT INTO livro (isbn, ano, titulo, is_disponivel, autor_id, "
                + "editora_id, categoria_id) VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, livro.getIsbn());
        statement.setInt(2, livro.getAno());
        statement.setString(3, livro.getTitulo());
        statement.setBoolean(4, livro.isDisponivel());
        statement.setInt(5, livro.getAutorId());
        statement.setInt(6, livro.getEditoraId());
        statement.setInt(7, livro.getCategoriaId());

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next())
        {
            int id = resultSet.getInt("id");
            livro.setId(id);
        }
        return livro;
    }

    public void update(Cliente cliente) throws SQLException
    {
        String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, cpf = ?, "
                + "email = ?, telefone = ?, celular = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getSobrenome());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getEmail());
        statement.setString(5, cliente.getTelefone());
        statement.setString(6, cliente.getCelular());
        statement.setInt(7, cliente.getId());

        statement.execute();
    }

    public void delete(int id) throws SQLException
    {
        String sql = "DELETE FROM cliente WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();
    }

    private ArrayList<Cliente> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<Cliente> clientes = new ArrayList<>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String sobrenome = resultSet.getString("sobrenome");
            String cpf = resultSet.getString("cpf");
            String email = resultSet.getString("email");
            String telefone = resultSet.getString("telefone");
            String celular = resultSet.getString("celular");

            Cliente cliente = new Cliente(id, nome, sobrenome, cpf, email, telefone, celular);
            clientes.add(cliente);
        }
        return clientes;
    }

    public ArrayList<Cliente> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM cliente";

        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    public Cliente selectPorId(int id) throws SQLException
    {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        return pesquisa(statement).get(0);
    }

}
