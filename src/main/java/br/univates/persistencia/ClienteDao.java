package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.negocio.Usuario;
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
