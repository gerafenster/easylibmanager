package br.univates.controller;

import br.univates.dao.Conexao;
import br.univates.dao.Md5;
import br.univates.view.CadastroUsuarioView;
import br.univates.model.Usuario;
import br.univates.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroUsuarioController
{

    private CadastroUsuarioView view;

    public CadastroUsuarioController(CadastroUsuarioView view)
    {
        this.view = view;
    }

    public void salvarUsuario()
    {

        String nome = view.getjTextFieldNome().getText();
        String sobrenome = view.getjTextFieldSobrenome().getText();
        String login = view.getjTextPaneLogin().getText();
        String senha = Md5.getMd5(view.getjPasswordFieldSenha().getText());
        String cpf = view.getjFormattedTextFieldCpf().getText();
        Usuario usuario = new Usuario(nome, sobrenome, login, senha, cpf);

        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDao dao = new UsuarioDao(conexao);
            dao.insert(usuario);
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            view.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
