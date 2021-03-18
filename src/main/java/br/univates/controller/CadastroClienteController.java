package br.univates.controller;

import br.univates.dao.ClienteDao;
import br.univates.dao.Conexao;
import br.univates.model.Cliente;
import br.univates.view.CadastroClienteView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroClienteController
{

    private CadastroClienteView view;

    public CadastroClienteController(CadastroClienteView view)
    {
        this.view = view;
    }

    public void salvarCliente()
    {
        String nome = view.getjTextFieldNome().getText();
        String sobrenome = view.getjTextFieldSobrenome().getText();
        String cpf = view.getjFormattedTextFieldCpf().getText();
        String email = view.getjTextFieldEmail().getText();
        String telefone = view.getjFormattedTextFieldTelefone().getText();
        String celular = view.getjFormattedTextFieldCelular().getText();
        Cliente cliente = new Cliente(nome, sobrenome, cpf, email, telefone, celular);

        try {
            Connection conexao = new Conexao().getConnection();
            ClienteDao dao = new ClienteDao(conexao);
            dao.insert(cliente);
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            view.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
