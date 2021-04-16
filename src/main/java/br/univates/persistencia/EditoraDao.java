package br.univates.dao;

import br.univates.model.Editora;
import br.univates.model.Usuario;
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
