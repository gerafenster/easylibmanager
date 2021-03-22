package br.univates.controller;

import br.univates.dao.AutorDao;
import br.univates.dao.CategoriaDao;
import br.univates.dao.ClienteDao;
import br.univates.dao.Conexao;
import br.univates.dao.EditoraDao;
import br.univates.dao.LivroDao;
import br.univates.dao.Validacao;
import br.univates.model.Autor;
import br.univates.model.Editora;
import br.univates.model.Livro;
import br.univates.view.CadastroClienteView;
import br.univates.view.CadastroLivroView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroLivroController
{

    private CadastroLivroView view;

    public CadastroLivroController(CadastroLivroView view)
    {
        this.view = view;
    }

    public void buscarCategorias()
    {
        try
        {
            Connection conexao;
            conexao = new Conexao().getConnection();
            CategoriaDao categoriaDao = new CategoriaDao(conexao);
            for (int i = 0; i < categoriaDao.selectAll().size(); i++)
            {
                view.getjComboBoxCategoria().addItem(categoriaDao.selectAll().get(i).getNome());
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(CadastroLivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarCampos()
    {
        boolean isbn = Validacao.validarIsbn(view.
                getjFormattedTextFieldIsbn().getText());
        boolean ano = Validacao.validarAno(Integer.parseInt(view.getjFormattedTextFieldAno().getText()));

        if (isbn && ano)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void salvarLivro()
    {
        String isbn = view.getjFormattedTextFieldIsbn().getText();
        int ano = Integer.parseInt(view.getjFormattedTextFieldAno().getText());
        String titulo = view.getjTextFieldTitulo().getText();
        boolean disponivel = true;
        int categoriaId = view.getjComboBoxCategoria().getSelectedIndex() + 1;

        String nomeCompletoAutor = view.getjTextFieldAutor().getText();

        String nomeEditora = view.getjTextFieldEditora().getText();

        Autor autor;
        Editora editora;

        try
        {
            Connection conexao = new Conexao().getConnection();
//  Verificar se autor já existe. Se não existe, inserir no BD.
            AutorDao autorDao = new AutorDao(conexao);
            if (autorDao.existeNoBancoNomeCompleto(nomeCompletoAutor))
            {
                autor = autorDao.selectPorNomeCompleto(titulo);
            }
            else
            {
                autor = new Autor(nomeCompletoAutor);
                autorDao.insert(autor);
            }
//  Verificar se editora já existe. Se não existe, inserir no BD.
            EditoraDao editoraDao = new EditoraDao(conexao);
            if (editoraDao.existeNoBancoNome(nomeEditora))
            {
                editora = editoraDao.selectPorNome(nomeEditora);
            }
            else
            {
                editora = new Editora(nomeEditora);
                editoraDao.insert(editora);
            }
//  Por último, inserir o livro no BD.
            LivroDao livroDao = new LivroDao(conexao);
            Livro livro = new Livro(isbn, ano, titulo, disponivel, autor.getId(), editora.getId(), categoriaId);
            livroDao.insert(livro);

        } catch (SQLException ex)
        {
            Logger.getLogger(CadastroLivroController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
