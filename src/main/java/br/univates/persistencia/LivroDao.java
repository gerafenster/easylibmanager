package br.univates.persistencia;

import br.univates.negocio.Livro;
import br.univates.negocio.Usuario;
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
