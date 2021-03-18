package br.univates.controller;

import br.univates.dao.Conexao;
import br.univates.dao.Md5;
import br.univates.dao.UsuarioDao;
import br.univates.model.Usuario;
import br.univates.view.LoginView;
import br.univates.view.MenuView;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController
{

    private LoginView view;

    public LoginController(LoginView view)
    {
        this.view = view;
    }

    public void autenticar() throws SQLException
    {
        String login = view.getjTextFieldLogin().getText();
        String senha = Md5.getMd5(view.getjPasswordFieldSenha().getText());

        Usuario usuarioAutenticar = new Usuario(login, senha);

        Connection conexao = new Conexao().getConnection();
        UsuarioDao usuarioDao = new UsuarioDao(conexao);

        boolean existe = usuarioDao.existeNoBancoLoginESenha(usuarioAutenticar);

        if (existe) {
            MenuView telaMenu = new MenuView();
            view.dispose();
            telaMenu.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
        }
    }
}
