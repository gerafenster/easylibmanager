package br.univates.dao;

import br.univates.model.Categoria;
import br.univates.model.Usuario;
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
