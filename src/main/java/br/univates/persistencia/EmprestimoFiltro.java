package br.univates.persistencia;

import br.univates.negocio.Emprestimo;
import br.univates.negocio.Livro;
import br.univates.system32.db.Filter;

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
