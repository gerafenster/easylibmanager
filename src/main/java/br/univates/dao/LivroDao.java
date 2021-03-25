package br.univates.dao;

import br.univates.model.Livro;
import br.univates.model.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface LivroDao extends IDAO<Livro>
{

    public Livro readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
//    
}
