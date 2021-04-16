package br.univates.persistencia;

import br.univates.negocio.Categoria;
import br.univates.negocio.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface CategoriaDao extends IDAO<Categoria>
{
    public Categoria readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
}
