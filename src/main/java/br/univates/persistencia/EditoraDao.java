package br.univates.persistencia;

import br.univates.negocio.Editora;
import br.univates.negocio.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface EditoraDao extends IDAO<Editora>
{
    
    public Editora readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
//    
}
