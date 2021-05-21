    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Autor;
import br.univates.negocio.Categoria;
import br.univates.negocio.Editora;
import br.univates.negocio.Livro;
import br.univates.system32.db.Filter;

/**
 *
 * @author cristian
 */
public class LivroFiltro implements Filter<Livro>
{

    private Livro livro;

    public LivroFiltro(Livro livro)
    {
        this.livro = livro;
    }

    @Override
    public boolean isApproved(Livro livro)
    {
        if (this.livro == livro)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedIsbn(String isbn)
    {
        if (this.livro.getIsbn() == isbn)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedAno(int ano)
    {
        if (this.livro.getAno() == ano)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedTitulo(String titulo)
    {
        if (this.livro.getTitulo().contains(titulo))
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedDisponivel(boolean disponivel)
    {
        if (this.livro.isDisponivel() == disponivel)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedAutor(Autor autor)
    {
        if (this.livro.getAutor() == autor)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedEditora(Editora editora)
    {
        if (this.livro.getEditora() == editora)
        {
            return true;
        }
        return false;
    }

    public boolean isApprovedCategoria(Categoria categoria)
    {
        if (this.livro.getCategoria() == categoria)
        {
            return true;
        }
        return false;
    }

}
