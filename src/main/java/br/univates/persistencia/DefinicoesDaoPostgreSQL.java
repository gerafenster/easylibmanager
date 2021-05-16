/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.negocio.Definicoes;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class DefinicoesDaoPostgreSQL implements DefinicoesDao
{

    private DataBaseConnectionManager connection;

    public DefinicoesDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
        //this.conexao = SistemaAgenda.getInstance().getDataBase();

    }

    @Override
    public void create(Definicoes entity) throws DataBaseException, DuplicateKeyException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Definicoes definicoes) throws DataBaseException
    {
//        UPDATE definicoes SET valor_multa = '0.75', prazo_emprestimo = '10';
        if (definicoes != null)
        {
            String sql = "UPDATE definicoes SET valor_multa = '" + String.valueOf(definicoes.getValorMulta()) + "', "
                    + "prazo_emprestimo = '" + String.valueOf(definicoes.getPrazoEmprestimo()) + "'";
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Cliente Nulo");
        }
    }

    @Override
    public void delete(Definicoes entity) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Definicoes read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM definicoes";
        Definicoes definicoes = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    BigDecimal valorMulta = rs.getBigDecimal("valor_multa");
                    int prazoEmprestimo = rs.getInt("prazo_emprestimo");
                    definicoes = new Definicoes(valorMulta, prazoEmprestimo);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return definicoes;
    }

    @Override
    public ArrayList<Definicoes> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Definicoes> readAll() throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
