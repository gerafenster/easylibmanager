package br.univates.persistencia;

import br.univates.negocio.Emprestimo;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
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
//            INSERT INTO emprestimo (data_emprestimo, cliente_id, livro_id) values ('2000-02-02', 1, 1)
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Emprestimo> readAll() throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
