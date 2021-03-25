package br.univates.dao;

import br.univates.model.Cliente;
import br.univates.model.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface ClienteDao extends IDAO<Cliente>
{
    public Cliente readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
}
