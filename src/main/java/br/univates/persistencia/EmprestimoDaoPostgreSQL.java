package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.negocio.Emprestimo;
import br.univates.negocio.Livro;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoDaoPostgreSQL implements EmprestimoDao
{

    private DataBaseConnectionManager connection;
    private ClienteDao clienteDao;
    private LivroDao livroDao;

    public EmprestimoDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
        clienteDao = DaoFactory.newClienteDao();
        livroDao = DaoFactory.newLivroDao();
    }

    @Override
    public void create(Emprestimo emprestimo) throws DataBaseException, DuplicateKeyException
    {
        if (emprestimo != null)
        {
            String sql = "INSERT INTO emprestimo (data_emprestimo, cliente_id, livro_id) values "
                    + "('" + emprestimo.getDataEmprestimo().toString() + "', "
                    + "" + emprestimo.getCliente().getId() + ", "
                    + "" + emprestimo.getLivro().getId() + ")";
            connection.runSQL(sql);

        }
        else
        {
            throw new DataBaseException("Emprestimo Nulo");
        }

    }

    @Override
    public void edit(Emprestimo entity) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Emprestimo entity) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emprestimo read(int id) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Emprestimo> read(Filter filter) throws DataBaseException
    {
        ArrayList<Emprestimo> emprestimosFiltrados = new ArrayList();
        ArrayList<Emprestimo> emprestimos = this.readAll();
        for (Emprestimo emprestimo : emprestimos)
        {
            if (filter.isApproved(emprestimo))
            {
                emprestimosFiltrados.add(emprestimo);
            }
        }
        return emprestimosFiltrados;
    }

    @Override
    public ArrayList<Emprestimo> readAll() throws DataBaseException
    {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM emprestimo ORDER BY id";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    LocalDate dataEmprestimo = LocalDate.parse(rs.getString("data_emprestimo"));
                    LocalDate dataDevolução;
                    if (rs.getString("data_devolucao").equals(""))
                    {
                        dataDevolução = null;
                    }
                    else
                    {
                        dataDevolução = LocalDate.parse(rs.getString("data_devolucao"));
                    }
                    clienteDao = DaoFactory.newClienteDao();
                    Cliente cliente = clienteDao.read(rs.getInt("cliente_id"));
                    livroDao = DaoFactory.newLivroDao();
                    Livro livro = livroDao.read(rs.getInt("livro_id"));
                    Emprestimo emprestimo = new Emprestimo(id, dataEmprestimo, dataDevolução, cliente, livro);
                    emprestimos.add(emprestimo);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return emprestimos;
    }

}
