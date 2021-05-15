/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Livro;
import br.univates.system32.db.Filter;

/**
 *
 * @author cristian
 */
public class LivroFiltro implements Filter<Livro>
{

    private String isbn;

    public LivroFiltro(String isbn)
    {
        this.isbn = isbn;
    }

    @Override
    public boolean isApproved(Livro livro)
    {
        if (livro.getIsbn().equals(isbn))
        {
            return true;
        }
        return false;
    }

}
