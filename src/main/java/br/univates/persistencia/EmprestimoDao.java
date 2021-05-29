package br.univates.persistencia;

import br.univates.negocio.Emprestimo;
import br.univates.negocio.Livro;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface EmprestimoDao extends IDAO<Emprestimo>
{
        
    public Emprestimo readLivroEmprestado(Livro livro) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
//    
}
