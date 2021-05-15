package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDaoPostgreSQL implements ClienteDao
{

    private DataBaseConnectionManager connection;

    public ClienteDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
        //this.conexao = SistemaAgenda.getInstance().getDataBase();

    }

    @Override
    public void create(Cliente cliente) throws DataBaseException
    {
        if (cliente != null)
        {
            String sql = "INSERT INTO cliente (nome, sobrenome, cpf, email, telefone, celular) "
                    + "VALUES('" + cliente.getNome() + "', '" + cliente.getSobrenome() + "', '" + cliente.getCpf()
                    + "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getCelular() + "')";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Cliente Nulo");
        }
    }

    @Override
    public void edit(Cliente cliente) throws DataBaseException
    {
        if (cliente != null)
        {
            String sql = "UPDATE cliente SET nome = '" + cliente.getNome() + "', sobrenome = '"
                    + cliente.getSobrenome() + "', cpf = '" + cliente.getCpf() + "', " + "email = '" + cliente.getEmail()
                    + "', telefone = '" + cliente.getTelefone() + "', celular = '" + cliente.getCelular() + "' WHERE id = "
                    + cliente.getId() + "";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Cliente Nulo");
        }
    }

    @Override
    public void delete(Cliente cliente) throws DataBaseException
    {
        if (cliente != null)
        {
            String sql = "DELETE FROM cliente WHERE id = " + cliente.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Id nula");
        }
    }

    @Override
    public Cliente read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM cliente WHERE id = " + id;
        Cliente cliente = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String telefone = rs.getString("telefone");
                    String celular = rs.getString("celular");
                    cliente = new Cliente(nome, sobrenome, cpf, email, telefone, celular);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> readAll() throws DataBaseException
    {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM cliente ORDER BY id";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String telefone = rs.getString("telefone");
                    String celular = rs.getString("celular");
                    Cliente cliente = new Cliente(id, nome, sobrenome, cpf, email, telefone, celular);
                    clientes.add(cliente);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return clientes;
    }


    @Override
    public ArrayList read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente readName(String name) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
