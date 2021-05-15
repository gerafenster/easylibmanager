/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Emprestimo;
import br.univates.negocio.Livro;
import br.univates.system32.db.Filter;

/**
 *
 * @author cristian
 */
public class EmprestimoFiltro implements Filter<Emprestimo>
{

    private Livro livro;

    public EmprestimoFiltro(Livro livro)
    {
        this.livro = livro;
    }

    @Override
    public boolean isApproved(Emprestimo emprestimo)
    {
        if (livro.getId() == emprestimo.getLivro().getId())
        {
            return true;
        }
        return false;
    }
}
